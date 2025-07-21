package com.mycompany.corridacavalos;

// Importa classes para cores e números aleatórios
import java.awt.Color;
import java.util.Random;

// Classe Cavalo representa cada cavalo da corrida
public class Cavalo implements Runnable { // Runnable permite que o cavalo rode como uma thread

    private static final int DISTANCIA_TOTAL = 1000; // Distância final da corrida
    private static final int INTERVALO_ATUALIZACAO = 500; // Tempo entre movimentos (ms)

    private String nome;       // Nome do cavalo
    private int posicao;       // Posição atual na pista
    private Color cor;         // Cor do cavalo para desenhar
    private Random aleatorio;  // Gera números aleatórios para a velocidade
    private boolean terminou;  // Diz se o cavalo já cruzou a linha de chegada

    // Construtor: define nome e cor
    public Cavalo(String nome, Color cor) {
        this.nome = nome;              // Define o nome do cavalo
        this.cor = cor;                // Define a cor
        this.posicao = 0;              // Começa na posição zero
        this.aleatorio = new Random(); // Inicializa gerador aleatório
        this.terminou = false;         // Ainda não terminou
    }

    // Método que executa quando a thread do cavalo inicia
    @Override
    public void run() {
        while (posicao < DISTANCIA_TOTAL && !terminou) {
            // Escolhe velocidade aleatória entre 5 e 20
            int velocidade = aleatorio.nextInt(16) + 5;

            posicao += velocidade; // Atualiza a posição do cavalo

            // Aguarda intervalo antes de atualizar de novo
            try {
                Thread.sleep(INTERVALO_ATUALIZACAO);
            } catch (InterruptedException e) {
                System.out.println(nome + " foi interrompido!");
                break; // Sai do loop se a thread for interrompida
            }
        }

        terminou = true; // Marca que o cavalo terminou
        System.out.println(nome + " terminou a corrida!");
    }

    // Métodos para acessar os atributos (getters)
    public int obterPosicao() {
        return posicao;
    }

    public Color obterCor() {
        return cor;
    }

    public String obterNome() {
        return nome;
    }

    public boolean terminou() {
        return terminou;
    }
}
