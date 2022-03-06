/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class ConexaoMysql {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_upload_images?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "9320";
    private static Connection conexao = null;

    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro de conexão\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            return conexao;
        }
    }
    
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException{
        if (conexao == null){
            conexao = getConexao();
        }
        try {
            return conexao.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: " + e.getMessage());
        }
        return null;
    }
    
}
