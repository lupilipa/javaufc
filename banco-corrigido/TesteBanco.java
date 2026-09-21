public class TesteBanco {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Java");

        Cliente cliente1 = new Cliente("111.111.111-11", "Ana");
        Cliente cliente2 = new Cliente("222.222.222-22", "Bruno");
        Cliente cliente3 = new Cliente("333.333.333-33", "Carla");

        System.out.println("Proximo numero antes de criar contas: " + Conta.getProximoNumero());

        Conta conta1 = new Conta(1000.0, cliente1);
        Conta conta2 = new Conta(500.0, cliente2);
        Conta conta3 = new Conta(1500.0, cliente3);

        System.out.println("Adicionando contas ao banco:");
        System.out.println("Conta " + conta1.getNumero() + " adicionada? " + banco.adicionarConta(conta1));
        System.out.println("Conta " + conta2.getNumero() + " adicionada? " + banco.adicionarConta(conta2));
        System.out.println("Conta " + conta3.getNumero() + " adicionada? " + banco.adicionarConta(conta3));

        System.out.println();
        System.out.println("Relatorio inicial:");
        banco.exibirRelatorio();

        System.out.println();
        System.out.println("Buscando a conta " + conta2.getNumero() + ":");
        Conta contaEncontrada = banco.buscarConta(conta2.getNumero());

        if (contaEncontrada != null) {
            contaEncontrada.show();
        } else {
            System.out.println("Conta nao encontrada.");
        }

        System.out.println();
        System.out.println("Transferindo R$ 200.0 da conta " + conta1.getNumero() + " para a conta " + conta2.getNumero() + ":");
        boolean transferenciaRealizada = banco.transferir(conta1.getNumero(), conta2.getNumero(), 200.0);
        System.out.println("Transferencia realizada? " + transferenciaRealizada);

        System.out.println();
        System.out.println("Dados apos a transferencia:");
        banco.exibirRelatorio();

        System.out.println();
        System.out.println("Resumo do banco:");
        System.out.println("Nome: " + banco.getNome());
        System.out.println("Quantidade de contas: " + banco.getQuantidadeContas());
        System.out.println("Patrimonio liquido: " + banco.getPatrimonioLiquido());
        System.out.println("Saldo medio: " + banco.getSaldoMedio());

        Cliente maiorAcionista = banco.getMaiorAcionista();
        if (maiorAcionista != null) {
            System.out.println("Maior acionista: " + maiorAcionista.getNome());
        }

        System.out.println();
        System.out.println("Removendo a conta " + conta2.getNumero() + ":");
        boolean contaRemovida = banco.removerConta(conta2);
        System.out.println("Conta removida? " + contaRemovida);

        System.out.println();
        System.out.println("Relatorio final:");
        banco.exibirRelatorio();
    }
}
