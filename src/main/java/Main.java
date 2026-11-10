import dao.ProdutoDAO;
import model.Produto;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto(
                0,
                "Mouse Sem Fio",
                new BigDecimal("89.90"),
                4
        );
        produtoDAO.salvar(produto);
    }
}
