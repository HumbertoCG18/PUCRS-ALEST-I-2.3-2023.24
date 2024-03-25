// 4645G-04 - Algoritmos e Estruturas de Dados I
// 2023-1

//import java.time.chrono.IsoChronology;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class WordTree {

    // Classe interna
    private class CharNode {
        private char character;
        private String significado;
        private boolean isFinal;
        private CharNode father;
        private List<CharNode> children;

        public CharNode(char character, CharNode father, boolean isFinal) {
            this.character = character;
            this.father = father;
            this.isFinal = isFinal;
            this.children = new ArrayList<CharNode>();
        }

        public CharNode(char character, CharNode father, boolean isFinal, String significado) {
            this.character = character;
            this.children = new ArrayList<CharNode>();
            this.father = father;
            this.isFinal = isFinal;
            this.significado = significado;
        }

        /**
         * Adiciona um filho (caracter) no nodo. Não pode aceitar caracteres repetidos.
         * 
         * @param character - caracter a ser adicionado
         * @param isfinal   - se é final da palavra ou não
         */
        public CharNode addChild(char character, boolean isfinal, String significado) {
            CharNode aux = new CharNode(character, this, isfinal, significado);
            if (character != ' ') {
                boolean exists = false;
                // check se ja existe
                for (CharNode node : this.children) {
                    if (node.character == character) {
                        exists = true;
                        aux = node;
                    }
                }
                // se n existe:
                if (!exists) {

                    this.children.add(aux);

                    return aux;
                }

            }
            return aux;
        }

        public CharNode addChild(char character, boolean isfinal) {
            CharNode aux = new CharNode(character, this, isfinal, significado);
            if (character != ' ') {
                boolean exists = false;
                // check se ja existe
                for (CharNode node : this.children) {
                    if (node.character == character) {
                        exists = true;
                        aux = node;
                    }
                }
                // se n existe:
                if (!exists) {

                    this.children.add(aux);

                    return aux;
                }

            }
            return aux;
        }

        public int getNumberOfChildren() {
            return children.size();
        }

        public CharNode getChild(int index) {
            return children.get(index);
        }

        /**
         * Obtém a palavra correspondente a este nodo, subindo até a raiz da árvore
         * 
         * @return a palavra
         */
        private String getWord() {
            if (father.character == '*') {
                return String.valueOf(character);
            } else {
                return father.getWord() + character;
            }
        }

        /**
         * Encontra e retorna o nodo que tem determinado caracter.
         * 
         * @param character - caracter a ser encontrado.
         */
        public CharNode findChildChar(char character) {
            if (character != ' ') {
                for (CharNode node : this.children) {
                    if (node.character == character) {
                        return node;
                    }
                }
            }
            return null;
        }

    }

    // Atributos
    private CharNode root;
    private int totalNodes = 0;
    private int totalWords = 0;

    // Construtor
    public WordTree() {
        this.root = new CharNode('*', null, false, null);
        this.totalNodes = 0;
        this.totalWords = 0;
    }

    // Metodos
    public int getTotalWords() {
        return totalWords;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    /**
     * Adiciona palavra na estrutura em árvore
     * 
     * @param word
     */
    public void addWord(String word, String significado) {
        if (word != "") {
            CharNode aux = this.root;
            for (int c = 0; c < word.length(); c++) {
                char caracAux = word.charAt(c);
                if (c == word.length() - 1) {
                    aux = aux.addChild(caracAux, true, significado);

                } else {
                    aux = aux.addChild(caracAux, false);
                }
                this.totalNodes++;

            }
            this.totalWords++;
        }
    }

    /**
     * Vai descendo na árvore até onde conseguir encontrar a palavra
     * 
     * @param word
     * @return o nodo final encontrado
     */
    private CharNode findCharNodeForWord(String word) {
        CharNode atual = root;

        for (int i = 0; i < word.length(); i++) {
            if (atual == null) {
                return null;
            }
            if (i == 0) {
                atual = atual.findChildChar(Character.toUpperCase(word.charAt(i)));
            } else {
                atual = atual.findChildChar(Character.toLowerCase(word.charAt(i)));

            }

        }
        return atual;

    }

    /**
     * Percorre a árvore e retorna uma lista com as palavras iniciadas pelo prefixo
     * dado.
     * Tipicamente, um método recursivo.
     * 
     * @param prefix
     */
    private void searchAll(CharNode atual, List<String> list) {
        if (atual.isFinal) {
            list.add(atual.getWord());
        }
        for (CharNode n : atual.children) {
            searchAll(n, list);

        }
    }

    public List<String> searchAll(String prefix) {
        List<String> list = new ArrayList<>();
        CharNode atual = findCharNodeForWord(prefix);
        if (atual == null) {
            return list;
        }
        searchAll(atual, list);
        return list;
    }

}
