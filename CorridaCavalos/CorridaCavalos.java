//main aqui
package com.mycompany.corridacavalos;

/**
 *
 * @author lg_11
 */
// Importa classes para interface gráfica e temporização
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

// Classe principal da aplicação
public class CorridaCavalos {

    public static void main(String[] args) {
        // Cria a janela principal
        JFrame janela = new JFrame("Corrida de Cavalos");
        janela.setSize(1200, 300); // Tamanho da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X

        // Cria os cavalos com nomes e cores diferentes
        Cavalo[] cavalos = new Cavalo[4];
        cavalos[0] = new Cavalo("Cavalo Vermelho", Color.RED);
        cavalos[1] = new Cavalo("Cavalo Azul", Color.BLUE);
        cavalos[2] = new Cavalo("Cavalo Verde", Color.GREEN);
        cavalos[3] = new Cavalo("Cavalo Laranja", Color.ORANGE);

        // Cria o painel da corrida e adiciona à janela
        PainelCorrida painel = new PainelCorrida(cavalos);
        janela.add(painel); // Coloca o painel na janela
        janela.setVisible(true); // Exibe a janela

        // Inicia uma thread para cada cavalo
        for (Cavalo cavalo : cavalos) {
            Thread thread = new Thread(cavalo);
            thread.start(); // Inicia a corrida para o cavalo
        }

        // Cria um Timer para atualizar o painel a cada 100ms
        Timer cronometro = new Timer();
        cronometro.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Atualiza o painel na thread de interface (EDT)
                SwingUtilities.invokeLater(() -> painel.repaint());

                // Verifica se algum cavalo venceu
                for (Cavalo cavalo : cavalos) {
                    if (cavalo.obterPosicao() >= 1000) {
                        cronometro.cancel(); // Para o timer
                        JOptionPane.showMessageDialog(janela,
                            cavalo.obterNome() + " venceu a corrida!");
                        return; // Sai do método
                    }
                }
            }
        }, 0, 100); // Delay inicial = 0ms, repete a cada 100ms
    }
}
