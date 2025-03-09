package Controller.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFabric {

    private static Connection conn = null;

    private ConnectionFabric() {
    }

    public static Connection getConnection(String user, String password, String url) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Conexão com o MySQL estabelecida com sucesso!");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do MySQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados MySQL!");
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
            System.out.println("Conexão com o MySQL fechada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados MySQL!");
            e.printStackTrace();
        }
    }
}
