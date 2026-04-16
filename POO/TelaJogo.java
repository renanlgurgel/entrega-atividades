import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaJogo {
    private JogoDaForca jogo;
    private JFrame frame;
    private JTextField txtLetra;
    private JLabel lblPalavra, lblDica, lblResultado, lblAcertos, lblPenalidade, lblImagem;
    private JTextArea areaHistorico;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaJogo window = new TelaJogo();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaJogo() {
        jogo = new JogoDaForca();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Jogo da Forca - POO 2026");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JButton btnIniciar = new JButton("Iniciar Jogo");
        lblPalavra = new JLabel("Palavra: ****");
        lblDica = new JLabel("Dica: ");
        txtLetra = new JTextField(2);
        JButton btnAdivinhar = new JButton("Adivinhar");
        lblResultado = new JLabel("Resultado: -");
        lblAcertos = new JLabel("Acertos: 0");
        lblPenalidade = new JLabel("Penalidade: 0 - sem penalidades");
        lblImagem = new JLabel("IMG");
        areaHistorico = new JTextArea(5, 30);

        frame.add(btnIniciar);
        frame.add(lblDica);
        frame.add(lblPalavra);
        frame.add(new JLabel("Digite uma letra:"));
        frame.add(txtLetra);
        frame.add(btnAdivinhar);
        frame.add(lblResultado);
        frame.add(lblAcertos);
        frame.add(lblPenalidade);
        frame.add(lblImagem);
        frame.add(new JScrollPane(areaHistorico));

        btnIniciar.addActionListener(e -> {
            jogo.iniciar();
            atualizarTela();
            btnAdivinhar.setEnabled(true);
        });

        btnAdivinhar.addActionListener(e -> {
            try {
                jogo.getOcorrencias(txtLetra.getText());
                atualizarTela();
                txtLetra.setText("");
                if (jogo.terminou()) {
                    btnAdivinhar.setEnabled(false);
                    atualizarHistorico();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
    }

    private void atualizarTela() {
        lblPalavra.setText("Palavra: " + jogo.getPalavra());
        lblDica.setText("Dica: " + jogo.getDica());
        lblAcertos.setText("Acertos: " + jogo.getAcertos());
        lblPenalidade.setText("Penalidade: " + jogo.getCodigoPenalidade() + " - " + jogo.getNomePenalidade());
        lblResultado.setText("Status: " + jogo.getResultado());

    }

    private void atualizarHistorico() {
        areaHistorico.setText("");
        for (String res : jogo.getResultados()) {
            areaHistorico.append(res + "\n");
        }
    }
}