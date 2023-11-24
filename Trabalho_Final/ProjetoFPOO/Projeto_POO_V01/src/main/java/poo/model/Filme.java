package poo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("FILME")
public class Filme extends Streaming {

    @Id
    @Column(name = "id")
    private Long id;

    private String Diretor;
    private String Lancamento;

    public Filme(){

    };

    public Filme(Integer Duracao, String Titulo, String Classificacao, String Categoria, String Diretor, String lancamento) {
        
        super(Duracao, Titulo, Classificacao, Categoria);
        
        setDiretor(Diretor);

        setLancamento(lancamento);
    }

    // Getters e Setters
    public String getDiretor() {
        return this.Diretor;
    }

    public void setDiretor(String Diretor) {
        this.Diretor = Diretor;
    }

    public String getLancamento() {
        return this.Lancamento;
    }

    public void setLancamento(String Lancamento) {
        this.Lancamento = Lancamento;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //To string
    @Override
    public String toString() {
        return "\nFilme:" +
                "\nTitulo = " + getTitulo() +
                "\nDiretor = " + getDiretor() +
                "\nCategoria = " + getCategoria() +
                "\nClassificacao = " + getClassificacao() +
                "\nDuracao = " + getDuracao() + " minutos" +
                "\nLancamento = " + getLancamento();
    }
}
