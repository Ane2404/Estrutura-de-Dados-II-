import java.util.List;

public class Sorts<T extends Comparable<T>> {
    public void quickSort(List<T> lista) {
        if (lista == null || lista.size() <= 1) {
            return;
        }
        quickSortHelper(lista, 0, lista.size() - 1);
    }

    private void quickSortHelper(List<T> lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(lista, inicio, fim);
            quickSortHelper(lista, inicio, pivoIndex - 1);
            quickSortHelper(lista, pivoIndex + 1, fim);
        }
    }

    private int particionar(List<T> lista, int inicio, int fim) {
        T pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            // Utiliza o método compareTo genérico
            if (lista.get(j).compareTo(pivo) <= 0) {
                i++;
                trocar(lista, i, j);
            }
        }
        trocar(lista, i + 1, fim);
        return i + 1;
    }

    private void trocar(List<T> lista, int i, int j) {
        T temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}
