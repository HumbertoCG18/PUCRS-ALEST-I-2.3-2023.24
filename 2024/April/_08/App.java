package April._08;


public class App {
    public static void main(String[] args) {
        // Cria uma fila
        // QueueTAD fila = new QueueArray();
        QueueTAD fila = new QueueLinked();
        // Insere alguns números
        fila.enqueue(2);
        fila.enqueue(4);
        fila.enqueue(6);
        fila.enqueue(8);
        fila.enqueue(10);
        // Remove e vai mostrando na tela
        // até ficar vazia
        while (!fila.isEmpty()) {
            System.out.println(fila);
            System.out.println(fila.dequeue());
        }
    }
}
