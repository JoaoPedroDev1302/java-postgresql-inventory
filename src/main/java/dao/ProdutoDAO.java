package dao;

import conexao.ConexaoFactory;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public List<Produto> listar() {

        List<Produto> produtos = new ArrayList<>();

        String sql = """
                SELECT id, nome, preco, quantidade
                FROM produto
                ORDER BY id
                """;

        try (Connection conexao = ConexaoFactory.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {

                Produto produto = new Produto(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getBigDecimal("preco"),
                        resultado.getInt("quantidade")
                );

                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }

        return produtos;
    }

    public void salvar(Produto produto) {

        String sql = """
                INSERT INTO produto (nome, preco, quantidade)
                VALUES (?, ?, ?)
                """;

        try (Connection conexao = ConexaoFactory.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, produto.getNome());
            statement.setBigDecimal(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar produto", e);
        }
    }

    public boolean atualizar(Produto produto) {

        String sql = """
                UPDATE produto
                SET nome = ?,
                    preco = ?,
                    quantidade = ?
                WHERE id = ?
                """;

        try (Connection conexao = ConexaoFactory.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, produto.getNome());
            statement.setBigDecimal(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setInt(4, produto.getId());

            int linhasAfetadas = statement.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }

    public boolean excluir(int id) {

        String sql = """
                DELETE FROM produto
                WHERE id = ?
                """;

        try (Connection conexao = ConexaoFactory.getConexao();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setInt(1, id);

            int linhasAfetadas = statement.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto", e);
        }
    }
}