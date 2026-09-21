public class Cliente {

    private String cpf;
    private String nome;

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void show() {
        System.out.println("Cliente("+ getCpf() +"): <"+ getNome() +"> \n");
    }

    public boolean ehIgual(Cliente outro) {
        cpf = getCpf();
        if (cpf == outro.cpf){
            return true;
        }
        return false;
    }
}