import java.util.Scanner;

public class TesteScanner {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        /*double valor = scanner.nextDouble();
        System.out.println("Valor: "+ valor);
        System.out.println("Digite uma string");
        String s = scanner.next();
        System.out.println("Valor String: "+ s);*/

        System.out.println("Digite o cpf: ");
        String cpf = scanner.nextLine().trim();
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine().trim();
        System.out.println("Digite a idade: ");
        while (!scanner.hasNextInt()){
            System.out.println("Valor Inválido");
            scanner.next();
        }
        //int idade = Integer.parseInt(scanner.nextLine().trim());
        int idade = scanner.nextInt();
        Cliente c = new Cliente(cpf, nome);

        c.show();

        scanner.close();
    }
}