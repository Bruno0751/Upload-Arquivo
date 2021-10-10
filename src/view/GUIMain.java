/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Arquivo;
import services.ArquivoServices;
import utl.ManipularArquivo;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class GUIMain extends javax.swing.JFrame {

    /**
     * Creates new form GUIMain
     */
    
    public GUIMain() {
        initComponents();
    }

    Arquivo obj = new Arquivo();
    ArquivoServices arquivoServices = new ArquivoServices();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSelect = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();
        jLabelIconArquivo = new javax.swing.JLabel();
        jButtonSusbit = new javax.swing.JButton();
        button1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bem Vindo");

        jButtonSelect.setText("Buscar");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        jButtonInsert.setText("Cadastrar");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonSusbit.setText("Enviar");
        jButtonSusbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSusbitActionPerformed(evt);
            }
        });

        button1.setLabel("button1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInsert)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSelect))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonSusbit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelIconArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsert)
                    .addComponent(jButtonSelect))
                .addGap(18, 18, 18)
                .addComponent(jLabelIconArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSusbit)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        new GUIASelected().setVisible(true);
    }//GEN-LAST:event_jButtonSelectActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        //        new GUIInserted().setVisible(true);
        JFileChooser jFileChoose = new JFileChooser();
        int resultado = jFileChoose.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            
            File arquivo = jFileChoose.getSelectedFile();
            try {
                // FAZ UMA VALIDAÇÃO MAS NÃO É NECESSÁRIO
                obj.setImagem(ManipularArquivo.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160));
                
                jLabelIconArquivo.setIcon(new ImageIcon(obj.getImagem()));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jButtonSusbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSusbitActionPerformed
        obj.setArquivo(ManipularArquivo.getImgBytes(obj.getImagem()));
        try {
            boolean foi = arquivoServices.insert(obj);
            if(foi){
                JOptionPane.showMessageDialog(null, "Imagem enviada com sucesso");
                jLabelIconArquivo.setIcon(null);
            }else{
                JOptionPane.showMessageDialog(null, "Imagem não enviada");
                 jLabelIconArquivo.setIcon(null);
            }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "ERRO");
           System.out.println("Erro ao Inserir IMG");
           ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSusbitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonSusbit;
    private javax.swing.JLabel jLabelIconArquivo;
    // End of variables declaration//GEN-END:variables
}
