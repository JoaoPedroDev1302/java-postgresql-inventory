package app;

import dao.ProdutoDAO;
import model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("      CONTROLE DE ESTOQUE");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Excluir produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:
                    cadastrarProduto(scanner, produtoDAO);
                    break;

                case 2:
                    listarProdutos(produtoDAO);
                    break;

                case 3:
                    atualizarProduto(scanner, produtoDAO);
                    break;

                case 4:
                    excluirProduto(scanner, produtoDAO);
                    break;

                case 0:
                    System.out.println("\nPrograma encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarProduto(
            Scanner scanner,
            ProdutoDAO produtoDAO
    ) {

        System.out.println("\n--- CADASTRAR PRODUTO ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        BigDecimal preco =
                new BigDecimal(scanner.nextLine().replace(",", "."));

        System.out.print("Quantidade: ");
        int quantidade =
                Integer.parseInt(scanner.nextLine());

        Produto produto = new Produto(
                0,
                nome,
                preco,
                quantidade
        );

        produtoDAO.salvar(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarProdutos(
            ProdutoDAO produtoDAO
    ) {

        System.out.println("\n--- PRODUTOS CADASTRADOS ---");

        List<Produto> produtos =
                produtoDAO.listar();

        if (produtos.isEmpty()) {

            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto produto : produtos) {

            System.out.println(
                    "ID: " + produto.getId()
                            + " | Nome: " + produto.getNome()
                            + " | Preço: R$ " + produto.getPreco()
                            + " | Quantidade: " + produto.getQuantidade()
            );
        }
    }

    private static void atualizarProduto(
            Scanner scanner,
            ProdutoDAO produtoDAO
    ) {

        System.out.println("\n--- ATUALIZAR PRODUTO ---");

        System.out.print("ID do produto: ");
        int id =
                Integer.parseInt(scanner.nextLine());

        System.out.print("Novo nome: ");
        String nome =
                scanner.nextLine();

        System.out.print("Novo preço: ");
        BigDecimal preco =
                new BigDecimal(scanner.nextLine().replace(",", "."));

        System.out.print("Nova quantidade: ");
        int quantidade =
                Integer.parseInt(scanner.nextLine());

        Produto produto = new Produto(
                id,
                nome,
                preco,
                quantidade
        );

        produtoDAO.atualizar(produto);

        System.out.println("Operação de atualização concluída!");
    }

    private static void excluirProduto(
            Scanner scanner,
            ProdutoDAO produtoDAO
    ) {

        System.out.println("\n--- EXCLUIR PRODUTO ---");

        System.out.print("ID do produto: ");

        int id =
                Integer.parseInt(scanner.nextLine());

        produtoDAO.excluir(id);

        System.out.println("Operação de exclusão concluída!");
    }
}