package atividade3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEstoque sistema = new SistemaEstoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Listar produtos");
            System.out.println("4 - Atualizar quantidade");
            System.out.println("0 - Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    sistema.adicionarProduto(nome, quantidade);
                    break;
                case 2:
                    System.out.print("Digite o nome do produto a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    sistema.removerProduto(nomeRemover);
                    break;
                case 3:
                    sistema.listarProdutos();
                    break;
                case 4:
                    System.out.print("Digite o nome do produto a ser atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    sistema.atualizarQuantidade(nomeAtualizar, novaQuantidade);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Digite um número válido.");
            }
        }
    }
}
