package atividade2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escolha a direção da conversão (C (Celsius -> Fahrenheit) ou F (Fahrenheit -> Celsius): ");
        char direcao = scanner.next().charAt(0);

        double temperatura;
        double temperaturaConvertida;

        if (direcao == 'C' || direcao == 'c') {
            System.out.print("Digite a temperatura em Celsius: ");
            temperatura = scanner.nextDouble();
            temperaturaConvertida = (temperatura * 9/5) + 32;
            System.out.println("Temperatura em Fahrenheit: " + temperaturaConvertida);
        } else if (direcao == 'F' || direcao == 'f') {
            System.out.print("Digite a temperatura em Fahrenheit: ");
            temperatura = scanner.nextDouble();
            temperaturaConvertida = (temperatura - 32) * 5/9;
            System.out.println("Temperatura em Celsius: " + temperaturaConvertida);
        } else {
            System.out.println("Escolha de conversão inválida.");
        }
    }
}
