public class Banco{
	
	private String nome;
	private Conta conta1;
	private Conta conta2;
	private Conta conta3;

	public void setNome(String nome){
	   this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	private boolean existeConta(String numero){
		boolean retorno = false;
		if ((this.conta1 != null) && (this.conta1.getNumero().equals(numero))){
			retorno = true;
		} else if ((this.conta2 != null) && (this.conta2.getNumero().equals(numero))){
			retorno = true;
		} else  if ((this.conta3 != null) && (this.conta3.getNumero().equals(numero))){
			retorno = true;
		}
		return retorno;
	}

	public boolean adicionarConta(Conta conta){
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
        if (existeConta(conta.getNumero())){
            if (conta1.getNumero().equals(conta.getNumero())) {
                conta1 = null;
                return true;
            } else if (conta2.getNumero().equals(conta.getNumero())){
                conta2 = null;
                return true;
            } else {
                conta3 = null;
                return true;
            }
        } else
            return false;
	}

	public double getPatrimonioLiquido(){
        // this.conta1 == null ? 0 : this.conta1.getSaldo() verifica se a conta não foi inicializada, se não foi, retorna 0, se foi, chama getSaldo()
		double saldo1 = this.conta1 == null ? 0 : this.conta1.getSaldo();
		double saldo2 = this.conta2 == null ? 0 : this.conta2.getSaldo();
		double saldo3 = this.conta3 == null ? 0 : this.conta3.getSaldo();
		return saldo1 + saldo2 + saldo3;
	}

    public Conta buscarConta(String numero) {
        if ((this.conta1 != null) && (this.conta1.getNumero().equals(numero))){
            return conta1;
        } else if ((this.conta2 != null) && (this.conta2.getNumero().equals(numero))){
            return conta2;
        } else if ((this.conta3 != null) && (this.conta3.getNumero().equals(numero))){
            return conta3;
        }
        return null;
    }

    private boolean existeContaVersao2(String numero){
        if (buscarConta(numero) != null){
            return true;
        }
        return false;
    }

    public int getQuantidadeContas() {
        int quantidade = 0;
        if (this.conta1 != null){
            quantidade++;
        }
        if (this.conta2 != null){
            quantidade++;
        }
        if (this.conta3 != null){
            quantidade++;
        }
        return quantidade;
    }

    public double getSaldoMedio() {
        if (getQuantidadeContas() != 0){
            double saldoMedio = getPatrimonioLiquido() / getQuantidadeContas();
            return saldoMedio;
        }
        return 0.0;
    }

    public Cliente getMaiorAcionista() {
        if (getQuantidadeContas() != 0){
            double saldo1 = this.conta1 == null ? 0 : this.conta1.getSaldo();
		    double saldo2 = this.conta2 == null ? 0 : this.conta2.getSaldo();
		    double saldo3 = this.conta3 == null ? 0 : this.conta3.getSaldo();

            if (saldo1 > saldo2){
                if (saldo1 > saldo3){
                    return conta1.getCliente();
                } else {
                    return conta3.getCliente();
                }
            } else if (saldo2 > saldo3){
                return conta2.getCliente();
            } else {
                return conta3.getCliente();
            }
        }
        return null;
    }

    public boolean transferir(String numOrigem, String numDestino, double valor) {
        if ((existeConta(numOrigem)) && (existeConta(numDestino))){
            buscarConta(numOrigem).sacar(valor);
            buscarConta(numDestino).depositar(valor);
            return true;
        }
        return false;
    }

    public void exibirRelatorio() {
        System.out.println("Nome do Banco: "+ getNome());
        System.out.println("Quantidade de contas: "+ getQuantidadeContas());
        System.out.println("Patrimônio Líquido: "+ getPatrimonioLiquido());

        System.out.println("\nListagem de contas ativas: \n");
        if (this.conta1 != null){
            conta1.show();
        }
        if (this.conta2 != null){
            conta2.show();
        }
        if (this.conta3 != null){
            conta3.show();
        }
    }
}