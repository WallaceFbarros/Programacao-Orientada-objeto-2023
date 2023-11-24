package poo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("SERIE")
public class Serie extends Streaming {

    @Id
    @Column(name = "id")
    private Long id;

    private Integer Episodio;
    private Integer Temporada;

    public Serie(){

    };

    public Serie(String Titulo, String Classificacao, String Categoria, Integer Temporada, Integer Episodio) {
        
        super(null, Titulo, Classificacao, Categoria);
        
        setEpisodio(Episodio);

        setTemporada(Temporada);
    }

    // Getters e Setters
    public Integer getEpisodio() {
        return this.Episodio;
    }

    public void setEpisodio(Integer Episodio) {
        this.Episodio = Episodio;
    }

    public Integer getTemporada() {
        return this.Temporada;
    }

    public void setTemporada(Integer Temporada) {
        this.Temporada = Temporada;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //To string
    @Override
    public String toString() {
        return "\nSerie:" +
                "\nTitulo = " + getTitulo() +
                "\nCategoria = " + getCategoria() +
                "\nClassificacao = " + getClassificacao() +
                "\nEpisódios  = " + getEpisodio() +
                "\nTemporadas = " + getTemporada();
    }
}
