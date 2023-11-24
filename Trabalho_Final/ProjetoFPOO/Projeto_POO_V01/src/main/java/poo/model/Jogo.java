package poo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("JOGO")
public class Jogo extends Streaming {

    @Id
    @Column(name = "id")
    private Long id;

    private String Studio;

    public Jogo(){

    };

    public Jogo(Integer Duracao, String Titulo, String Classificacao, String Categoria, String Studio) {
        
        super(Duracao, Titulo, Classificacao, Categoria);
        
        setStudio(Studio);
    }

    // Getters e Setters
    public String getStudio() {
        return this.Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //To string
    @Override
    public String toString() {
        return "\nJogo:" +
                "\nTitulo = " + getTitulo() +
                "\nCategoria = " + getCategoria() +
                "\nClassificacao = " + getClassificacao() +
                "\nDuracao = " + getDuracao() + " minutos" +
                "\nStudio = " + getStudio();
    }
}
