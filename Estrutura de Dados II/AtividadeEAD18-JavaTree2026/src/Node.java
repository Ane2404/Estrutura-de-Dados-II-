package src;
import java.lang.Comparable;
public class Node<T extends Comparable<T>> {
     T dado;
     Node<T> esquerda;
     Node<T> direita;

    public Node(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    public T getDado() {
        return dado;
    }
    public void setDado(T dado) {
        this.dado = dado;
    }

    public Node<T> getDireita() {
        return direita;
    }
    public void setDireita(Node<T> direita) {
        this.direita = direita;
    }

    public Node<T> getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(Node<T> esquerda) {
        this.esquerda = esquerda;
    }
}
