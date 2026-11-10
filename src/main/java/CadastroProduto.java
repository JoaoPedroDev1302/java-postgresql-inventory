import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroProduto {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/jdbc_estudos";
        String usuario = "postgres";
        String senha = System.getenv("DB_PASSWORD");

        String sql = """
                INSERT INTO produto (nome, preco, quantidade)
                VALUES ('Notebook Dell', 2999.90, 5)
                """;

        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha);
             Statement statement = conexao.createStatement()) {

            int linhasAfetadas = statement.executeUpdate(sql);

            System.out.println("Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

