public class ArrayContas{

    private Conta[] contas;
    private int indice = 0;
    private int tam;

    public ArrayContas(int tam){
        this.tam = tam;
        contas = new Conta[tam];
    }

    public void inserir(Conta c){
        if (indice < tam){
            contas[indice] = c;
            indice = indice + 1;
        } else {
            System.out.println("Array cheio");
        }
    }

    public int procurarIndice(String num){
        for (int i = 0; i < indice; i++){
            if (contas[i].getNumero().equals(num)){
                return i;
            }
        }
        return -1;
    }

    public boolean existe(String num){
        boolean resp = false;
        int i = this.procurarIndice(num);
        if(i != -1){
            resp = true;
        }
        return resp;
    }

    public void atualizar(Conta c){
        int i = procurarIndice(c.getNumero());
        if (i != -1){
            contas[i] = c;
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public Conta pesquisar(String num){
        Conta resp = null;
        if (existe(num)){
            int i = this.procurarIndice(num);
            resp = contas[i];
        } else {
            System.out.println("Conta não encontrada");
        }
        return resp;
    }

    public void remover(String num){
        if (existe(num)){
            int ind = this.procurarIndice(num);
            for (int i = ind; i < indice-1; i++){
                contas[i] = contas[i + 1];
            }
            contas[indice-1] = null;
            indice = indice - 1;
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public void remover2(String num){
        int i = procurarIndice(num);
        if (i != -1){
            contas[i] = contas[indice-1];
            contas[indice-1] = null;
            indice = indice-1;
        } else {
            System.out.println("Conta não encontrada");
        }
    }
}