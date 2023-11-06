import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

             /* {"A", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "T", "G", "T"},
                {"A", "G", "A", "A", "G", "G"},
                {"C", "C", "C", "C", "T", "A"},
                {"T", "C", "A", "C", "T", "G"} */


        String[] dna = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}; //Parcial
        //String[] dna = new String[]{"EAAAAA", "CAGTGC", "TTATGT", "AGAAGG", "CTCCTA", "TCACTG"};
        //String[] dna = new String[]{"ETGCYA", "AAGTGC", "TAATGT", "AGAAAA", "CCCATA", "TCACTG"}; //Diagonal fuera de la diagonal principal
        //String[] dna = new String[]{"ETGCYA", "AAGTGC", "TAATGT", "AGAETJ", "CCCATA", "TCACTG"}; //Falso, solo tiene una secuencia
        //String[] dna = new String[]{"ETGCYA", "AAAAGC", "TAGTGT", "AGAGTJ", "CCCAGA", "TCACTG"}; //Diagonal inversa
        //String[] dna = new String[]{"GETGCYA", "EAAAAGC", "TTAGTGT", "TAGAGTJ", "TCCCAEA", "TTCACTG"}; //Más letras
        //String[] dna = new String[]{"etgcya", "aaaagc", "tagtgt", "agagtj", "cccata", "tcactg"}; //Minusculas
        //String[] dna = new String[]{"etgCya", "aaAagc", "taGtgt", "agaGtj", "cccata", "tcActg"};  //Letras mezcladas
        //String[] dna = new String[]{"EAAAAA", "CAGTGC", "TTATGT", "AAAAGG", "CTCCTA"};

        isMutant(dna);

    }

    static boolean isMutant(String[] dna) {
        if (busqueda(dna) >= 2) {
            System.out.println("Es mutante");
            return true;
        }
        System.out.println("No es mutante");
        return false;
    }

    static int busqueda (String[] dna) {
        int contador = 0;

        //Todas las letras a mayúscula para que sean iguales
        for (int i = 0; i < dna.length; i++) {
            dna[i] = dna[i].toUpperCase();
        }

        //Busqueda horizontal
        for (int i = 0; i < dna.length; ++i) {
            for (int j = 0; j < dna.length - 3; ++j) {
                if (dna[i].charAt(j) == dna[i].charAt(j + 1)
                        && dna[i].charAt(j) == dna[i].charAt(j + 2)
                        && dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                    contador++;
                }
            }
        }

        //Busqueda vertical
        for (int i = 0; i < dna.length - 3; ++i) {
            for (int j = 0; j < dna[i].length(); ++j) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j)
                        && dna[i].charAt(j) == dna[i + 2].charAt(j)
                        && dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                    contador++;
                }
            }
        }

        //Busqueda diagonal
        for (int i = 0; i < dna.length - 3; ++i) {
            for (int j = 0; j < dna.length - 3; ++j) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) &&
                        dna[i + 1].charAt(j + 1) == dna[i + 2].charAt(j + 2) &&
                        dna[i + 2].charAt(j + 2) == dna[i + 3].charAt(j + 3)) {
                    contador++;
                }
            }
        }

        //Busqueda diagonal inversa
        for(int i = 0; i < dna.length - 3; ++i) {
            for(int j = dna.length - 1; j >= 3; --j) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j - 1)
                        && dna[i].charAt(j) == dna[i + 2].charAt(j - 2)
                        && dna[i].charAt(j) == dna[i + 3].charAt(j - 3)) {
                    contador++;
                }
            }
        }

        //Retorna un contador ya que para que sea mutante tiene que tener más de dos secuencias
        return contador;
    }

}