public class Conta {

    private String numero;
    private double saldo;
    private Cliente cliente;

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        this.saldo = saldo + valor;
    }

    public boolean sacar(double valor) {
        if (this.saldo - valor > 0){
            this.saldo = saldo - valor;
            return true;
        }
        return false;
    }

    public void aplicarRendimento(double taxaPercentual) {
        double rendimento = (saldo/100) * taxaPercentual;
        saldo = saldo + rendimento;
    }

    public void show() {
        System.out.println("Conta("+ getNumero() +")");
        System.out.println("Saldo: "+ getSaldo());
        if (this.cliente != null){
            cliente.show();
        }
    }
}