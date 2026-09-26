import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static Agenda agenda = new Agenda(10);

    public static void main(String[] args){
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Opção: ");
            System.out.println();
            switch (opcao){
                case 1: adicionarContato(); break;
                case 2: listarContatos(); break;
                case 3: buscarContato(); break;
                case 4: removerContato(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
            System.out.println();
        } while (opcao != 0);
    }

    private static void exibirMenu(){
        System.out.println("Agenda de Contatos");
        System.out.println("Selecione uma opção:");
        System.out.println(" 1 - Adicionar contato");
        System.out.println(" 2 - Listar contatos");
        System.out.println(" 3 - Buscar contato");
        System.out.println(" 4 - Remover contato");
        System.out.println(" 0 - Sair");
    }

    private static void adicionarContato(){
        String nome = lerTexto("Nome: ");
        if (agenda.buscarContato(nome) != null){
            System.out.println("Contato já existe.");
            return;
        }
        String telefone = lerTexto("Telefone: ");
        String email = lerTexto("Email: ");
        if (agenda.adicionarContato(new Contato(nome, telefone, email))){
            System.out.println("Contato adicionado!");
        } else {
            System.out.println("Não foi possível adicionar contato.");
        }
    }

    private static void listarContatos(){
        agenda.listarContatos();
    }

    private static void buscarContato(){
        String nome = lerTexto("Nome: ");
        if (agenda.buscarContato(nome) == null){
            System.out.println("Contato não encontrado.");
        } else {
            agenda.buscarContato(nome).show();
        }
    }

    private static void removerContato(){
        String nome = lerTexto("Nome: ");
        if (agenda.buscarContato(nome) == null){
            System.out.println("Contato não encontrado.");
            return;
        }
        if (agenda.removerContato(nome)){
            System.out.println("Contato removido!");
        } else {
            System.out.println("Não foi possível remover contato.");
        }
    }

    private static String lerTexto(String mensagem){
        System.out.println(mensagem);
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
}