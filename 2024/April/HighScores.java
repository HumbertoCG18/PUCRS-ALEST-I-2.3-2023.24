package April;
/**
 * @author Humberto Corrêa Gomes
 * Classe que implementa uma lista com os 10 maiores scores. 
 */
public class HighScores {
    // 
    // Não é necessário alterar os atributos nem o construtor da classe. 
    // Apenas complete os métodos indicados, utilizando os recursos já implementados da classe ListArray
    //
    
    private ListArray scores;

    public HighScores() {
        scores = new ListArray();
    }

    public void insereScore(int score) {
        if (scores.size() < 10) { //Adiciona uma nova pontuação na ordem, caso tenha menos que 10 pontuações
            scores.addDecreasingOrder(score);
        } else {
            if (score > scores.get(9)) { // Se a nova pontuação for maior que a menor pontuação atual
                scores.remove(9); // Remove a menor pontuação atual
                scores.addDecreasingOrder(score); // Adiciona a nova pontuação na ordem correta
            }
        }
    }

    public void listaScores() {
        System.out.println("High Scores:");
        for (int i = 0; i < scores.size(); i++) {
            System.out.println((i + 1) + ". " + scores.get(i));
        }
    }
}