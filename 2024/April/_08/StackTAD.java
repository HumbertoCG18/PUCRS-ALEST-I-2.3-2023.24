// Interface StackTAD:
// Define os métodos que qualquer implementação
// de pilha deve ter
// (isto é, eles PRECISAM ser implementados)
//
public interface StackTAD {
    public void push(int e);

    public int pop();

    public int top();

    public void clear();

    public boolean isEmpty();

    public int size();
}
