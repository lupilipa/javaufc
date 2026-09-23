public class BancoVetor {

	private String nome;
    private ArrayContas minhasContas;

	public BancoVetor(String nome){
		this.nome = nome;
        this.minhasContas = new ArrayContas(10);
	}

	public void setNome(String nome){
	    this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	private boolean existeConta(String numero){
        return this.minhasContas.existe(numero);
	}

	public boolean adicionarConta(Conta conta){
		if (conta == null || conta.getNumero() == null){
			return false;
		}
		if (existeConta(conta.getNumero())){
			return false;
		}

        return this.minhasContas.adicionar(conta);
	}

	public boolean removerConta(Conta conta){
        if (conta == null || conta.getNumero() == null){
            return false;
        }

        return this.minhasContas.remover(conta.getNumero());
	}

	public double getPatrimonioLiquido(){
        double patrimonio = 0;

        for (int i = 0; i < this.minhasContas.getQuantidade(); i++) {
            patrimonio += this.minhasContas.getConta(i).getSaldo();
        }

        return patrimonio;
	}


    public Conta buscarConta(String numero){
        if (numero == null){
            return null;
        }

        return this.minhasContas.buscar(numero);
    }

    public int getQuantidadeContas(){
        return this.minhasContas.getQuantidade();
    }


    public double getSaldoMedio(){
        int quantidade = getQuantidadeContas();

        if (quantidade == 0){
            return 0.0;
        }

        return getPatrimonioLiquido() / quantidade;
    }

    public Cliente getMaiorAcionista(){
        Conta maiorConta = null;

        for (int i = 0; i < this.minhasContas.getQuantidade(); i++){
            Conta conta = this.minhasContas.getConta(i);
            if (maiorConta == null || conta.getSaldo() > maiorConta.getSaldo()){
                maiorConta = conta;
            }
        }

        if (maiorConta == null){
            return null;
        }

        return maiorConta.getCliente();
    }

    public boolean transferir(String numOrigem, String numDestino, double valor){
        Conta origem = buscarConta(numOrigem);
        Conta destino = buscarConta(numDestino);

        if (origem == null || destino == null){
            return false;
        }

        return origem.transferir(destino, valor);
    }

    public void exibirRelatorio(){
        System.out.println("Banco: " + this.nome);
        System.out.println("Quantidade de contas: " + getQuantidadeContas());
        System.out.println("Patrimônio líquido: " + getPatrimonioLiquido());
        System.out.println("Saldo Médio: " + getSaldoMedio());

        System.out.println();
        System.out.println("Listagem de contas ativas: ");
		System.out.println();
        this.minhasContas.listar();
    }
}
