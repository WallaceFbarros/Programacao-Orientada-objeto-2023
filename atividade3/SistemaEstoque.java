package atividade3;

import java.util.ArrayList;
import java.util.List;

public class SistemaEstoque {
    private List<Produto> estoque;

    public SistemaEstoque() {
        estoque = new ArrayList<>();
    }

    public void adicionarProduto(String nome, int quantidade) {
        estoque.add(new Produto(nome, quantidade));
    }

    public void removerProduto(String nome) {
        estoque.removeIf(produto -> produto.getNome().equalsIgnoreCase(nome));
    }

    public void listarProdutos() {
        for (Produto produto : estoque) {
            System.out.println("Nome: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    public void atualizarQuantidade(String nome, int novaQuantidade) {
        for (Produto produto : estoque) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produto.setQuantidade(novaQuantidade);
                break;
            }
        }
    }
}
