package Model;

public class Pagamento {
    private int id;
    private int pedidoId;
    private String metodoPagamento;
    private double valorTotal;
    private String statusPagamento;

    // Construtor
    public Pagamento(int id, int pedidoId, String metodoPagamento, double valorTotal, String statusPagamento) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
        this.statusPagamento = statusPagamento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}