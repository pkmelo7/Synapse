package com.mycompany.classes;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public class FontePersonalizada {

    public static Font poppins;

    public static void carregarFonte() {
        try {
            // Carregar a fonte do classpath
            InputStream fontStream = FontePersonalizada.class.getClassLoader()
                    .getResourceAsStream("fonts/Poppins-Bold.ttf");

            if (fontStream == null) {
                throw new IllegalArgumentException("Fonte não encontrada em 'fonts/Poppins-Bold.ttf'");
            }

            // Criar a fonte
            poppins = Font.createFont(Font.TRUETYPE_FONT, fontStream);

            // Registrar a fonte no ambiente gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a fonte: " + e.getMessage());
        }
    }

    public static Font getFonte(float tamanho) {
        if (poppins != null) {
            return poppins.deriveFont(tamanho); // Retorna a fonte com o tamanho especificado
        }
        throw new IllegalStateException("A fonte não foi carregada. Chame carregarFonte() primeiro.");
    }

    public static void main(String[] args) {
        carregarFonte();
        Font fonteComTamanho = getFonte(40f); // Exemplo de uso da fonte
        System.out.println("Fonte carregada: " + fonteComTamanho.getFontName());
    }
}
