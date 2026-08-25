class OlaMundo {

    public static void main(String[] s){
        System.out.println("hello, bitches!");

        // criar um objeto modo 1:
        Cliente luana;
        luana = new Cliente();
        luana.idade = 20;
        luana.cpf = 123456;
        System.out.println("idade de luana: ");
        System.out.println(luana.idade);

        // criar um objeto modo 2:
        Cliente carmen = new Cliente();
        carmen.idade = 19;
        carmen.cpf = 987654;
        System.out.println("idade de carmen: " + carmen.idade);

        // teste booleano:
        boolean teste = (carmen == luana); //false
        System.out.println(teste);

        // mostrando um objeto:
        System.out.println(luana);

        // chamando função:
        System.out.println("anuncio: ");
        carmen.show();
    }

}