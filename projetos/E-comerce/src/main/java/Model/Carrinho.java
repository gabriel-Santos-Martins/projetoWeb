package Model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private int id;
    private int usuarioId;
    private List<ItemCarrinho> itens;

    // Construtor
    public Carrinho(int id, int usuarioId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.itens = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    // Método para adicionar um item ao carrinho
    public void adicionarItem(Produto produto, int quantidade) {
        // Verifica se o produto já está no carrinho
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        // Se o produto não estiver no carrinho, adiciona um novo item
        itens.add(new ItemCarrinho(produto, quantidade));
    }

    // Método para remover um item do carrinho
    public void removerItem(Produto produto) {
        itens.removeIf(item -> item.getProduto().getId() == produto.getId());
    }

    // Método para limpar o carrinho
    public void limparCarrinho() {
        itens.clear();
    }

    // Método para calcular o total do carrinho
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", itens=" + itens +
                '}';
    }
}