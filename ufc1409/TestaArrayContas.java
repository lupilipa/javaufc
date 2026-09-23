public class TestaArrayContas {
    public static void main(String[] args){

        //criando banco, clientes e contas
        ArrayContas banco = new ArrayContas(4);
        Cliente carmen = new Cliente("12345678900", "Carmen");
        Cliente luana = new Cliente("12345678999", "Luana");
        Conta contaCarmen = new Conta(2000.00, carmen);

        // inserindo no banco e criando ao inserir
        banco.inserir(contaCarmen);
        banco.inserir(new Conta(3000.00, luana));

        // testando o número da conta:
        System.out.println(contaCarmen.getNumero());
        System.out.println();

        Conta teste = banco.pesquisar(4);
        Conta teste2 = banco.pesquisar(1);

        System.out.println();
        System.out.println("Nome do Cliente: "+ teste2.getCliente().getNome());

        System.out.println();
        banco.remover(4);

        Conta novaContaCarmen = new Conta(10000.00, carmen);
        //banco.inserir(novaContaCarmen);
        banco.atualizar(novaContaCarmen);
    }
}
