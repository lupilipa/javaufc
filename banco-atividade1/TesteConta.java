public class TesteConta{
	
	public static void main(String[] s){

		System.out.println("Olá! Esse é seu Sistema Bancário!\n");

		// criando clientes sem construtor
		Cliente carmen = new Cliente();
		carmen.setCpf("123.123.123-12");
		carmen.setNome("Carmen");

		Cliente luana = new Cliente();
		luana.setCpf("123.123.123-12");
		luana.setNome("Luana");

		System.out.println("Listagem de clientes:");
		carmen.show();
		luana.show();

		// testando se os cpfs sao iguais
		System.out.println("\nVerificando se nossos clientes possuem o mesmo cpf:");
		if (carmen.ehIgual(luana)){
			System.out.println("Sim! Mudar um dos cpfs!");
		} else {
			System.out.println("Não! Tá tudo certo. :)");
		}
 
		// criando contas sem construtor
		Conta contaCarmen = new Conta();
		contaCarmen.setNumero("14200X");
		contaCarmen.depositar(30000);
		contaCarmen.setCliente(carmen);

		Conta contaCarmen2 = new Conta();
		contaCarmen2.setNumero("14300X");
		contaCarmen2.depositar(50000);
		contaCarmen2.setCliente(carmen);

		Conta contaLuana = new Conta();
		contaLuana.setNumero("15300X");
		contaLuana.depositar(20000);
		contaLuana.setCliente(luana);

		System.out.println("\nListagem de contas:");
		contaCarmen.show();
		contaCarmen2.show();
		contaLuana.show();

		// testando funcoes de conta
		System.out.println("\nVamos fazer um depósito de 100.00 na conta 14200X:");
		System.out.println("Valor antes do depósito: "+ contaCarmen.getSaldo());
		contaCarmen.depositar(100.00);
		System.out.println("Valor depois do depósito: "+ contaCarmen.getSaldo());

		System.out.println("\nVamos fazer um saque de 2000.00 na conta 14200X:");
		System.out.println("Valor antes do saque: "+ contaCarmen.getSaldo());
		if (contaCarmen.sacar(2000.00)){
			System.out.println("Valor depois do saque: "+ contaCarmen.getSaldo());
		} else {
			System.out.println("Saldo insuficiente! Impossível fazer o saque.");
		}

		System.out.println("\nVamos aplicar um rendimento de 10% na conta 14200X:");
		contaCarmen.aplicarRendimento(10.00);
		System.out.println("Saldo pós aplique de rendimento:"+ contaCarmen.getSaldo());

		// criando banco sem construtor
		Banco bancoMaio = new Banco();
		bancoMaio.setNome("Banco Maio do Brasil SA");
		bancoMaio.adicionarConta(contaCarmen);
		bancoMaio.adicionarConta(contaCarmen2);
		bancoMaio.adicionarConta(contaLuana);

		// testando funcoes de banco
		System.out.println("\nUm dos nossos bancos é o "+ bancoMaio.getNome());
		System.out.println("E seu patrimônio líquido é: "+ bancoMaio.getPatrimonioLiquido());
		System.out.println("Temos, no "+ bancoMaio.getNome() +", um total de: "+ bancoMaio.getQuantidadeContas() +" contas.");

		System.out.println("Nosso saldo médio é: "+ bancoMaio.getSaldoMedio());

		System.out.println("Maior acionista é: ");
		bancoMaio.getMaiorAcionista().show();

		System.out.println("\nTransferência de 10000:");
		System.out.println("\nConta a receber: ");
		if (bancoMaio.buscarConta(contaCarmen.getNumero()) != null){
			contaCarmen.show();
		}
		System.out.println("\nConta a enviar: ");
		if (bancoMaio.buscarConta(contaLuana.getNumero()) != null){
			contaLuana.show();
		}

		System.out.println("\nResultado:\n");
		if (bancoMaio.transferir(contaLuana.getNumero(), contaCarmen.getNumero(), 10000.00)){
			System.out.println("Transferência concluída com sucesso!");
			System.out.println("Saldo da conta "+ contaCarmen.getNumero() +" que pertence a "+ contaCarmen.getCliente().getNome() +", é: "+ contaCarmen.getSaldo());
			System.out.println("Saldo da conta "+ contaLuana.getNumero() +" que pertence a "+ contaLuana.getCliente().getNome() +", é: "+ contaLuana.getSaldo());
		} else {
			System.out.println("Encontramos um erro na sua transferência! Não foi possível concluir a ação.");
		}

		System.out.println("\nRelatório do banco:\n");
		bancoMaio.exibirRelatorio();
	}
}