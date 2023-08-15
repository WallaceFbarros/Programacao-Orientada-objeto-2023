package atividade1;
import java.util.Scanner;

class teste {
    static public void main (String args[]) {
        System.out.println("O programa vai pedir para inserir um número e após o número ser digitado vai responder: \n0 - se o número não for primo. \n1 - se o número for primo.");
        Scanner meuObj = new Scanner(System.in);
        System.out.println("Insira um número: ");
        int meuNumero = meuObj.nextInt();
        int resposta = verificaNumeroPrimo(meuNumero);
        System.out.println(resposta);
    }
    static int verificaNumeroPrimo(int meuNumero) {
        if (meuNumero <= 1) {
            return 0;
        }
        for (int i = 2; i <= meuNumero / 2 ; i++) {
            if (meuNumero % i == 0) {
                return 0;
            }
        }   
        return 1; 
    }
}