import clientes.ArrayClientes;
import clientes.Cliente;
import contas.ArrayContas;
import contas.Conta;

public class Banco {

    private String nome;
    private ArrayClientes meusClientes;
    private ArrayContas minhasContas;

    public Banco(String nome){
        this.nome = nome;
        this.meusClientes = new ArrayClientes(10);
        this.minhasContas = new ArrayContas(10, this.meusClientes);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean cadastrarCliente(Cliente cliente){
        return this.meusClientes.adicionar(cliente);
    }

    public Cliente buscarCliente(String cpf){
        return this.meusClientes.buscar(cpf);
    }

    public boolean existeCliente(String cpf){
        return this.meusClientes.existe(cpf);
    }

    public boolean clientePossuiContas(String cpf){
        return this.minhasContas.clientePossuiContas(cpf);
    }

    public boolean removerCliente(String cpf){
        if (!existeCliente(cpf)){
            return false;
        }
        if (clientePossuiContas(cpf)){
            return false;
        }
        return this.meusClientes.remover(cpf);
    }

    public int getQuantidadeClientes(){
        return this.meusClientes.getQuantidade();
    }

    public void listarClientes(){
        this.meusClientes.listar();
    }

    public void listarContasDoCliente(String cpf){
        this.minhasContas.listarContasDoCliente(cpf);
    }

    public Conta abrirConta(String cpf, double saldoInicial){
        return this.minhasContas.criarConta(cpf, saldoInicial);
    }

    public boolean adicionarConta(Conta conta){
        return this.minhasContas.adicionar(conta);
    }

    public boolean removerConta(String numero){
        return this.minhasContas.remover(numero);
    }

    public boolean removerConta(Conta conta){
        if (conta == null){
            return false;
        }
        return removerConta(conta.getNumero());
    }

    public Conta buscarConta(String numero){
        return this.minhasContas.buscar(numero);
    }

    public int getQuantidadeContas(){
        return this.minhasContas.getQuantidade();
    }

    public double getPatrimonioLiquido(){
        double patrimonio = 0;
        for (int i = 0; i < this.minhasContas.getQuantidade(); i++){
            patrimonio += this.minhasContas.getConta(i).getSaldo();
        }
        return patrimonio;
    }

    public double getSaldoMedio(){
        int quantidade = getQuantidadeContas();
        if (quantidade == 0) {
            return 0.0;
        }
        return getPatrimonioLiquido() / quantidade;
    }

    public Cliente getMaiorAcionista(){
        Cliente maior = null;
        double maiorTotal = -1;

        for (int i = 0; i < this.meusClientes.getQuantidade(); i++){
            Cliente cliente = this.meusClientes.getCliente(i);
            double total = getSaldoTotalDoCliente(cliente.getCpf());
            if (this.minhasContas.clientePossuiContas(cliente.getCpf()) && total > maiorTotal){
                maiorTotal = total;
                maior = cliente;
            }
        }
        return maior;
    }

    public double getSaldoTotalDoCliente(String cpf){
        double total = 0;
        for (int i = 0; i < this.minhasContas.getQuantidade(); i++){
            Conta conta = this.minhasContas.getConta(i);
            if (cpf != null && cpf.equals(conta.getCliente().getCpf())){
                total += conta.getSaldo();
            }
        }
        return total;
    }

    public boolean transferir(String numOrigem, String numDestino, double valor){
        Conta origem = buscarConta(numOrigem);
        Conta destino = buscarConta(numDestino);
        if (origem == null || destino == null) {
            return false;
        }
        return origem.transferir(destino, valor);
    }

    public void exibirRelatorio(){
        System.out.println("Banco: " + this.nome);
        System.out.println("Quantidade de clientes: " + getQuantidadeClientes());
        System.out.println("Quantidade de contas: " + getQuantidadeContas());
        System.out.println("Patrimônio líquido: " + getPatrimonioLiquido());
        System.out.println("Saldo médio: " + getSaldoMedio());

        System.out.println();
        System.out.println("Listagem de contas ativas: ");
		System.out.println();
        this.minhasContas.listar();
    }
}