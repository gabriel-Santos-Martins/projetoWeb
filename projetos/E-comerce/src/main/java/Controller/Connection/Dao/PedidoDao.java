package Controller.Connection.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.Connection.ConnectionFabric;
import Model.Pedido;

public class PedidoDao {

    private Connection conn;

    public PedidoDao() {
        this.conn = ConnectionFabric.getConnection("root", "yandermm1", "jdbc:mysql://localhost:3306/ecommerce");
    }

    public void adicionarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (usuarioId, carrinhoId, dataPedido, status) VALUES (?, ?, ?, ?)"; // Corrigido para colunas existentes

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, pedido.getUsuarioId());
            //statement.setInt(2, pedido.getCarrinhoId());
            statement.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime())); // Convertendo para java.sql.Date
            statement.setString(4, pedido.getStatus());
            statement.executeUpdate();
            System.out.println("Pedido adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar pedido: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }

    public void atualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET usuarioId = ?, carrinhoId = ?, dataPedido = ?, status = ? WHERE id = ?"; // Corrigido para colunas existentes

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, pedido.getUsuarioId());
            //statement.setInt(2, pedido.getCarrinhoId());
            statement.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime())); // Convertendo para java.sql.Date
            statement.setString(4, pedido.getStatus());
            statement.setInt(5, pedido.getId());
            statement.executeUpdate();
            System.out.println("Pedido atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar pedido: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }

    public void cancelarPedido(int id) {
        String sql = "UPDATE pedido SET status = 'Cancelado' WHERE id = ?"; // Corrigido nome da tabela

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Pedido cancelado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cancelar pedido: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }
}


