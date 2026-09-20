import java.text.Collator;
import java.util.Locale;

// 1. Criar uma classe candidato contendo: nome e nota.
public class Candidato implements Comparable<Candidato>{
    private String nome;
    private Double nota;


    private static final Collator COLLATOR = Collator.getInstance(new Locale("pt", "BR"));
    // O colattor trata diferenças de maiscula e minuscula, garantindo que objetos diferentes nunca sejam considerados identicos.
    // Ele faz isso respeitando a lingua portuguesa.


    static {
        COLLATOR.setStrength(Collator.SECONDARY);
    }

    public Candidato (String nome, Double nota){
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public Double getNota() {
        return nota;
    }


    //2. Definindo critério de comparação: primeiro ordem de nota decrescente, segundo nome em ordem alfabética.
    @Override
    public int compareTo (Candidato outro){
        //Comparação primária.
        int comparacaoNota = Double.compare(outro.nota , this.nota);
        if(comparacaoNota != 0){
            return comparacaoNota;
        }

        //Comparação secundária.
        int comparacaoNome = COLLATOR.compare(outro.nome , this.nome);
        if(comparacaoNome != 0){
            return comparacaoNome;
        }
        
        // Desempate final.
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public String toString(){
        return String.format("%s - %.1f", nome, nota);
    }
}
