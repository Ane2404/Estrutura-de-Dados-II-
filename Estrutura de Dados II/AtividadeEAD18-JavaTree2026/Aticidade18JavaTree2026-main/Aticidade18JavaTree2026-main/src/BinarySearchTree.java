
package src;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> raiz;

    public BinarySearchTree() {
        this.raiz = null;
    }

    private Node<T> add(Node<T> raiz, Node<T> novoNo) {
        if (raiz == null) {
            raiz = novoNo;
            return raiz;
        } else if (novoNo.dado.compareTo(raiz.dado) < 0)
            raiz.esquerda = add(raiz.esquerda, novoNo);
        else
            raiz.direita = add(raiz.direita, novoNo);

        return raiz;
    }

    public void add(T dado) {
        Node<T> novoNo = new Node<>(dado);
        this.raiz = add(raiz, novoNo);
    }

    private void preOrder(Node<T> raiz) {
        if (raiz != null) {
            System.out.println(raiz.dado);
            preOrder(raiz.esquerda);
            preOrder(raiz.direita);
        }
    }

    public void preOrder() {
        preOrder(this.raiz);
        System.out.println();
    }

    private void inOrder(Node<T> raiz) {
        if (raiz != null) {
            inOrder(raiz.esquerda);
            System.out.println(raiz.dado);
            inOrder(raiz.direita);
        }
    }

    public void inOrder() {
        inOrder(this.raiz);
        System.out.println();
    }

    private void postOrder(Node<T> raiz) {
        if (raiz != null) {
            postOrder(raiz.esquerda);
            postOrder(raiz.direita);
            System.out.println(raiz.dado);
        }
    }

    public void postOrder() {
        postOrder(this.raiz);
        System.out.println();
    }

    public T buscar(T dadoBusca) {
        return (T) buscar(this.raiz, dadoBusca);
    }

    private T buscar(Node<T> raiz, T dadoBusca) {
        if (raiz == null)
            return null; 

        if (raiz.dado.equals(dadoBusca))
            return raiz.dado; 

        if (dadoBusca.compareTo(raiz.dado) < 0)
            return buscar(raiz.esquerda, dadoBusca);
        else
            return buscar(raiz.direita, dadoBusca);
    }

    public void remove(T dado) {
        this.raiz = remove(this.raiz, dado);
    }

    private Node<T> remove(Node<T> raiz, T dado) {
        if (raiz == null) {
            return null;
        }

        int comparacao = dado.compareTo(raiz.dado);

        if (comparacao < 0) {
            raiz.esquerda = remove(raiz.esquerda, dado);
        } else if (comparacao > 0) {
            raiz.direita = remove(raiz.direita, dado);
        } else {
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            raiz.dado = encontrarMenorValor(raiz.direita);

            raiz.direita = remove(raiz.direita, raiz.dado);
        }

        return raiz;
    }

    private T encontrarMenorValor(Node<T> raiz) {
        T menorValor = raiz.dado;
        while (raiz.esquerda != null) {
            menorValor = raiz.esquerda.dado;
            raiz = raiz.esquerda;
        }
        return menorValor;
    }
}