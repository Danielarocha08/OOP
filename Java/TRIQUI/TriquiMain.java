package triquimain;

import javax.swing.SwingUtilities;
import juego.triqui.TriquiGUI;

public class TriquiMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TriquiGUI());
    }
}