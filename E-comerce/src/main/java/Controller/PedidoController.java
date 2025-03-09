package Controller;

import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @WebServlet("/pedido")
    public class PedidoController extends HttpServlet {
        private List<Pedido> pedidos = new ArrayList<>();

        public PedidoController() {
            // Adicionando alguns produtos de exemplo
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("/WEB-INF/views/produtos.jsp").forward(request, response);
        }
}
