package juego.triqui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriquiGUI extends JFrame {
    private static final int SIZE = 3;
    private JButton[][] botones = new JButton[SIZE][SIZE];
    private Triqui triqui;
    private JLabel marcadorLabel;
    private int marcadorHumano = 0;
    private int marcadorComputadora = 0;
    private int contadorRondas = 0;

    public TriquiGUI() {
        triqui = new Triqui();
        initGUI();
    }

    private void initGUI() {
        setTitle("Triqui");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelTablero = new JPanel();
        panelTablero.setLayout(new GridLayout(SIZE, SIZE));
        Font font = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                botones[i][j] = new JButton(" ");
                botones[i][j].setFont(font); // Establecer tamaño de fuente para X y O
                final int fila = i;
                final int col = j;
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        botonClicado(fila, col);
                    }
                });
                panelTablero.add(botones[i][j]);
            }
        }

        marcadorLabel = new JLabel("Humano: 0 - Computadora: 0");
        add(marcadorLabel, BorderLayout.NORTH);
        add(panelTablero, BorderLayout.CENTER);

        setSize(400, 400);
        setVisible(true);
    }

    private void botonClicado(int fila, int col) {
        try {
            if (triqui.getTablero()[fila][col] == ' ') {
                botones[fila][col].setText("X");
                triqui.getTablero()[fila][col] = 'X';

                if (triqui.verificarGanador('X')) {
                    JOptionPane.showMessageDialog(this, "¡Has ganado!");
                    marcadorHumano++;
                    contadorRondas++;
                    reiniciarTablero();
                } else if (triqui.esEmpate()) {
                    JOptionPane.showMessageDialog(this, "¡Es un empate!");
                    contadorRondas++;
                    reiniciarTablero();
                } else {
                    triqui.getComputadora().realizarMovimiento(triqui.getTablero(), 'O');
                    actualizarTablero();

                    if (triqui.verificarGanador('O')) {
                        JOptionPane.showMessageDialog(this, "¡La computadora ha ganado!");
                        marcadorComputadora++;
                        contadorRondas++;
                        reiniciarTablero();
                    } else if (triqui.esEmpate()) {
                        JOptionPane.showMessageDialog(this, "¡Es un empate!");
                        contadorRondas++;
                        reiniciarTablero();
                    }
                }

                if (contadorRondas == 3) {
                    determinarGanadorFinal();
                    reiniciarMarcadores();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void actualizarTablero() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (triqui.getTablero()[i][j] == 'O') {
                    botones[i][j].setText("O");
                }
            }
        }
    }

    private void reiniciarTablero() {
        triqui = new Triqui();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                botones[i][j].setText(" ");
            }
        }
        marcadorLabel.setText("Humano: " + marcadorHumano + " - Computadora: " + marcadorComputadora);
    }

    private void determinarGanadorFinal() {
        if (marcadorHumano > marcadorComputadora) {
            JOptionPane.showMessageDialog(this, "¡Felicidades! ¡Eres el ganador final!");
        } else if (marcadorComputadora > marcadorHumano) {
            JOptionPane.showMessageDialog(this, "¡La computadora es la ganadora final!");
        } else {
            JOptionPane.showMessageDialog(this, "¡Es un empate general!");
        }
    }

    private void reiniciarMarcadores() {
        marcadorHumano = 0;
        marcadorComputadora = 0;
        contadorRondas = 0;
        marcadorLabel.setText("Humano: 0 - Computadora: 0");
    }
}