import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class JogoDaForca {
    private ArrayList<String> palavras = new ArrayList<>();
    private ArrayList<String> dicas = new ArrayList<>();
    private ArrayList<String> historico = new ArrayList<>();

    private String palavraSorteada;
    private String dicaSorteada;
    private char[] letrasAdivinhadas;
    private int acertos;
    private int penalidade;
    private String[] nomesPenalidades = {
            "sem penalidades", "perdeu primeira perna", "perdeu segunda perna",
            "perdeu primeiro braço", "perdeu segundo braço", "perdeu tronco", "perdeu cabeça"
    };

    public JogoDaForca() {
        try (Scanner input = new Scanner(new File("C:\\Users\\renan\\IdeaProjects\\poo\\Arquivos necessários\\palavras.csv"))) {
            while (input.hasNextLine()) {
                String[] linha = input.nextLine().split(" ");
                if (linha.length >= 2) {
                    palavras.add(linha[0].toUpperCase());
                    dicas.add(linha[1]);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void iniciar() {
        Random random = new Random();
        int indice = random.nextInt(palavras.size());
        palavraSorteada = palavras.get(indice);
        dicaSorteada = dicas.get(indice);
        letrasAdivinhadas = new char[palavraSorteada.length()];
        for (int i = 0; i < letrasAdivinhadas.length; i++) {
            letrasAdivinhadas[i] = '*';
        }
        acertos = 0;
        penalidade = 0;
    }

    public String getDica() { return dicaSorteada; }

    public String getPalavra() {
        return new String(letrasAdivinhadas);
    }

    String letra;

    public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
        if (letra == null || letra.length() != 1) {
            throw new Exception("A entrada deve conter exatamente 1 caractere.");
        }

        letra = letra.toUpperCase();
        char charLetra = letra.charAt(0);
        ArrayList<Integer> posicoes = new ArrayList<>();

        boolean encontrou = false;
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if (palavraSorteada.charAt(i) == charLetra) {
                if (letrasAdivinhadas[i] == '*') {
                    letrasAdivinhadas[i] = charLetra;
                    acertos++;
                }
                posicoes.add(i + 1); // Posições de 1 a N [cite: 20]
                encontrou = true;
            }
        }

        if (!encontrou) {
            penalidade++;
        }

        if (terminou()) {
            historico.add(palavraSorteada + " - " + getResultado());
        }

        return posicoes;
    }

    public boolean terminou() {
        return acertos == palavraSorteada.length() || penalidade >= 6;
    }

    public int getAcertos() { return acertos; }

    public int getCodigoPenalidade() { return penalidade; }

    public String getNomePenalidade() { return nomesPenalidades[penalidade]; }

    public String getResultado() {
        if (acertos == palavraSorteada.length()) return "venceu";
        if (penalidade >= 6) return "perdeu";
        return "em andamento";
    }

    public ArrayList<String> getResultados() { return historico; }
}