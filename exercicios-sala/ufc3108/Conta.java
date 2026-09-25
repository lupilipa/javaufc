public class Conta{
    int numAgencia;
    int numConta;
    String nomeCliente;
    double saldo;
    Cliente cliente;

    public Conta(int numAgencia, int numConta, String nomeCliente, double saldo){
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public int getNumAgencia(){
        return numAgencia;
    }

    public void setNumAgencia(int novoNumAgencia){
        numAgencia = novoNumAgencia;
    }

    public int getNumConta(){
        return numConta;
    }

    public void setNumConta(int novoNumConta){
        numConta = novoNumConta;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public void setNomeCliente(String novoNome){
        nomeCliente = novoNome;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double novoSaldo){
        saldo = novoSaldo;
    }

    public void creditar(double valor){
        double novoSaldo = saldo + valor;
        setSaldo(novoSaldo);
    }

    public void sacar(double valor){
        if (saldo - valor > 0){
            double novoSaldo = saldo - valor;
            setSaldo(novoSaldo);
        } else {
            System.out.println("saque impossível, seu saldo ficará negativo!");
        }
    }
}