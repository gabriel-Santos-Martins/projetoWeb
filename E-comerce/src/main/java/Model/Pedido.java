package Model;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private int usuarioId;
    private Date dataPedido;
    private String status;
    private List<ItemCarrinho> itens;

    // Construtor
    public Pedido(int id, int usuarioId, Date dataPedido, String status, List<ItemCarrinho> itens) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.dataPedido = dataPedido;
        this.status = status;
        this.itens = itens;
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

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    // Método para calcular o total do pedido
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", dataPedido=" + dataPedido +
                ", status='" + status + '\'' +
                ", itens=" + itens +
                '}';
    }
}