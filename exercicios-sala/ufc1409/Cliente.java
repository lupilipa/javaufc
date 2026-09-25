public class Cliente{

    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

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
        System.out.println("Cliente("+ this.cpf +"): <"+ this.nome +">");
    }

    public boolean ehIgual(Cliente outro) {
        return outro != null && this.cpf != null && this.cpf.equals(outro.getCpf());
        /*if (this.cpf == outro.cpf){return true;} return false;*/
    }

    // testando validade de cliente
    public static void teste(Cliente c){
        if (c == null){
            System.out.println("O cliente não é válido");
        } else {
            System.out.println(c.getNome());
        }
    }

    public static void main(String[] args){
        Cliente.teste(null);
    }
}