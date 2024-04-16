package April._04;
// Interface ListTAD:
// Define os métodos que qualquer implementação de lista deve ter (isto é, eles PRECISAM ser implementados).
public interface ListTAD {
    public void add(int e);

    public void add(int index, int element);

    public int get(int index);

    public int set(int index, int element);

    public boolean remove(int e);

    public boolean isEmpty();

    public int size();

    public boolean contains(int e);

    public int indexOf(int e);

    public void clear();
}