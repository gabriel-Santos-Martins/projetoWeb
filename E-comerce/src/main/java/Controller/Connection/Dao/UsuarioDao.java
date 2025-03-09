package Controller.Connection.Dao;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.Connection.ConnectionFabric;
import Model.Usuario;

public class UsuarioDao {
    
    private Connection conn;
    public UsuarioDao() {
        this.conn = ConnectionFabric.getConnection("root","yandermm1", "jdbc:mysql://localhost:3306/ecommerce");
    }
        // Método para adicionar um usuário
        public void adicionarUsuario(Usuario usuario) {
            String sql = "INSERT INTO usuario (nome, email, senha, endereco) VALUES (?, ?, ?, ?)";
    
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
    
                statement.setString(1, usuario.getNome());
                statement.setString(2, usuario.getEmail());
                statement.setString(3, usuario.getSenha());
                statement.setString(4, usuario.getEndereco());
                statement.executeUpdate();
    
                System.out.println("Usuário adicionado com sucesso!");
    
            } catch (SQLException e) {
                System.err.println("Erro ao adicionar usuário: " + e.getMessage());
            } finally {
                ConnectionFabric.closeConnection();
            }
        }
    
        // Método para buscar um usuário pelo ID
        public Usuario buscarUsuarioPorId(int id) {
            String sql = "SELECT * FROM usuario WHERE id = ?";
            Usuario usuario = null;
    
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
    
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
    
                if (resultSet.next()) {
                    usuario = new Usuario(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email"),
                            resultSet.getString("senha"),
                            resultSet.getString("endereco")
                    );
                }
    
            } catch (SQLException e) {
                System.err.println("Erro ao buscar usuário: " + e.getMessage());
            } finally {
                ConnectionFabric.closeConnection();
            }
    
            return usuario;
        }
    
        // Método para listar todos os usuários
        public List<Usuario> listarUsuarios() {
            String sql = "SELECT * FROM usuario";
            List<Usuario> usuarios = new ArrayList<>();
    
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
    
                while (resultSet.next()) {
                    Usuario usuario = new Usuario(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email"),
                            resultSet.getString("senha"),
                            resultSet.getString("endereco")
                    );
                    usuarios.add(usuario);
                }
    
            } catch (SQLException e) {
                System.err.println("Erro ao listar usuários: " + e.getMessage());
            } finally {
                ConnectionFabric.closeConnection();
            }
    
            return usuarios;
        }
    
        // Método para atualizar um usuário
        public void atualizarUsuario(Usuario usuario) {
            String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, endereco = ? WHERE id = ?";
    
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
    
                statement.setString(1, usuario.getNome());
                statement.setString(2, usuario.getEmail());
                statement.setString(3, usuario.getSenha());
                statement.setString(4, usuario.getEndereco());
                statement.setInt(5, usuario.getId());
                statement.executeUpdate();
    
                System.out.println("Usuário atualizado com sucesso!");
    
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar usuário: " + e.getMessage());
            }
        }
    
        // Método para deletar um usuário pelo ID
        public void deletarUsuario(int id) {
            String sql = "DELETE FROM usuario WHERE id = ?";
    
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
    
                statement.setInt(1, id);
                statement.executeUpdate();
    
                System.out.println("Usuário deletado com sucesso!");
    
            } catch (SQLException e) {
                System.err.println("Erro ao deletar usuário: " + e.getMessage());
            }  finally {
                ConnectionFabric.closeConnection();
            }
        }
    
    

}
