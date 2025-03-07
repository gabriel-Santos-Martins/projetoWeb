package Controller;

import Model.Produto;

public class ProdutoController {
    import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @WebServlet("/produto")
    public class ProdutoController extends HttpServlet {
        private List<Produto> produtos = new ArrayList<>();

        public ProdutoController() {
            // Adicionando alguns produtos de exemplo
            produtos.add(new Produto(1, "Produto A", 10.0));
            produtos.add(new Produto(2, "Produto B", 20.0));
            produtos.add(new Produto(3, "Produto C", 30.0));
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("produtos", produtos);
            request.getRequestDispatcher("/WEB-INF/views/produtos.jsp").forward(request, response);
        }
}
