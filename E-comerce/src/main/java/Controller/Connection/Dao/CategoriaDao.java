package Controller.Connection.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.Connection.ConnectionFabric;
import Model.Category;

public class CategoriaDao {

    private Connection conn;

    public CategoryDao() {
        this.conn = ConnectionFabric.getConnection("root", "yandermm1", "jdbc:mysql://localhost:3306/ecommerce");
    }

    public void adicionarCategoria(Category category) {
        String sql = "INSERT INTO category (nome, descricao) VALUES (?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, category.getNome());
            statement.setString(2, category.getDescricao());
            statement.executeUpdate();
            System.out.println("Categoria adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar categoria: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }

        public void atualizarCategoria(Category category) {
            String sql = "UPDATE category SET nome = ?, descricao = ? WHERE id = ?";

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, category.getNome());
                statement.setString(2, category.getDescricao());
                statement.setInt(3, category.getId());
                statement.executeUpdate();
                System.out.println("Categoria atualizada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar categoria: " + e.getMessage());
            } finally {
                ConnectionFabric.closeConnection();
            }
        }
        
    public void mudarCategoria(int id, String newName, String newDescription) {
        String sql = "UPDATE category SET nome = ?, descricao = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setString(2, newDescription);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Categoria atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar categoria: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }
}
