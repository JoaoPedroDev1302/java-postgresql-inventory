import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroProdutoPreparado {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/jdbc_estudos";
        String usuario = "postgres";
        String senha = System.getenv("DB_PASSWORD");

        String sql = """
                INSERT INTO produto (nome, preco, quantidade)
                VALUES (?, ?, ?)
                """;

        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha);
             PreparedStatement statement =
                     conexao.prepareStatement(sql)) {

            statement.setString(1, "Mouse Gamer");
            statement.setBigDecimal(2, new BigDecimal("149.90"));
            statement.setInt(3, 10);

            int linhasAfetadas = statement.executeUpdate();

            System.out.println("Produtos cadastrados: " + linhasAfetadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
