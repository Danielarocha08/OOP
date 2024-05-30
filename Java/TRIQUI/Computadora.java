package juego.triqui;

import juego.excepciones.MovimientoInvalidoException;

public class Computadora implements Jugador {
    @Override
    public void realizarMovimiento(char[][] tablero, char jugador) throws MovimientoInvalidoException {
        int[] mejorMovimiento = encontrarMejorMovimiento(tablero);
        tablero[mejorMovimiento[0]][mejorMovimiento[1]] = jugador;
    }

    private int[] encontrarMejorMovimiento(char[][] tablero) {
        int mejorValor = Integer.MIN_VALUE;
        int[] mejorMovimiento = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    tablero[i][j] = 'O';
                    int movimientoValor = minimax(tablero, 0, false);
                    tablero[i][j] = ' ';
                    if (movimientoValor > mejorValor) {
                        mejorMovimiento[0] = i;
                        mejorMovimiento[1] = j;
                        mejorValor = movimientoValor;
                    }
                }
            }
        }
        return mejorMovimiento;
    }

    private int minimax(char[][] tablero, int profundidad, boolean esMax) {
        int puntaje = evaluar(tablero);

        if (puntaje == 10) return puntaje - profundidad;
        if (puntaje == -10) return puntaje + profundidad;
        if (esEmpate(tablero)) return 0;

        if (esMax) {
            int mejor = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == ' ') {
                        tablero[i][j] = 'O';
                        mejor = Math.max(mejor, minimax(tablero, profundidad + 1, false));
                        tablero[i][j] = ' ';
                    }
                }
            }
            return mejor;
        } else {
            int mejor = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == ' ') {
                        tablero[i][j] = 'X';
                        mejor = Math.min(mejor, minimax(tablero, profundidad + 1, true));
                        tablero[i][j] = ' ';
                    }
                }
            }
            return mejor;
        }
    }

    private int evaluar(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                if (tablero[i][0] == 'O') return 10;
                else if (tablero[i][0] == 'X') return -10;
            }
            if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                if (tablero[0][i] == 'O') return 10;
                else if (tablero[0][i] == 'X') return -10;
            }
        }

        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            if (tablero[0][0] == 'O') return 10;
            else if (tablero[0][0] == 'X') return -10;
        }

        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            if (tablero[0][2] == 'O') return 10;
            else if (tablero[0][2] == 'X') return -10;
        }

        return 0;
    }

    private boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}