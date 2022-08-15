package view;

import dao.ArquivoDAO;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import model.Arquivo;
import utl.ManipularArquivo;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class GUIInsertFile extends javax.swing.JFrame {

    private String ipDaMaquina;
    Arquivo obj = new Arquivo();
    
    /**
     * Creates new form GUIMain
     */
    public GUIInsertFile() throws UnknownHostException {
        initComponents();
        this.ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
    }
    
    long idArquivo;
    String nome;
    BufferedImage imagemBF;
    byte[] arquivoBytes;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonInserir = new javax.swing.JButton();
        jLabelIconArquivo = new javax.swing.JLabel();
        jButtonEnviar = new javax.swing.JButton();
        jButtonPrj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bem Vindo");

        jButtonInserir.setText("Cadastrar");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jButtonPrj.setText("Projeto");
        jButtonPrj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonInserir)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPrj))
                            .addComponent(jButtonEnviar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelIconArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserir)
                    .addComponent(jButtonPrj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIconArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        //BOTAO CADASTRAR
        JFileChooser jFileChoose = new JFileChooser();
        
        int resultado = jFileChoose.showOpenDialog(null);
        

        if (resultado == JFileChooser.APPROVE_OPTION) {
            
            File arquivo = jFileChoose.getSelectedFile();
            obj.setNome(arquivo.getName());
            
            try {
                // FAZ UMA VALIDAÇÃO MAS NÃO É NECESSÁRIO
                imagemBF = ManipularArquivo.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
                
                jLabelIconArquivo.setIcon(new ImageIcon(imagemBF));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro", "Erro" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        //BOTAO ENVIAR
        obj.setArquivoByte(ManipularArquivo.getImgBytes(imagemBF));
        try {
            
            boolean foi = ArquivoDAO.inserindo(obj);
            
            if (foi) {
                JOptionPane.showMessageDialog(null, "Imagem enviada com sucesso");
                jLabelIconArquivo.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(null, "Imagem não enviada");
                jLabelIconArquivo.setIcon(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO");
            System.out.println("Erro ao Inserir IMG");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButtonPrjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrjActionPerformed
        if (this.ipDaMaquina.contains("192.168.")) {
            try {
                Desktop.getDesktop().open(new File("D:\\PrjDesktopJava\\ok\\Upload Arquivo"));
            } catch (IOException ex) {
                Logger.getLogger(GUIInsertFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonPrjActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonPrj;
    private javax.swing.JLabel jLabelIconArquivo;
    // End of variables declaration//GEN-END:variables
}
