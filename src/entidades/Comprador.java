package entidades;

import java.util.Scanner;

public class Comprador extends Usuario{
    public static GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    public Comprador() {
    }

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Produto fazerCompra(String nomeProduto) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Produto produto = gerenciador.getProdutos(i, j);
                if (produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                    // Produto encontrado
                    if (produto.getQuantidade() == 0) {
                        // Produto fora de estoque
                        System.out.println("O produto " + produto.getNome() + " está fora de estoque.");
                        return null;
                    }

                    System.out.println(produto);
                    System.out.print("Confirma o produto? [s/n] \n>> ");
                    if (sc.next().toLowerCase().charAt(0) == 's') {

                        gerenciador.diminuirQuantidadeProduto(i, j, 1);
                        return produto;
                    } else {

                        System.out.println("Produto não confirmado. Continuando a busca...");
                        return null;
                    }
                }
            }
        }

        // Se nenhum produto foi encontrado, exibe uma mensagem e retorna null
        System.out.println("O produto que digitou não existe.");
        return null;
    }


}
