package atividade6;

// Classe SerHumano
public class SerHumano {
    private String nome;
    private int idade;

    public SerHumano(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void falar() {
        System.out.println("O ser humano está falando.");
    }
}


