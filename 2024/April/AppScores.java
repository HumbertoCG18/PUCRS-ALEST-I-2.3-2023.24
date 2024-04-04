public class AppScores {

    // classe para teste do exercício HighScores
    // esta classe não deve ser alterada
    public static void main(String[] args) {
        HighScores hs = new HighScores();
        hs.insereScore(300);
        hs.insereScore(200);
        hs.insereScore(50);
        hs.insereScore(30);
        hs.insereScore(250);
        hs.insereScore(120);
        hs.insereScore(90);
        hs.insereScore(280);
        hs.insereScore(139);
        hs.insereScore(270);
        hs.insereScore(400);
        hs.insereScore(100);
        hs.listaScores();
    }
}