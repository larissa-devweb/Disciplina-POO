/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.corridacavalos;

// Importa classes para interface gráfica
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

// Classe PainelCorrida desenha os cavalos na tela
public class PainelCorrida extends JPanel {

    private Cavalo[] cavalos; // Vetor com todos os cavalos

    // Construtor: recebe vetor de cavalos
    public PainelCorrida(Cavalo[] cavalos) {
        this.cavalos = cavalos;
    }

    // Método para desenhar o painel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa o painel

        // Desenha a pista
        g.setColor(Color.GRAY); // Cor da pista
        g.fillRect(0, 0, getWidth(), getHeight()); // Preenche o fundo da pista

        // Para cada cavalo, desenha na posição correta
        for (int i = 0; i < cavalos.length; i++) {
            Cavalo cavalo = cavalos[i];
            g.setColor(cavalo.obterCor()); // Define a cor do cavalo

            int y = 50 + i * 50;            // Linha vertical de cada cavalo
            int x = cavalo.obterPosicao(); // Posição horizontal
            g.fillOval(x, y, 30, 30);       // Desenha o cavalo como um círculo
            g.setColor(Color.BLACK);        // Cor do texto
            g.drawString(cavalo.obterNome(), x + 35, y + 20); // Escreve o nome
        }
    }
}
