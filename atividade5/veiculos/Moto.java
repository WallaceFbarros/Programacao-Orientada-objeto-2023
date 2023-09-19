public class Moto extends Veiculo {
    private boolean precisaTrocarOleo;

    public Moto(String marca, String modelo, int anoFabricacao, boolean precisaTrocarOleo) {
        super(marca, modelo, anoFabricacao);
        this.precisaTrocarOleo = precisaTrocarOleo;
    }

    public String getTrocarOleoStatus() {
        return precisaTrocarOleo ? "Sim" : "Não";
    }

    public int getAnoFabricacao() {
        return super.anoFabricacao;
    }

    // Métodos específicos para Moto, se necessário
}
