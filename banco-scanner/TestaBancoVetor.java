import java.util.Scanner;

public class TestaBancoVetor {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BancoVetor banco = new BancoVetor("UFCBank");
        int opcao;

        do {
            System.out.println("\n=== Menu " + banco.getNome() + " ===");
            System.out.println("1 - Adicionar conta");
            System.out.println("2 - Buscar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir entre contas");
            System.out.println("6 - Remover conta");
            System.out.println("7 - Exibir relatório do banco");
            System.out.println("8 - Exibir maior correntista");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro(scanner);

            switch (opcao){
                case 1 -> adicionarConta(banco, scanner);
                case 2 -> buscarConta(banco, scanner);
                case 3 -> depositar(banco, scanner);
                case 4 -> sacar(banco, scanner);
                case 5 -> transferir(banco, scanner);
                case 6 -> removerConta(banco, scanner);
                case 7 -> banco.exibirRelatorio();
                case 8 -> mostrarMaiorCorrentista(banco);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarConta(BancoVetor banco, Scanner scanner){
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = lerDouble(scanner);

        Cliente cliente = new Cliente(cpf, nome);
        Conta conta = new Conta(saldo, cliente);

        if (banco.adicionarConta(conta)){
            System.out.println("Conta criada com sucesso! Número da conta: " + conta.getNumero());
        } else {
            System.out.println("Não foi possível criar a conta.");
        }
    }

    private static void buscarConta(BancoVetor banco, Scanner scanner){
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if (conta != null){
            conta.show();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void depositar(BancoVetor banco, Scanner scanner){
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if (conta == null){
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Valor do depósito: ");
        double valor = lerDouble(scanner);

        conta.depositar(valor);
        System.out.println("Depósito realizado. Novo saldo: " + conta.getSaldo());
    }

    private static void sacar(BancoVetor banco, Scanner scanner){
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if (conta == null){
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Valor do saque: ");
        double valor = lerDouble(scanner);

        if (conta.sacar(valor)){
            System.out.println("Saque realizado. Novo saldo: " + conta.getSaldo());
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    private static void transferir(BancoVetor banco, Scanner scanner){
        System.out.print("Número da conta de origem: ");
        String origem = scanner.nextLine();

        System.out.print("Número da conta de destino: ");
        String destino = scanner.nextLine();

        System.out.print("Valor a transferir: ");
        double valor = lerDouble(scanner);

        if (banco.transferir(origem, destino, valor)){
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível transferir (conta inexistente ou saldo insuficiente).");
        }
    }

    private static void removerConta(BancoVetor banco, Scanner scanner){
        System.out.print("Número da conta a remover: ");
        String numero = scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if (conta == null){
            System.out.println("Conta não encontrada.");
            return;
        }

        if (banco.removerConta(conta)){
            System.out.println("Conta removida com sucesso!");
        } else {
            System.out.println("Não foi possível remover a conta.");
        }
    }

    private static void mostrarMaiorCorrentista(BancoVetor banco){
        Cliente maiorAcionista = banco.getMaiorAcionista();
        if (maiorAcionista == null){
            System.out.println("Não existem contas no banco.");
        } else {
            maiorAcionista.show();
        }
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. Digite um número inteiro: ");
            scanner.next(); 
        }

        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor inválido. Digite um número (ex: 100.50): ");
            scanner.next();
        }
        
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}