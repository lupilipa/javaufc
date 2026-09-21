public class Banco{
	
	private String nome;
	private Conta conta1;
	private Conta conta2;
	private Conta conta3;

	public Banco(String nome){
		this.nome = nome;
	}

	public void setNome(String nome){
	   this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public Conta getConta1(){
		return this.conta1;
	}

	public void setConta1(Conta conta1){
		this.conta1 = conta1;
	}

	public Conta getConta2(){
		return this.conta2;
	}

	public void setConta2(Conta conta2){
		this.conta2 = conta2;
	}

	public Conta getConta3(){
		return this.conta3;
	}

	public void setConta3(Conta conta3){
		this.conta3 = conta3;
	}

	private boolean existeConta(String numero){
		return buscarConta(numero) != null;
	}

	private boolean mesmoNumero(Conta conta, String numero){
		return conta != null && numero != null && numero.equals(conta.getNumero());
	}

	public boolean adicionarConta(Conta conta){
		if (conta == null || conta.getNumero() == null){
			return false;
		}
		if (existeConta(conta.getNumero())){
			return false;
		}
		if (this.conta1 == null){
			this.conta1 = conta;
			return true;
		}
		if (this.conta2 == null){
			this.conta2 = conta;
			return true;
		}
		if (this.conta3 == null){
			this.conta3 = conta;
			return true;
		}			
		return false;
	}

	public boolean removerConta(Conta conta){
        if (conta == null || conta.getNumero() == null){
            return false;
        }
        if (mesmoNumero(this.conta1, conta.getNumero())) {
            this.conta1 = null;
            return true;
        }
        if (mesmoNumero(this.conta2, conta.getNumero())){
            this.conta2 = null;
            return true;
        }
        if (mesmoNumero(this.conta3, conta.getNumero())){
            this.conta3 = null;
            return true;
        }

        return false;
	}

	public double getPatrimonioLiquido(){
		double saldo1 = this.conta1 == null ? 0 : this.conta1.getSaldo();
		double saldo2 = this.conta2 == null ? 0 : this.conta2.getSaldo();
		double saldo3 = this.conta3 == null ? 0 : this.conta3.getSaldo();
		return saldo1 + saldo2 + saldo3;
	}

    public Conta buscarConta(String numero) {
        if (numero == null) {
            return null;
        }
        if (mesmoNumero(this.conta1, numero)) {
            return this.conta1;
        }
        if (mesmoNumero(this.conta2, numero)) {
            return this.conta2;
        }
        if (mesmoNumero(this.conta3, numero)) {
            return this.conta3;
        }

        return null;
    }

    private boolean existeContaVersao2(String numero){
        return buscarConta(numero) != null;
    }

    public int getQuantidadeContas() {
        int quantidade = 0;

        if (this.conta1 != null) {
            quantidade++;
        }
        if (this.conta2 != null) {
            quantidade++;
        }
        if (this.conta3 != null) {
            quantidade++;
        }

        return quantidade;
    }

    public double getSaldoMedio() {
        int quantidade = getQuantidadeContas();

        if (quantidade == 0) {
            return 0.0;
        }

        return getPatrimonioLiquido() / quantidade;
    }

    public Cliente getMaiorAcionista() {
        Conta maiorConta = null;

        if (this.conta1 != null) {
            maiorConta = this.conta1;
        }
        if ((this.conta2 != null) && (maiorConta == null || this.conta2.getSaldo() > maiorConta.getSaldo())) {
            maiorConta = this.conta2;
        }
        if ((this.conta3 != null) && (maiorConta == null || this.conta3.getSaldo() > maiorConta.getSaldo())) {
            maiorConta = this.conta3;
        }

        if (maiorConta == null) {
            return null;
        }

        return maiorConta.getCliente();
    }

    public boolean transferir(String numOrigem, String numDestino, double valor) {
        Conta origem = buscarConta(numOrigem);
        Conta destino = buscarConta(numDestino);

        if (origem == null || destino == null) {
            return false;
        }

        return origem.transferir(destino, valor);
    }

    public void exibirRelatorio() {
        System.out.println("Banco: " + this.nome);
        System.out.println("Quantidade de contas: " + getQuantidadeContas());
        System.out.println("Patrimônio líquido: " + getPatrimonioLiquido());
        System.out.println("Saldo médio: " + getSaldoMedio());

        if (this.conta1 != null) {
            this.conta1.show();
        }
        if (this.conta2 != null) {
            this.conta2.show();
        }
        if (this.conta3 != null) {
            this.conta3.show();
        }
    }
}
