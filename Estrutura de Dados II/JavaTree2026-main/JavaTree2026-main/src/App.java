public class App {
    //1. Criando o Main.
    public static void main(String[] args) throws Exception {
        // 2. Criação da árvore.
        BinarySearchTree<Integer> arvore = new BinarySearchTree<>();

        // 3. Inserção dos valores.
        arvore.add(50);
        arvore.add(30);
        arvore.add(70);
        arvore.add(20);
        arvore.add(40);
        arvore.add(60);
        arvore.add(80);

        // 4. Identificação do percurso e chamada do preOrder().
        System.out.println("Percurso em Pré-Ordem (Pre-Order Traversal):");
        arvore.preOrder();
    }
}
