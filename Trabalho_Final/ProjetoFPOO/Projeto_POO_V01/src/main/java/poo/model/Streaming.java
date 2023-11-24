package poo.model;

import javax.persistence.*;

@MappedSuperclass
@DiscriminatorColumn(name = "streaming_type", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private Integer Duracao;
    private String Titulo;
    private String Classificacao;
    private String Categoria;

    // construtores, getters e setters
    public Streaming(){}// Construtor sem parâmetro só pra não bugar 
//Porque as classes concretas ficam tentando chamar um método construtor

    public Streaming(Integer Duracao, String Titulo, String Classificacao, String Categoria){ // classe construtora pra ser heradada
        this.Duracao = Duracao;
        this.Titulo = Titulo;
        this.Classificacao = Classificacao;
        this.Categoria = Categoria;
    }


    //Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDuracao() {
        return this.Duracao;
    }

    public void setDuracao(Integer Duracao) {
        this.Duracao = Duracao;
    }

    public String getTitulo() {
        return this.Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getClassificacao() {
        return this.Classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.Classificacao = classificacao;
    }

    public String getCategoria() {
        return this.Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

}
