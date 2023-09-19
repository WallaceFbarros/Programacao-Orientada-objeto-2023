
public class Executavel {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Toyota", "Corolla", 2022, true);
        Moto minhaMoto = new Moto("Honda", "CBR 600", 2021, false);
        Bicicleta minhaBicicleta = new Bicicleta("Caloi", "Sport", 2020, true);

        meuCarro.acelerar(80);
        minhaMoto.acelerar(60);
        minhaBicicleta.acelerar(20);

        meuCarro.frear(30);
        minhaMoto.frear(20);
        minhaBicicleta.frear(10);   

        System.out.println("Ano de fabricação do Carro: " + meuCarro.getAnoFabricacao());
        System.out.println("Ano de fabricação da Moto: " + minhaMoto.getAnoFabricacao());
        System.out.println("Ano de fabricação da Bicicleta: " + minhaBicicleta.getAnoFabricacao());
        System.out.println("Moto precisa trocar óleo? " + minhaMoto.getTrocarOleoStatus());
        System.out.println("Carro precisa trocar óleo? " + meuCarro.getTrocarOleoStatus());
        System.out.println("Bicicleta possui rodinha? " + minhaBicicleta.getRodinhaStatus());

    }
}
