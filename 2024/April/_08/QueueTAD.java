// Interface QueueTAD:
// Define os métodos que qualquer implementação
// de fila deve ter
// (isto é, eles PRECISAM ser implementados)
//
public interface QueueTAD {
    public void enqueue(int e);
    public int dequeue();
    public int head();
    public void clear();
    public boolean isEmpty();
    public int size();
}
