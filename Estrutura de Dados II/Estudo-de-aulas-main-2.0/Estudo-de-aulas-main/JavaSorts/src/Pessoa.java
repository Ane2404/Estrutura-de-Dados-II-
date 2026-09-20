import java.time.LocalDate;


public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private LocalDate dataNascimento;


    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }


    public String getNome() {
        return nome;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
    
    //implementa comparable compareTo  
    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
        //Se quisermos desacoplar, é so substituir nome por dataDeNascimento, pois vamos estar modificando a comparação dentro da própria classe pessoa.
        // Se os nomes forem iguais retorna 0, se o atual for maior que o próximo retorna 1, se for menor retorna -1.
    }


    @Override
    public int hashCode() {
       return nome.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass() || this == obj)
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


    
}
