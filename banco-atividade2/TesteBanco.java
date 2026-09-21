public class TesteBanco{
	
	public static void main(String[] s){

		System.out.println("Olá! Esse é seu Sistema Bancário!");

		// criando clientes com construtor
		Cliente carmen = new Cliente("123.123.123-12", "Carmen");
		Cliente luana = new Cliente("123.123.123-12", "Luana");

		System.out.println();
		System.out.println("Listagem de clientes:");
		carmen.show();
		System.out.println();
		luana.show();

		// testando se os cpfs sao iguais
		System.out.println();
		System.out.println("Verificando se nossos clientes possuem o mesmo cpf:");
		if (carmen.ehIgual(luana)){
			System.out.println("Sim! Mudar um dos cpfs!");
		} else {
			System.out.println("Não! Tá tudo certo. :)");
		}
 
		// criando contas com construtor
		Conta contaCarmen = new Conta(30000, carmen);
		Conta contaCarmen2 = new Conta(50000, carmen);
		Conta contaLuana = new Conta(20000, luana);

		System.out.println();
		System.out.println("Listagem de contas:");
		contaCarmen.show();
		contaCarmen2.show();
		contaLuana.show();

		// testando funcoes de conta
		System.out.println();
		System.out.println("Vamos fazer um depósito de 100.00 na conta 14200X:");
		System.out.println("Valor antes do depósito: "+ contaCarmen.getSaldo());
		contaCarmen.depositar(100.00);
		System.out.println("Valor depois do depósito: "+ contaCarmen.getSaldo());

		System.out.println();
		System.out.println("Vamos fazer um saque de 2000.00 na conta 14200X:");
		System.out.println("Valor antes do saque: "+ contaCarmen.getSaldo());
		if (contaCarmen.sacar(2000.00)){
			System.out.println("Valor depois do saque: "+ contaCarmen.getSaldo());
		} else {
			System.out.println("Saldo insuficiente! Impossível fazer o saque.");
		}

		System.out.println();
		System.out.println("Vamos aplicar um rendimento de 10% na conta 14200X:");
		contaCarmen.aplicarRendimento(10.00);
		System.out.println("Saldo pós aplique de rendimento:"+ contaCarmen.getSaldo());

		// criando banco com construtor
		Banco bancoMaio = new Banco("Banco Maio do Brasil SA");

		// testando funcoes de banco
		System.out.println();
		System.out.println("Adicionando contas ao banco:");
		System.out.println("Conta "+ contaCarmen.getNumero() +" adicionada? "+ bancoMaio.adicionarConta(contaCarmen));
		System.out.println("Conta "+ contaCarmen2.getNumero() +" adicionada? "+ bancoMaio.adicionarConta(contaCarmen2));
		System.out.println("Conta "+ contaLuana.getNumero() +" adicionada? "+ bancoMaio.adicionarConta(contaLuana));

		System.out.println();
		System.out.println("Um dos nossos bancos é o "+ bancoMaio.getNome());
		System.out.println("E seu patrimônio líquido é: "+ bancoMaio.getPatrimonioLiquido());
		System.out.println("Temos, no "+ bancoMaio.getNome() +", um total de: "+ bancoMaio.getQuantidadeContas() +" contas.");
		System.out.println("Nosso saldo médio é: "+ bancoMaio.getSaldoMedio());
		System.out.println("Maior acionista é: ");
		bancoMaio.getMaiorAcionista().show();

		System.out.println();
		System.out.println("Transferência de 10000:");
		System.out.println();
		System.out.println("Conta a receber: ");
		if (bancoMaio.buscarConta(contaCarmen.getNumero()) != null){
			contaCarmen.show();
		}
		System.out.println();
		System.out.println("Conta a enviar: ");
		if (bancoMaio.buscarConta(contaLuana.getNumero()) != null){
			contaLuana.show();
		}

		System.out.println();
		System.out.println("Resultado:");
		System.out.println();
		if (bancoMaio.transferir(contaLuana.getNumero(), contaCarmen.getNumero(), 10000.00)){
			System.out.println("Transferência concluída com sucesso!");
			System.out.println("Saldo da conta "+ contaCarmen.getNumero() +" que pertence a "+ contaCarmen.getCliente().getNome() +", é: "+ contaCarmen.getSaldo());
			System.out.println("Saldo da conta "+ contaLuana.getNumero() +" que pertence a "+ contaLuana.getCliente().getNome() +", é: "+ contaLuana.getSaldo());
		} else {
			System.out.println("Encontramos um erro na sua transferência! Não foi possível concluir a ação.");
		}

		System.out.println();
		System.out.println("Relatório do banco:");
		bancoMaio.exibirRelatorio();

		// buscando e removendo conta
		System.out.println();
		System.out.println("Buscando a conta "+ contaCarmen2.getNumero());
		Conta contaEncontrada = bancoMaio.buscarConta(contaCarmen2.getNumero());

		if (contaEncontrada != null){
			contaEncontrada.show();
		} else {
			System.out.println("Conta não encontrada");
		}

		System.out.println();
		System.out.println("Removendo a conta "+ contaCarmen2.getNumero());
		boolean contaRemovida = bancoMaio.removerConta(contaCarmen2);
		System.out.println("Foi removida? "+ contaRemovida);

		System.out.println();
		System.out.println("Relatório final do banco:");
		bancoMaio.exibirRelatorio();
	}
}