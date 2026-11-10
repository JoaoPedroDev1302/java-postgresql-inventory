package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static Connection getConexao() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/jdbc_estudos";
        String usuario = "postgres";
        String senha = System.getenv("DB_PASSWORD");

        return DriverManager.getConnection(url, usuario, senha);
    }
}
