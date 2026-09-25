public class Conta {

    private static int quantidadeContas = 0;

    private String numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente){
        this.numero = Conta.getProximoNumero();
        this.cliente = cliente;
    }

    public Conta(double saldo, Cliente cliente){
        this(cliente);
        setSaldo(saldo);
    }

    public static int getQuantidadeContas(){
        return Conta.quantidadeContas;
    }

    public static String getProximoNumero(){
        Conta.quantidadeContas++;
        return "" + (Conta.quantidadeContas);
    }

    public String getNumero(){
        return this.numero;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        if (saldo >= 0){
            this.saldo = saldo;
        }
    }

    public void depositar(double valor){
        if (valor > 0){
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor){
        if (valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }

        return false;
    }

    public void aplicarRendimento(double taxaPercentual){
        this.saldo += this.saldo * taxaPercentual / 100;
    }

    public boolean transferir(Conta destino, double valor){
        if (destino == null){
            return false;
        }
        if (sacar(valor)){
            destino.depositar(valor);
            return true;
        }

        return false;
    }

    public void show(){
		System.out.println();
        System.out.println("Conta("+ this.numero +")");
        System.out.println("Saldo: "+ this.saldo);
        
        if (this.cliente != null){
            this.cliente.show();
        }
    }
}