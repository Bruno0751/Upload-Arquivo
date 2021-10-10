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
    
    private BufferedImage imagem;
    private long idArquivo;
    private byte[] arquivo;

    public long getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }
    
    
    
}
