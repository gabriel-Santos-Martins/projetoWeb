package Model;

public class ProdutoCategoria {
    private int produtoId;
    private int categoriaId;

    // Construtor
    public ProdutoCategoria(int produtoId, int categoriaId) {
        this.produtoId = produtoId;
        this.categoriaId = categoriaId;
    }

    // Getters e Setters
    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}