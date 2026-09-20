import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SelectionSort {

    public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
        Integer[] numeros = new Integer[linhas.size()];
        for (int i = 0; i < linhas.size(); i++) {
            numeros[i] = Integer.parseInt(linhas.get(i).trim());
        }
        return numeros;
    }

    
    static void selectionSort (int[] numeros){
        int length = numeros.length;
        for(int i = 0; i < length - 1; i++){
            int min = numeros[i];
            int indexOfMin = i;
            for(int j = i + 1; j < length; j++){
                if (numeros[j] < min){
                    min = numeros[j];
                    indexOfMin = j;
                }
            }
            swap(numeros, i, indexOfMin);
        }
    }

    static void swap (int[] numeros, int a, int b){
        int temp = numeros [a];
        numeros[a] = numeros[b];
        numeros[b] = temp;
    }
}
