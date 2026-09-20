import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 3. Carregue os dados Csv.
        String caminhoCsv = "https://drive.google.com/uc?export=download&id=1OsUFFdjyrpPIO6alXDUmiHuwgetSP0kr";
        List<Candidato> candidatos = carregarCandidatosCSV(caminhoCsv);

        
        // Teste.
        if (candidatos.isEmpty()) {
            System.out.println("--- Arquivo CSV não encontrado. Carregando dados de exemplo predefinidos ---");
            candidatos.add(new Candidato("Carlos", 85.5));
            candidatos.add(new Candidato("Ana", 92.0));
            candidatos.add(new Candidato("Bruno", 85.5));
            candidatos.add(new Candidato("Daniel", 92.0));
            candidatos.add(new Candidato("Carlos Henrique", 97.5));
            candidatos.add(new Candidato("Beatriz Silva", 97.5));
            candidatos.add(new Candidato("Ana Paula", 98.7));
            candidatos.add(new Candidato("Daniel Souza", 96.8));
        }


        // 4. Apresentação da lista antes da ordenação.
        System.out.println("=========================================");
        System.out.println("   LISTA ANTES DA ORDENAÇÃO");
        System.out.println("=========================================");
        exibirLista(candidatos, false);

        // 5. Utilizar a classe genérica Sorts<T> para realizar a ordenação
        Sorts<Candidato> ordenador = new Sorts<>();
        ordenador.quickSort(candidatos);

        // 6. Apresentar a lista de candidatos classificados
        System.out.println("\n=========================================");
        System.out.println("   LISTA DE CANDIDATOS CLASSIFICADOS");
        System.out.println("=========================================");
        exibirLista(candidatos, true);
    }

    // Apresentação do arquivo Csv.
    private static List<Candidato> carregarCandidatosCSV(String caminhoArquivo) {
        List<Candidato> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.startsWith("Nome") || linha.startsWith("nome")) {
                    continue; // Pula cabeçalho ou linhas vazias
                }
                String[] partes = linha.split(",");
                if (partes.length >= 2) {
                    String nome = partes[0].trim();
                    // Garante a conversão de ponto ou vírgula decimal
                    double nota = Double.parseDouble(partes[1].trim().replace(",", "."));
                    lista.add(new Candidato(nome, nota));
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Silencia erro para uso dos dados padrão de fallback caso o arquivo não seja informado
        }
        return lista;
    }

    private static void exibirLista(List<Candidato> lista, boolean numerada) {
        for (int i = 0; i < lista.size(); i++) {
            if (numerada) {
                System.out.printf("%d. %s%n", (i + 1), lista.get(i));
            } else {
                System.out.println(lista.get(i));
            }
        }
    }
}
