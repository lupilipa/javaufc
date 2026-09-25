import clientes.Cliente;
import contas.Conta;

import java.util.Scanner;
 
public class SistemaBancario {
 
    private static Scanner teclado = new Scanner(System.in);
    private static Banco banco = new Banco("Banco Java");
 
    public static void main(String[] args){
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Opção: ");
            System.out.println();
            switch (opcao){
                case 1: cadastrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: removerCliente(); break;
                case 4: abrirConta(); break;
                case 5: listarContasDoCliente(); break;
                case 6: removerConta(); break;
                case 7: depositar(); break;
                case 8: sacar(); break;
                case 9: transferir(); break;
                case 10: banco.exibirRelatorio(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
            System.out.println();
        } while (opcao != 0);
    }
 
    private static void exibirMenu(){
        System.out.println("===== " + banco.getNome() + " =====");
        System.out.println(" 1 - Cadastrar cliente");
        System.out.println(" 2 - Listar clientes");
        System.out.println(" 3 - Remover cliente");
        System.out.println(" 4 - Abrir conta");
        System.out.println(" 5 - Listar contas de um cliente");
        System.out.println(" 6 - Remover conta");
        System.out.println(" 7 - Depositar");
        System.out.println(" 8 - Sacar");
        System.out.println(" 9 - Transferir");
        System.out.println("10 - Relatório do banco");
        System.out.println(" 0 - Sair");
    }

    private static void cadastrarCliente(){
        String cpf = lerTexto("CPF: ");
        if (banco.existeCliente(cpf)){
            System.out.println("Já existe cliente com este CPF.");
            return;
        }
        String nome = lerTexto("Nome: ");
        if (banco.cadastrarCliente(new Cliente(cpf, nome))){
            System.out.println("clientes.Cliente cadastrado.");
        } else {
            System.out.println("Não foi possível cadastrar (cadastro cheio?).");
        }
    }
 
    private static void listarClientes(){
        banco.listarClientes();
    }
 
    private static void removerCliente(){
        String cpf = lerTexto("CPF do cliente a remover: ");
        if (!banco.existeCliente(cpf)){
            System.out.println("clientes.Cliente não encontrado.");
        } else if (banco.clientePossuiContas(cpf)){
            System.out.println("clientes.Cliente possui contas vinculadas. Remova as contas antes.");
        } else if (banco.removerCliente(cpf)){
            System.out.println("clientes.Cliente removido.");
        }
    }

    private static void abrirConta(){
        String cpf = lerTexto("CPF do titular: ");
        if (!banco.existeCliente(cpf)){
            System.out.println("clientes.Cliente não cadastrado. Cadastre-o primeiro (opção 1).");
            return;
        }
        double saldo = lerDouble("Saldo inicial: ");
        Conta conta = banco.abrirConta(cpf, saldo);
        if (conta == null){
            System.out.println("Não foi possível abrir a conta (cadastro de contas cheio?).");
        } else {
            System.out.println("contas.Conta " + conta.getNumero() + " aberta para "+ conta.getCliente().getNome() + ".");
        }
    }
 
    private static void listarContasDoCliente(){
        String cpf = lerTexto("CPF: ");
        Cliente cliente = banco.buscarCliente(cpf);
        if (cliente == null){
            System.out.println("clientes.Cliente não encontrado.");
            return;
        }
        cliente.show();
        banco.listarContasDoCliente(cpf);
        System.out.println("Saldo total: " + banco.getSaldoTotalDoCliente(cpf));
    }
 
    private static void removerConta(){
        String numero = lerTexto("Número da conta: ");
        System.out.println(banco.removerConta(numero) ? "contas.Conta removida." : "contas.Conta não encontrada.");
    }
 
    private static void depositar(){
        Conta conta = banco.buscarConta(lerTexto("Número da conta: "));
        if (conta == null){
            System.out.println("contas.Conta não encontrada.");
            return;
        }
        conta.depositar(lerDouble("Valor: "));
        System.out.println("Saldo atual: " + conta.getSaldo());
    }
 
    private static void sacar(){
        Conta conta = banco.buscarConta(lerTexto("Número da conta: "));
        if (conta == null){
            System.out.println("contas.Conta não encontrada.");
            return;
        }
        if (conta.sacar(lerDouble("Valor: "))){
            System.out.println("Saque realizado. Saldo atual: " + conta.getSaldo());
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
 
    private static void transferir(){
        String origem = lerTexto("contas.Conta de origem: ");
        String destino = lerTexto("contas.Conta de destino: ");
        double valor = lerDouble("Valor: ");
        System.out.println(banco.transferir(origem, destino, valor)
                ? "Transferência realizada."
                : "Não foi possível transferir.");
    }

    private static String lerTexto(String mensagem){
        System.out.print(mensagem);
        return teclado.nextLine().trim();
    }
 
    private static int lerInteiro(String mensagem){
        while (true){
            try {
                return Integer.parseInt(lerTexto(mensagem));
            } catch (NumberFormatException e){
                System.out.println("Digite um número inteiro.");
            }
        }
    }
 
    private static double lerDouble(String mensagem) {
        while (true){
            try {
                return Double.parseDouble(lerTexto(mensagem).replace(',', '.'));
            } catch (NumberFormatException e){
                System.out.println("Digite um valor numérico.");
            }
        }
    }
}