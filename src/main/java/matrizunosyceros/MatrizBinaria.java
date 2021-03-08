package matrizunosyceros;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class MatrizBinaria {

    private int[][] matriz;
    private static Random rd = new Random();

    public MatrizBinaria(int n) {
        matriz = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = rd.nextInt(2);
            }
        }
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public String toString() {
        String texto = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                texto += matriz[i][j] + "\t";
            }
            texto += "\n";
        }
        return texto;
    }

    public int[] buscaPosicionCeroRodeadoDeUnos() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 0) {
                    if (compruebaAdyacentes(i, j)) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean compruebaAdyacentes(int i, int j) {
        for (int m = i - 1; m <= i + 1; m++) {
             for (int n = j - 1; n <= j + 1; n++) {
                if (m >= 0 && m < matriz.length && n >= 0 && n < matriz.length) { //es decir, esta dentro de la matriz
                    if (matriz[m][n] == 0) {  //si encuentra un 0
                        if (m != i || n != j) { //no es en (i,j)
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    //Prueba
    public static void main(String[] args) {
        int[] resultado;
        final int[] NULO = new int[]{-1,-1};
        
        
        for (int i = 0; i < 10; i++) {
            MatrizBinaria prueba = new MatrizBinaria(5);
            System.out.println(prueba);
            
            resultado = prueba.buscaPosicionCeroRodeadoDeUnos();
            
            if(Arrays.equals(resultado, NULO)) {
                System.out.println("Ninguna coordenada cumple los requisitos");
            } else {
                System.out.println("Coordenada que cumple: " + Arrays.toString(resultado));
            }
            
            System.out.println("--------------------------------------");
        }
    }

}
