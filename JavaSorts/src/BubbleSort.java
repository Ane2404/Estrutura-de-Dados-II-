import java.util.*;
    public class BubbleSort<T extends Comparable<T>> {

        private void troca(T[] array, int i, int j) {
            T temp = array[i]; //estamos pegando nosso i que será sobreposto por j e o guardando em temp
            array[i] = array[j]; //estamos sobrepondo, sobrescrevendo.
            array[j] = temp; 
            // Neste método estamos realizando a troca dos valores, dados.
        }
        public T[] sort(T[] array, Comparator<T> comparator) {
            int n = array.length;

            for (int fase = 1; fase < n ; fase++) { //aqui vamos organizar as fases, controlamos elas.
                for (int j = 0; j < n - fase; j++) { //aqui vamos controlar as comparações, vamos colocar menos a fase pois nossas comparações diminuem conforme a fase.
                    if (comparator.compare(array[j], array[j + 1]) > 0){ //esta é uma forma de comparar objetos aplicando o comparator, vamos poder comparar objetos coringas.
                        troca(array,j,j+1);//aqui estamos passando nossos parâmetros.
                    }
                }
            }

            return array;
            // Recebemos um array desordenado e retornamos um ordenado.
        }
        public T[] sort(T[] array) { // aqui estamos acessando o comparador padrão da classe.
            return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
        }

        public T[] sortVerbose(T[] array, Comparator<T> comparator) {
            int n = array.length;
            int comparacoes = 0;
                for (int fase = 1; fase < n; fase++) {
                    System.out.println("Fase " + fase + ": " + Arrays.toString(array));
                    // j controla comparações
                    for (int j = 0; j < n - fase; j++) {
                        System.out.println("Comparando: " + array[j] + " e " + array[j + 1]);
                        comparacoes++;
                        if (comparator.compare(array[j], array[j + 1]) > 0) {
                            System.out.println("Trocando: " + array[j] + " e " + array[j + 1]);
                            troca(array, j, j + 1);
                        }
                    }
                }
            System.out.println("Total de comparações: " + comparacoes);
            return array;
        }// fim sort

        public T[] sortVerbose(T[] array) {
            return sortVerbose(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
        }



}

//Criamos uma comparação que recebe dados genéricos.
//Para dizermos que algum objeto é maior que outro devemos ter um parâmetro de comparação.
//Se temos uma classe pessoa, devemos ter um método de comparação, um método de definição. O que estamos comparando?
//Caso não queiramos comparar utilizando o padrão da classe, podemos criar um comparador externo e passar ele, isso nos gera dois casos.
//Quando usamos o comparador externo precisamos criar um método de sobrescrita.
