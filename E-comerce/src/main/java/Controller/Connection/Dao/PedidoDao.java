package Controller.Connection.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.Connection.ConnectionFabric;
import Model.Order;

public class PedidoDao {

    private Connection conn;

    public PedidoDao() {
        this.conn = ConnectionFabric.getConnection("root", "yandermm1", "jdbc:mysql://localhost:3306/ecommerce");
    }

    public void adicionarPedido(Order order) {
        String sql = "INSERT INTO orders (usuario_id, total, status) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, order.getUsuarioId());
            statement.setDouble(2, order.getTotal());
            statement.setString(3, order.getStatus());
            statement.executeUpdate();
            System.out.println("Pedido adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar pedido: " + e.getMessage());
        } finally {
            ConnectionFabric.closeConnection();
        }
    }
}
