package Controller;

import Model.Categoria;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/categoria")
public class CategoriaController {
    private List<Categoria> categorias = new ArrayList<>();

    public CategoriaController() {
        // Adicionando algumas categorias de exemplo
        categorias.add(new Categoria(1, "Brinquedos"));
        // Add more categories as needed
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/WEB-INF/views/categorias.jsp").forward(request, response);
    }
}
