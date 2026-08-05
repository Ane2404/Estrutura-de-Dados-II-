import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class App {

    public static Integer[] vetorDeNumeros() {
        return new Integer[]{
            87, 14, 63, 29, 95,
            41, 72, 8, 56, 33
        };
    }

        public static Pessoa[] vetorDePessoas() {
        return new Pessoa[]{
            new Pessoa("João", LocalDate.of(1990, 1, 1)),
            new Pessoa("Ana", LocalDate.of(1992, 2, 2)),
            new Pessoa("Maria", LocalDate.of(1995, 5, 5)),
            new Pessoa("Pedro", LocalDate.of(1993, 4, 4)),
            new Pessoa("Lucas", LocalDate.of(1991, 6, 6)),
            new Pessoa("Carlos", LocalDate.of(1988, 3, 3))
        };
    }

    public static void main(String[] args) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] numeros = vetorDeNumeros();
        System.out.println("Vetor nao ordenado");
        System.out.println(Arrays.toString(numeros));

        System.out.println("Vetor ordenado");
        bubbleSort.sort(numeros); //ordenado
        System.out.println(Arrays.toString(numeros));

        numeros = vetorDeNumeros();
        bubbleSort.sort(numeros, Comparator.reverseOrder());

        System.out.println("\n=== Ordem decrescente ===");
        System.out.println(Arrays.toString(numeros));

        BubbleSort<Pessoa> bubbleSortPessoas = new BubbleSort<>();
        Pessoa[] pessoas = vetorDePessoas();
        bubbleSortPessoas.sort(pessoas);
        System.out.println(Arrays.toString(pessoas)); 


    }

}
