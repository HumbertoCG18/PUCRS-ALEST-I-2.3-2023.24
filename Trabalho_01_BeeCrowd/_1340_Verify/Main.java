package _1340;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean p, f, fp;
            Queue<Integer> fila = new LinkedList<>();
            Stack<Integer> pilha = new Stack<>();
            int n, operacao, numero;
            PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>(Collections.reverseOrder());

            while (scanner.hasNextInt()) {
                n = scanner.nextInt();

                while (!pilha.isEmpty())
                    pilha.pop();
                while (!fila.isEmpty())
                    fila.poll();
                filaPrioridade.clear();

                p = true;
                f = true;
                fp = true;

                for (int i = 0; i < n; ++i) {
                    operacao = scanner.nextInt();
                    numero = scanner.nextInt();

                    if (operacao == 1) {
                        if (p)
                            pilha.push(numero);
                        if (f)
                            fila.add(numero);
                        if (fp)
                            filaPrioridade.add(numero);
                    } else {
                        if (p) {
                            if (pilha.isEmpty() || pilha.peek() != numero)
                                p = false;
                            else
                                pilha.pop();
                        }

                        if (f) {
                            if (fila.isEmpty() || fila.peek() != numero)
                                f = false;
                            else
                                fila.poll();
                        }

                        if (fp) {
                            if (filaPrioridade.isEmpty() || filaPrioridade.peek() != numero)
                                fp = false;
                            else
                                filaPrioridade.poll();
                        }
                    }
                }

                if (p && !f && !fp)
                    System.out.println("stack");
                else if (!p && f && !fp)
                    System.out.println("queue");
                else if (!p && !f && fp)
                    System.out.println("priority queue");
                else if (!p && !f && !fp)
                    System.out.println("impossible");
                else
                    System.out.println("not sure");
            }
        }
    }
}
