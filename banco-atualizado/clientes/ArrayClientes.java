package clientes;

public class ArrayClientes {
 
    private Cliente[] clientes;
    private int indice;
 
    public ArrayClientes(int quantidadeMaxima){
        this.clientes = new Cliente[quantidadeMaxima];
        this.indice = 0;
    }

    public boolean adicionar(Cliente cliente){
        if (cliente == null || cliente.getCpf() == null){
            return false;
        }
        if (existe(cliente.getCpf())){
            return false;
        }
        if (estaCheio()){
            return false;
        }
        this.clientes[this.indice] = cliente;
        this.indice++;
        return true;
    }

    public boolean remover(String cpf){
        int posicao = getPosicao(cpf);
        if (posicao == -1){
            return false;
        }
        for (int x = posicao; x < this.indice - 1; x++){
            this.clientes[x] = this.clientes[x + 1];
        }
        this.indice--;
        this.clientes[this.indice] = null;
        return true;
    }
 
    private int getPosicao(String cpf){
        if (cpf == null){
            return -1;
        }
        for (int pos = 0; pos < this.indice; pos++){
            if (cpf.equals(this.clientes[pos].getCpf())){
                return pos;
            }
        }
        return -1;
    }
 
    public boolean existe(String cpf){
        return getPosicao(cpf) != -1;
    }

    public Cliente buscar(String cpf){
        int posicao = getPosicao(cpf);
        if (posicao == -1){
            return null;
        }
        return this.clientes[posicao];
    }
 
    public Cliente getCliente(int posicao){
        if (posicao < 0 || posicao >= this.indice){
            return null;
        }
        return this.clientes[posicao];
    }
 
    public int getQuantidade(){
        return this.indice;
    }
 
    public boolean estaCheio(){
        return this.indice == this.clientes.length;
    }
 
    public void listar(){
        if (this.indice == 0){
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < this.indice; i++){
            this.clientes[i].show();
        }
    }
}