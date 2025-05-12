package Model;

import model.Produto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private SessionFactory sessionFactory;
    private List<Produto> listaProdutos;

    public Estoque() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        listaProdutos = new ArrayList<>();
    }

    public boolean produtoExiste(int id) {
        try (Session session = sessionFactory.openSession()) {
            Produto produto = session.get(Produto.class, id);
            return produto != null;
        }
    }

    public void adicionarProdutoPorId(int id, int quantidade) {
        try (Session session = sessionFactory.openSession()) {
            Produto produto = session.get(Produto.class, id);

            if (produto != null) {
                for (int i = 0; i < quantidade; i++) {
                    listaProdutos.add(Produto.builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .preco(produto.getPreco())
                        .build()
                    );
                }
                System.out.println("Produto adicionado " + quantidade + "x à lista.");
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        }
    }

    public void listarProdutos() {
        listaProdutos.forEach(System.out::println);
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
}