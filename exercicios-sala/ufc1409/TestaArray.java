public class TestaArray{
    public static void main(String[] args){
        /*
        várias formas de iniciar e imprimir:

        int[] pares;
        int pares[];
        int pares[] = new int[10];
        int[] pares = new int[10];

        pares = new int [10];

        for (int i=0; i<10; i++){
            System.out.println(pares[i]);
        }
        for (int i=0; i<pares.length; i++){
            System.out.println(pares[i]);
        }

        */

        int pares [] = {2,4,6,8,10,12,14,16,18,20};
        for (int n : pares){
            System.out.println(n);
        }

        // não vai mostrar:
        //System.out.println(pares[15]);

        int impares [] = {1,3,5,7,9};
        for (int i = 2; i < 5-1; i++){
            impares[i] = impares[i+1];
            System.out.println(impares[i]);
        }

        // array multidimensional
        int[][] m = new int[3][4]; // 3 linhas, 4 colunas
        m[1][2] = 7;

        System.out.println(m.length); 
        System.out.println(m[0].length); 

        int[][] j = new int[3][]; // linhas irregulares
        j[0] = new int[2];
        j[1] = new int[5];
        System.out.println(j[0].length); 
        System.out.println(j[1].length); 

        // acesso invalido:
        String[] nomes = {"jose", "joao", "maria"};
        System.out.println(nomes[5]);   
    }
}