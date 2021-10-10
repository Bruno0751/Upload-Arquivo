/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ArquivoDAO;
import model.Arquivo;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class ArquivoServices {
    
    public boolean insert(Arquivo obj) throws SQLException{
        boolean retorno = false;
        try {
            ArquivoDAO arquivoDAO = new ArquivoDAO();
            arquivoDAO.inserindo(obj);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO");
            System.out.println("Erro no Servço");
            e.printStackTrace();
        }
        return retorno;
    }
    
}
