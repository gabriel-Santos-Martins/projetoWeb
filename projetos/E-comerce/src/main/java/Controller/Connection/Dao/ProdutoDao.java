package Controller.Connection.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.Connection.ConnectionFabric;
import Model.Produto;

public class ProdutoDao {
    private Connection conn;

    public ProdutoDao() {
        this.conn = ConnectionFabric.getConnection("root", "yandermm1", "jdbc:mysql://localhost:3306/ecommerce");
    }

    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, preco, quantidadeDisponivel) VALUES (?, ?, ?, ?)"; // Corrigido nome da coluna

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setDouble(3, produto.getPreco());
            statement.setInt(4, produto.getQuantidadeDisponivel()); // Corrigido nome da coluna
            statement.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }

    public Produto buscarProdutoPorId(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        Produto produto = null;

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                produto = new Produto(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("descricao"),
                        resultSet.getDouble("preco"),
                        resultSet.getInt("quantidadeDisponivel") // Corrigido nome da coluna
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
        return produto;
    }

    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, quantidadeDisponivel = ? WHERE id = ?"; // Corrigido nome da coluna

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setDouble(3, produto.getPreco());
            statement.setInt(4, produto.getQuantidadeDisponivel()); // Corrigido nome da coluna
            statement.setInt(5, produto.getId());
            statement.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }

    public void deletarProduto(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Produto deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }
}