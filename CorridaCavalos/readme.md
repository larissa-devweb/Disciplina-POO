# Simulação de Corrida de Cavalos com Threads em Java

Este projeto é uma simulação gráfica simples de uma corrida de cavalos usando Java. Cada cavalo é representado por uma thread que se move aleatoriamente, e a corrida é mostrada numa janela gráfica com Java Swing.

---

## Objetivos do Projeto

- Demonstrar o uso de **threads** em Java para executar tarefas simultâneas.
- Criar uma interface gráfica usando **Java Swing** para visualização da corrida.
- Entender conceitos básicos de concorrência e atualização gráfica periódica.

---

## Como o Projeto Funciona

### 1. Classe `Cavalo`

- Representa um cavalo na corrida.
- Cada cavalo tem:
  - **Nome**: identificação do cavalo.
  - **Posição atual**: distância percorrida na pista.
  - **Cor**: para desenhar na interface gráfica.
- Implementa a interface `Runnable` para que cada cavalo possa rodar em uma thread separada.
- O método `run()`:
  - Atualiza a posição do cavalo periodicamente com uma velocidade aleatória.
  - Usa `Thread.sleep()` para pausar entre atualizações, simulando o tempo que o cavalo "corre".
  - Termina quando o cavalo atinge a distância total da corrida.

### 2. Classe `PainelCorrida`

- Extende o `JPanel` do Swing.
- Responsável por desenhar a pista e os cavalos na tela.
- Sobrescreve o método `paintComponent(Graphics g)` para:
  - Limpar a área de desenho.
  - Desenhar a pista (fundo cinza claro).
  - Desenhar cada cavalo como um círculo colorido na sua posição atual.
  - Mostrar o nome do cavalo ao lado do círculo.

### 3. Classe Principal (`CorridaCavalosMain`)

- Cria a janela principal (`JFrame`) configurando tamanho e operação de fechar.
- Inicializa os cavalos com nomes e cores diferentes.
- Cria o painel da corrida com os cavalos e adiciona na janela.
- Inicia uma thread para cada cavalo, fazendo-os "correr" em paralelo.
- Usa um `java.util.Timer` para chamar o `repaint()` do painel periodicamente, atualizando a visualização da corrida na tela.

---

## Detalhes Técnicos e Explicações

### Uso de Threads

- A interface `Runnable` permite que a classe `Cavalo` defina o comportamento da thread.
- Cada cavalo é executado em sua própria thread, possibilitando que todos avancem simultaneamente e independentemente.
- O `Thread.sleep()` dentro do `run()` faz a thread "dormir" por um tempo, simulando o ritmo da corrida.

### Atualização Gráfica com Timer

- O Swing exige que atualizações gráficas ocorram na *Event Dispatch Thread* (EDT).
- Para garantir isso, usamos `SwingUtilities.invokeLater()` dentro do Timer.
- O `Timer` dispara uma tarefa a cada 100 milissegundos para chamar `painel.repaint()`, redesenhando a cena.

### Organização do Código

- Cada classe está em um arquivo `.java` separado dentro do pacote `com.mycompany.corridacavalos`.
- Isso facilita a manutenção e evita problemas de compilação com Maven.

---

## Como Executar

1. Clone ou baixe este repositório.
2. Abra no NetBeans ou qualquer IDE que suporte Maven.
3. Compile o projeto.
4. Execute a classe principal `com.mycompany.corridacavalos.CorridaCavalosMain`.
5. A janela da corrida aparecerá, e os cavalos começarão a se mover na tela.

---

## Possíveis Melhorias

- Mostrar na interface o cavalo vencedor com uma mensagem.
- Adicionar botão para reiniciar a corrida.
- Ajustar velocidade e distância para corrida mais realista.
- Melhorar a interface gráfica com imagens ao invés de círculos.

---

## Conclusão

Este projeto une conceitos importantes de programação concorrente e interfaces gráficas em Java, mostrando de forma prática como threads podem ser usadas para simular processos paralelos e como Swing pode atualizar a tela em tempo real.



