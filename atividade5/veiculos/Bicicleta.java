public class Bicicleta extends Veiculo {
    private boolean possuiRodinha;

    public Bicicleta(String marca, String modelo, int anoFabricacao, boolean possuiRodinha) {
        super(marca, modelo, anoFabricacao);
        this.possuiRodinha = possuiRodinha;
    }

    public String getRodinhaStatus() {
        return possuiRodinha ? "Sim" : "Não";
    }
    
    public int getAnoFabricacao() {
        return super.anoFabricacao;
    }
    // Métodos específicos para Bicicleta, se necessário

}
