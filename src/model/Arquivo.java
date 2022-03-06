/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno
 */
public class Arquivo {
    
    private BufferedImage imagemBF;
    private long idArquivo;
    private byte[] arquivoByte;

    public long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public byte[] getArquivoByte() {
        return arquivoByte;
    }

    public void setArquivoByte(byte[] arquivoByte) {
        this.arquivoByte = arquivoByte;
    }

    public BufferedImage getImagemBF() {
        return imagemBF;
    }

    public void setImagemBF(BufferedImage imagemBF) {
        this.imagemBF = imagemBF;
    }
    
    
    
}
