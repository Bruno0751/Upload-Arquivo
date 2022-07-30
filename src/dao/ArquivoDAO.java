package dao;

import model.Arquivo;
import persistence.ConexaoMysql;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bruno
 */
public class ArquivoDAO {
    
    public static boolean inserindo(Arquivo obj) throws SQLException, ClassNotFoundException{
        Boolean retorno = false;
        String sql = "INSERT INTO arquivos VALUE (NULL, ?, ?, NOW(), NOW())";
        PreparedStatement pst = ConexaoMysql.getPreparedStatement(sql);
        try{
            
            pst.setBytes(1, obj.getArquivoByte());
            pst.setString(2, obj.getNome());
            pst.executeUpdate();
            retorno = true;
        }catch(SQLException ex){
            System.out.println("ERRO NO SQL");
        }finally{
            pst.close();
        }
        return retorno;
    }    
}
