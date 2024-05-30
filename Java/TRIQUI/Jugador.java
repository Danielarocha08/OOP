package juego.triqui;

import juego.excepciones.MovimientoInvalidoException;

public interface Jugador {
    void realizarMovimiento(char[][] tablero, char jugador) throws MovimientoInvalidoException;
}
