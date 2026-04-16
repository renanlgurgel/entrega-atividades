import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaJogo window = new TelaJogo();
                // A classe TelaJogo deve gerenciar a visibilidade do seu próprio JFrame
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}