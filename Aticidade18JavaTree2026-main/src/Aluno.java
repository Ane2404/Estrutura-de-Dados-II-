import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private int matricula;

    // Construtor completo
    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    // Construtor auxiliar (útil para buscas apenas por matrícula)
    public Aluno(int matricula) {
        this(matricula, "");
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // Implementação da interface Comparable (comparação pela matrícula)
    @Override
    public int compareTo(Aluno outro) {
        return Integer.compare(this.matricula, outro.matricula);
    }

    // Sobrescrita do equals baseando-se na matrícula
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return matricula == aluno.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    // Sobrescrita do toString para exibição legível
    @Override
    public String toString() {
        return "[Matrícula: " + matricula + " - Nome: " + nome + "]";
    }
}
