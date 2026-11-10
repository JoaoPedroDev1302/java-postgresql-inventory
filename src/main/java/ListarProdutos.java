
import model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ListarProdutos {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/jdbc_estudos";
        String usuario = "postgres";
        String senha = System.getenv("DB_PASSWORD");

        String sql = "SELECT * FROM produto";

        List<Produto> produtos = new ArrayList<>();

        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement =
                     conexao.prepareStatement(sql);
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
            e.printStackTrace();
        }

        for (Produto produto : produtos) {
            if (produto.getQuantidade() > 5){
            System.out.println(produto);
            }
        }
    }
}
