package Controller;

import Model.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        // Adicionando alguns usuários de exemplo
        usuarios.add(new Usuario(1, "João Silva", "joao@example.com", "senha123", "Rua A, 123"));
        // Add more users as needed
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/WEB-INF/views/usuarios.jsp").forward(request, response);
    }
}
