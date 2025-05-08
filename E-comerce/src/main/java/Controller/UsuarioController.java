package Controller;

import Model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("ecommercePU");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            List<Usuario> usuarios = query.getResultList();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("/WEB-INF/views/usuarios.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            if ("cadastrar".equals(action)) {
                Usuario usuario = new Usuario();
                usuario.setNome(request.getParameter("nome"));
                usuario.setEmail(request.getParameter("email"));
                usuario.setSenha(request.getParameter("senha"));
                usuario.setEndereco(request.getParameter("endereco"));
                em.persist(usuario);
            } else if ("atualizar".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = em.find(Usuario.class, id);
                if (usuario != null) {
                    usuario.setNome(request.getParameter("nome"));
                    usuario.setEmail(request.getParameter("email"));
                    usuario.setSenha(request.getParameter("senha"));
                    usuario.setEndereco(request.getParameter("endereco"));
                    em.merge(usuario);
                }
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new ServletException(e);
        } finally {
            em.close();
        }
        response.sendRedirect("usuario");
    }

    @Override
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
    }
}
