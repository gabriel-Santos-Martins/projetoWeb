package Controller;

import Model.Produto;

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

@WebServlet(name = "ProdutoController", urlPatterns = {"/produto"})
public class ProdutoController extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("ecommercePU");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            switch (action != null ? action : "") {
                case "new":
                    mostrarNovoFormulario(request, response);
                    break;
                case "edit":
                    EditarFormulario(request, response);
                    break;
                case "delete":
                    deletarProduto(request, response);
                    break;
                default:
                    listarProdutos(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("insert".equals(action)) {
                inserirProduto(request, response);
            } else if ("update".equals(action)) {
                atualizarProduto(request, response);
            } else {
                listarProdutos(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listarProdutos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
            List<Produto> produtos = query.getResultList();
            request.setAttribute("produtos", produtos);
            request.getRequestDispatcher("/WEB-INF/views/produto/list.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }

    private void mostrarNovoFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/produto/form.jsp").forward(request, response);
    }

    private void EditarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        EntityManager em = emf.createEntityManager();
        try {
            Produto produto = em.find(Produto.class, id);
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("/WEB-INF/views/produto/form.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }

    private void inserirProduto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        EntityManager em = emf.createEntityManager();
        try {
            Produto produto = new Produto();
            produto.setNome(request.getParameter("nome"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setPreco(Double.parseDouble(request.getParameter("preco")));
            produto.setQuantidadeDisponivel(Integer.parseInt(request.getParameter("quantidade")));

            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        response.sendRedirect("produto");
    }

    private void atualizarProduto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        EntityManager em = emf.createEntityManager();
        try {
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                produto.setNome(request.getParameter("nome"));
                produto.setDescricao(request.getParameter("descricao"));
                produto.setPreco(Double.parseDouble(request.getParameter("preco")));
                produto.setQuantidadeDisponivel(Integer.parseInt(request.getParameter("quantidade")));

                em.getTransaction().begin();
                em.merge(produto);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        response.sendRedirect("produto");
    }

    private void deletarProduto(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.remove(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        response.sendRedirect("produto");
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
