import java.util.*;

public class App {

    static int menu(){
        Scanner leia = new Scanner(System.in);
        System.out.println("Arvore Binária de Busca");
        System.out.println("1. Inserir elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Buscar elemento");
        System.out.println("4. Exibir árvore");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return leia.nextInt();
    }

    
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        BinarySearchTree<Aluno> arvore = new BinarySearchTree<>(); // Instanciar a arvore
        int opcao=0;
        do {
            System.out.println("----------------------------------");
            opcao = menu();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a matricula do aluno: ");
                    int matricula = leia.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do aluno: ");
                    arvore.add(novoAluno);
                    System.out.println("Aluno inserido com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a matrícula do aluno a remover: ");
                    int matRemover = scanner.nextInt();
                    scanner.nextLine();
                    
                    Aluno alunoRemover = new Aluno(matRemover);
                    arvore.remove(alunoRemover);
                    System.out.println("Remoção executada.");
                    break;
                case 3:
                    System.out.print("Digite a matrícula do aluno para busca: ");
                    int matBusca = scanner.nextInt();
                    scanner.nextLine();

                    Aluno busca = new Aluno(matBusca);
                    Aluno resultado = arvore.buscar(busca);

                    if (resultado != null) {
                        System.out.println("Aluno encontrado: " + resultado);
                    } else {
                        System.out.println("Aluno com a matrícula " + matBusca + " não foi encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Exibindo a árvore em pré-ordem:");
                    arvore.preOrder(); // exibir 
                    System.out.println("Exibindo a árvore em ordem:");
                    arvore.inOrder();
                    System.out.println("Exibindo a árvore em pós-ordem:");
                    arvore.postOrder();

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

        
    }

