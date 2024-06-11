package June.T1;

import java.util.ArrayList;
import java.util.List;

public class GenealogyTree {
    private Node raiz;

    private static class Node {
        String Elem;
        Node Pai;
        List<Node> Filhos;

        public Node(String valor) {
            Elem = valor;
            Pai = null;
            Filhos = new ArrayList<>();
        }
    }

    public GenealogyTree(String elem) {
        raiz = new Node(elem);
    }

    public void inserir(String elem, String paiStr) {
        Node pai = pesquisa(paiStr, raiz);
        if (pai != null) {
            Node novo = new Node(elem);
            novo.Pai = pai;
            pai.Filhos.add(novo);
        }
    }

    private Node pesquisa(String e, Node r) {
        if (r == null) return null;
        if (r.Elem.equals(e))
            return r;
        for (Node f : r.Filhos) {
            Node aux = pesquisa(e, f);
            if (aux != null)
                return aux;
        }
        return null;
    }

    public List<String> ascendentes(String nome) {
        List<String> asc = new ArrayList<>();
        Node pessoa = pesquisa(nome, raiz);
        while (pessoa != null && pessoa.Pai != null) {
            pessoa = pessoa.Pai;
            asc.add(0, pessoa.Elem); // Adiciona no início para manter a ordem correta
        }
        return asc;
    }

    public int contarDescendentes(String nome) {
        Node pessoa = pesquisa(nome, raiz);
        return contarDescendentesAux(pessoa);
    }

    private int contarDescendentesAux(Node r) {
        if (r == null) return 0;
        int count = r.Filhos.size();
        for (Node f : r.Filhos) {
            count += contarDescendentesAux(f);
        }
        return count;
    }

    public List<String> listarFilhos(String nome) {
        List<String> filhos = new ArrayList<>();
        Node pessoa = pesquisa(nome, raiz);
        if (pessoa != null) {
            for (Node f : pessoa.Filhos) {
                filhos.add(f.Elem);
            }
        }
        return filhos;
    }

    public List<String> netos(String nome) {
        List<String> netos = new ArrayList<>();
        Node pessoa = pesquisa(nome, raiz);
        if (pessoa != null) {
            for (Node f : pessoa.Filhos) {
                for (Node nf : f.Filhos) {
                    netos.add(nf.Elem);
                }
            }
        }
        return netos;
    }

    public List<String> tios(String nome) {
        List<String> tios = new ArrayList<>();
        Node pessoa = pesquisa(nome, raiz);
        if (pessoa != null && pessoa.Pai != null && pessoa.Pai.Pai != null) {
            Node avo = pessoa.Pai.Pai;
            for (Node tio : avo.Filhos) {
                if (!tio.Elem.equals(pessoa.Pai.Elem)) {
                    tios.add(tio.Elem);
                }
            }
        }
        return tios;
    }

    public List<String> primos(String nome) {
        List<String> primos = new ArrayList<>();
        Node pessoa = pesquisa(nome, raiz);
        if (pessoa != null && pessoa.Pai != null && pessoa.Pai.Pai != null) {
            Node avo = pessoa.Pai.Pai;
            for (Node tio : avo.Filhos) {
                if (!tio.Elem.equals(pessoa.Pai.Elem)) {
                    for (Node primo : tio.Filhos) {
                        primos.add(primo.Elem);
                    }
                }
            }
        }
        return primos;
    }

    public void mostrar(String nome) {
        Node pessoa = pesquisa(nome, raiz);
        if (pessoa != null) {
            mostrarAux(pessoa, 0);
        } else {
            System.out.println(nome + " não pertence à família");
        }
    }

    private void mostrarAux(Node r, int nivel) {
        if (r != null) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("  | ");
            }
            System.out.println(r.Elem);
            for (Node f : r.Filhos) {
                mostrarAux(f, nivel + 1);
            }
        }
    }
}
