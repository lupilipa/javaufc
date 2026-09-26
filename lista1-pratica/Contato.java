public class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void show(){
        System.out.println("Nome: "+ this.nome);
        System.out.println("Telefone: "+ this.telefone);
        System.out.println("Email: "+ this.email);
        System.out.println();
    }

    public boolean estaDuplicado(Contato outro){
        return outro != null && this.telefone.equals(outro.getTelefone());
    }
}