import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class App {


    public static Pessoa[] vetorDePessoas() {
        return new Pessoa[]{
            new Pessoa("João", LocalDate.of(1990, 1, 1)),
            new Pessoa("Ana", LocalDate.of(1992, 2, 2)),
            new Pessoa("Maria", LocalDate.of(1995, 5, 5)),
            new Pessoa("Pedro", LocalDate.of(1993, 4, 4)),
            new Pessoa("Lucas", LocalDate.of(1991, 6, 6)),
            new Pessoa("Carlos", LocalDate.of(1988, 3, 3)),
            new Pessoa("Ana", LocalDate.of(1985, 2, 2))
        };
    }

    private static Integer[] gerarVetorAleatorio(int n) {
        Random random = new Random();
        Integer [] vetor = new Integer [n];


        for (int i = 0; i < n; i++) {
            vetor[i] = random.nextInt(n * 10);
        }


        return vetor;
    }


    public static void main(String[] args) {

        //
        int n = 50000;
        Integer[] numeros = gerarVetorAleatorio(n);
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        //System.out.println("Vetor original: " + Arrays.toString(numeros));
        long inicio = System.currentTimeMillis();
        bubbleSort.sort(numeros);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo = " + (fim - inicio) + " ms");

        //System.out.println("Vetor ordenado "  );






        ComparadorData comparadorData = new ComparadorData();
        Comparator<Pessoa> comparadorNomeData = (p1, p2) -> {
            int compNome = p1.getNome().compareTo(p2.getNome());


            if (compNome != 0) {
                return compNome;
            }


            return p1.getDataNascimento().compareTo(p2.getDataNascimento());
        }; // Esse método é uma forma de comparar nome e data de nascimento, se os nomes forem iguais, conseguimos comparar as datas.

        BubbleSort<Pessoa> bubbleSortPessoas = new BubbleSort<>();
        Pessoa[] pessoas = vetorDePessoas();
        bubbleSortPessoas.sort(pessoas, comparadorNomeData);
        for (Pessoa p:pessoas) // esse for it serve para organizar o print na tela
            System.out.println(p.getNome() + " - " + p.getDataNascimento()); 
            //System.out.println(P); - Tambem serve, pois vamos usar o toString da classe.

        System.out.println(Arrays.toString(numeros));
        long startTime = System.currentTimeMillis();
        selectionSort(numeros);
        long endtTime = System.currentTimeMillis();
        System.out.println("Relógio " + (endtTime - startTime) + "ms");
        System.out.println(Arrays.toString(numeros));

    }

}
