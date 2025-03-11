package Controller;

import Model.Pagamento;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/pagamento")
public class PagamentoController {
    private List<Pagamento> pagamentos = new ArrayList<>();

    public PagamentoController() {
        // Adicionando alguns pagamentos de exemplo
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pagamentos", pagamentos);
        request.getRequestDispatcher("/WEB-INF/views/pagamentos.jsp").forward(request, response);
    }
}
