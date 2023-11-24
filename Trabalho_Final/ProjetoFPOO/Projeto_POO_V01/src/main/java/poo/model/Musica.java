package poo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MUSICA")
public class Musica extends Streaming {

    private String Artista;

    public Musica() {
    }

    public Musica(Integer Duracao, String Titulo, String Artista) {
        super(Duracao, Titulo, null, null);
        setArtista(Artista);
    }

    public String getArtista() {
        return this.Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    @Override
    public String toString() {
        return "\nMusica:" +
                "\nTitulo = " + getTitulo() +
                "\nDuracao = " + getDuracao() + " minutos" +
                "\nLancamento = " + getArtista();
    }
}
