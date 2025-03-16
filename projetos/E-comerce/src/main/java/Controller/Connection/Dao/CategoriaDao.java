package Controller.Connection.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.Connection.ConnectionFabric;
import Model.Categoria;

public class CategoriaDao {

    private Connection conn;

    public CategoriaDao() {
        this.conn = ConnectionFabric.getConnection("root", "yandermm1", "jdbc:mysql://localhost:3306/ecommerce");
    }

    public void adicionarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome) VALUES (?)"; // Removido 'descricao'

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, categoria.getNome());
            statement.executeUpdate();
            System.out.println("Categoria adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar categoria: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }

    public void atualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET nome = ? WHERE id = ?"; // Removido 'descricao'

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, categoria.getNome());
            statement.setInt(2, categoria.getId());
            statement.executeUpdate();
            System.out.println("Categoria atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar categoria: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }

    public void mudarCategoria(int id, String newName) { // Removido 'newDescription'
        String sql = "UPDATE categoria SET nome = ? WHERE id = ?"; // Corrigido nome da tabela

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Categoria atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar categoria: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }
}
