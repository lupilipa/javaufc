public class TesteConta{

    public static void main(String args[]){

        //criando cliente
        Cliente cli1 = new Cliente("12345", "Luana", "1234");

        // criando objeto
        Conta c1 = new Conta(1, 125, cli1.nome, 100.5);
        Conta c2 = new Conta(1, 123, cli1.nome, 200.5);

        // mostrando dados
        System.out.println("dona da c1: " + c1.getNomeCliente());
        System.out.println("número da agência de c1: " + c1.getNumAgencia());
        System.out.println("número da conta de c1: " + c1.numConta);
        System.out.println("saldo de c1: " + c1.saldo);

        System.out.println("dona da c2: " + c2.getNomeCliente());
        System.out.println("número da agência de c2: " + c2.getNumAgencia());
        System.out.println("número da conta de c2: " + c2.numConta);
        System.out.println("saldo de c2: " + c2.saldo);

        // testando creditar()
        double valor = 50.00;
        c1.creditar(valor);
        System.out.println("novo saldo de c1: " + c1.getSaldo());

        // testando sacar()
        c1.sacar(300.00);
        System.out.println("novo saldo de c1 pós saque: " + c1.getSaldo());
    }

}