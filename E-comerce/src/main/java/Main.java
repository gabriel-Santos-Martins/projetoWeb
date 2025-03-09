
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Model.*;

public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Produto produto1 = new Produto(1, "Notebook Dell", "Notebook com 16GB de RAM", 2500.00, 10);
        Produto produto2 = new Produto(2, "Mouse Sem Fio", "Mouse óptico sem fio", 50.00, 20);

        // Criando um usuário
        Usuario usuario = new Usuario(1, "João Silva", "joao@example.com", "senha123", "Rua A, 123");

        // Criando um carrinho
        Carrinho carrinho = new Carrinho(1, usuario.getId());
        carrinho.adicionarItem(produto1, 1); // Adiciona 1 Notebook Dell
        carrinho.adicionarItem(produto2, 2); // Adiciona 2 Mouses Sem Fio

        // Exibindo o carrinho
        System.out.println("Carrinho: " + carrinho);
        System.out.println("Total do carrinho: R$ " + carrinho.calcularTotal());

        // Criando um pedido
        Pedido pedido = new Pedido(1, usuario.getId(), new Date(), "Pendente", carrinho.getItens());
        System.out.println("Pedido: " + pedido);
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
    }
}