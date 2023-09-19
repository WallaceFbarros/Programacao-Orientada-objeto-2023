public class Veiculo {
    private String marca;
    private String modelo;
    protected int anoFabricacao;
    private int velocidade;

    public Veiculo(String marca, String modelo, int anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.velocidade = 0;
    }

    public void acelerar(int velocidade) {
        this.velocidade += velocidade;
        System.out.println(marca + " " + modelo + " acelerou para " + this.velocidade + " km/h");
    }

    public void frear(int velocidade) {
        if (this.velocidade >= velocidade) {
            this.velocidade -= velocidade;
        } else {
            this.velocidade = 0;
        }
        System.out.println(marca + " " + modelo + " freou para " + this.velocidade + " km/h");
    }
}