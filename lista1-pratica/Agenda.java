public class Agenda {
    private Contato[] contatos;
    private int indice = 0;
    
    public Agenda(int quantidadeMaxima){
        this.contatos = new Contato[quantidadeMaxima];
        this.indice = 0;
    }

    public boolean adicionarContato(Contato contato){
        if (contato == null || contato.getNome() == null){
            return false;
        }
        if (buscarContato(contato.getNome()) != null){
            return false;
        }
        if (indice >= contatos.length){
            return false;
        }
        this.contatos[this.indice] = contato;
        this.indice++;
        return true;
    }

    public void listarContatos(){
        if (this.indice == 0){
            System.out.println("A agenda está vazia.");
        }
        for (int i = 0; i < this.indice; i++){
            this.contatos[i].show();
        }
    }

    private int getPosicao(String nome){
        if (nome == null){
            return -1;
        }
        for (int pos = 0; pos < this.indice; pos++){
            if (nome.equals(this.contatos[pos].getNome())){
                return pos;
            }
        }
        return -1;
    }

    public Contato buscarContato(String nome){
        int posicao = getPosicao(nome);
        if (posicao == -1){
            return null;
        }
        return this.contatos[posicao];
    }

    public boolean removerContato(String nome){
        int posicao = getPosicao(nome);
        if (posicao == -1){
            return false;
        }
        for (int i = posicao; i < this.indice - 1; i++){
            this.contatos[i] = this.contatos[i + 1];
        }
        this.indice--;
        this.contatos[this.indice] = null;
        return true;
    }
}