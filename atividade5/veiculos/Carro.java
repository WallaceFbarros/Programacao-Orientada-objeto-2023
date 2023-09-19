public class Carro extends Veiculo {
    private boolean precisaTrocarOleo;

    public Carro(String marca, String modelo, int anoFabricacao, boolean precisaTrocarOleo) {
        super(marca, modelo, anoFabricacao);
        this.precisaTrocarOleo = precisaTrocarOleo;
    }

    public String getTrocarOleoStatus() {
        return precisaTrocarOleo ? "Sim" : "Não";
    }

    public int getAnoFabricacao() {
        return super.anoFabricacao;
    }

    // Métodos específicos para Carro, se necessário
}