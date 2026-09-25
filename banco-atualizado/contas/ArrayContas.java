package contas;

import clientes.ArrayClientes;
import clientes.Cliente;

public class ArrayContas {
 
    private Conta[] contas;
    private int indice;
    private ArrayClientes clientes;
 
    public ArrayContas(int quantidadeMaxima, ArrayClientes clientes){
        this.contas = new Conta[quantidadeMaxima];
        this.indice = 0;
        this.clientes = clientes;
    }

    public boolean adicionar(Conta conta){
        if (conta == null || conta.getNumero() == null){
            return false;
        }
        if (estaCheio() || existe(conta.getNumero())){
            return false;
        }
        Cliente titular = conta.getCliente();
        if (titular == null){
            return false;
        }
        Cliente cadastrado = this.clientes.buscar(titular.getCpf());
        if (cadastrado != titular){
            return false;
        }
        this.contas[this.indice] = conta;
        this.indice++;
        return true;
    }
 
    public Conta criarConta(String cpf, double saldoInicial){
        Cliente titular = this.clientes.buscar(cpf);
        if (titular == null || estaCheio()){
            return null; 
        }
        Conta conta = new Conta(saldoInicial, titular);
        this.contas[this.indice] = conta;
        this.indice++;
        return conta;
    }
 
    public boolean remover(String numero){
        int posicao = getPosicao(numero);
        if (posicao == -1) {
            return false;
        }
        for (int x = posicao; x < this.indice - 1; x++){
            this.contas[x] = this.contas[x + 1];
        }
        this.indice--;
        this.contas[this.indice] = null;
        return true;
    }
 
    private int getPosicao(String numero){
        if (numero == null){
            return -1;
        }
        for (int pos = 0; pos < this.indice; pos++){
            if (numero.equals(this.contas[pos].getNumero())){
                return pos;
            }
        }
        return -1;
    }
 
    public boolean existe(String numero){
        return getPosicao(numero) != -1;
    }
 
    public Conta buscar(String numero){
        int posicao = getPosicao(numero);
        if (posicao == -1){
            return null;
        }
        return this.contas[posicao];
    }
 
    public Conta getConta(int posicao){
        if (posicao < 0 || posicao >= this.indice){
            return null;
        }
        return this.contas[posicao];
    }
 
    public int getQuantidade(){
        return this.indice;
    }
 
    public boolean estaCheio(){
        return this.indice == this.contas.length;
    }

    public int contarContasDoCliente(String cpf){
        int total = 0;
        if (cpf == null){
            return 0;
        }
        for (int i = 0; i < this.indice; i++){
            if (cpf.equals(this.contas[i].getCliente().getCpf())){
                total++;
            }
        }
        return total;
    }
 
    public boolean clientePossuiContas(String cpf){
        return contarContasDoCliente(cpf) > 0;
    }
 
    public void listarContasDoCliente(String cpf){
        boolean achou = false;
        for (int i = 0; i < this.indice; i++){
            if (cpf != null && cpf.equals(this.contas[i].getCliente().getCpf())){
                this.contas[i].show();
                achou = true;
            }
        }
        if (!achou){
            System.out.println("Nenhuma conta para o CPF " + cpf + ".");
        }
    }
 
    public void listar(){
        if (this.indice == 0){
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        for (int i = 0; i < this.indice; i++){
            this.contas[i].show();
        }
    }
}