package model;

import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno
 */
public class Arquivo {
    
    private String nome;
    private byte[] arquivoByte;

    public byte[] getArquivoByte() {
        return arquivoByte;
    }

    public void setArquivoByte(byte[] arquivoByte) {
        this.arquivoByte = arquivoByte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
