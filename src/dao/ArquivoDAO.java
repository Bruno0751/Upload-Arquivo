/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Arquivo;
import persistence.ConexaoMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bruno
 */
public class ArquivoDAO {
    
    public boolean inserindo(Arquivo obj) throws SQLException, ClassNotFoundException{
        Boolean retorno = false;
        String sql = "INSERT INTO arquivos VALUE (NULL, ?, NOW())";
        PreparedStatement pst = ConexaoMysql.getPreparedStatement(sql);
        try{
            
            pst.setBytes(1, obj.getArquivo());
            pst.executeUpdate();
            retorno = true;
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("ERRO NO SQL");
        }finally{
            
        }
        return retorno;
    }    
}
