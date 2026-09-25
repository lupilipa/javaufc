public class ArrayContas {

    private Conta[] contas;
    private int indice;

    public ArrayContas(int quantidadeMaxima){
        this.contas = new Conta[quantidadeMaxima];
        this.indice = 0;
    }

    public boolean adicionar(Conta conta){
        if (indice == this.contas.length){
            return false;
        }

        this.contas[this.indice] = conta;
        this.indice++;

        return true;
    }

    public boolean remover(String numero){
        int posicao = getPosicao(numero);

        if (posicao != -1){
            for (int x = posicao; x < this.indice - 1; x++){
                this.contas[x] = this.contas[x + 1];
            }
            this.indice--;
            this.contas[this.indice] = null;
            return true;
        } else
           return false;
    }

    public boolean remover2(String numero){
        int posicao = getPosicao(numero);

        if (posicao != -1){
            this.indice--;
            this.contas[posicao] = this.contas[this.indice];
            this.contas[this.indice] = null;
            return true;
        } else
            return false;
    }

    private int getPosicao(String numero){
        int posicao = -1;

        for (int pos = 0; pos < this.indice; pos++){
            if (numero != null && numero.equals(this.contas[pos].getNumero())){
                posicao = pos;
            }
        }

        return posicao;
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

    public void listar(){
        for (int i = 0; i < this.indice; i++){
            this.contas[i].show();
        }
    }

    public static void main(String[] args){
        ArrayContas arrayContas = new ArrayContas(7);
        Cliente fernando = new Cliente("123", "Fernando");
        Conta c1 = new Conta(10, fernando);
        Conta c2 = new Conta(220, fernando);
        arrayContas.adicionar(c1);
        arrayContas.adicionar(c2);
        arrayContas.adicionar(c1);
        arrayContas.adicionar(c2);
        arrayContas.adicionar(c1);
        arrayContas.adicionar(c2);
        arrayContas.adicionar(c1);
        arrayContas.adicionar(c2);

        System.out.println("Listando contas:");
        arrayContas.listar();
    }
}