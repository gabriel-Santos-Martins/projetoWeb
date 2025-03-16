package Model;

public class Avaliacao {
    private int id;
    private int produtoId;
    private int usuarioId;
    private int nota;
    private String comentario;

    // Construtor
    public Avaliacao(int id, int produtoId, int usuarioId, int nota, String comentario) {
        this.id = id;
        this.produtoId = produtoId;
        this.usuarioId = usuarioId;
        this.nota = nota;
        this.comentario = comentario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}