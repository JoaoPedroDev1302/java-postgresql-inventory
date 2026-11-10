
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/jdbc_estudos";
        String usuario = "postgres";
        String senha = System.getenv("DB_PASSWORD");

        try (Connection conexao =
                     DriverManager.getConnection(url, usuario, senha)) {

            if (conexao.isValid(2)) {
                System.out.println("Conexão realizada com sucesso!");
            } else {
                System.out.println("Conexão inválida!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco!");
            e.printStackTrace();
        }
    }
}

