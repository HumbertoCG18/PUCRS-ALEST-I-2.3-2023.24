package April._25;

// Interface ListTADPontos:
// Define os métodos que qualquer implementação
// de lista deve ter
// (isto é, eles PRECISAM ser implementados)
//
public interface ListTADPontos {
    public void add(Ponto element);
    public void add(int index, Ponto element);
    public Ponto get(int index);
    public Ponto set(int index, Ponto element);
    public boolean remove(Ponto element);
    public Ponto removeByIndex(int index);
    public boolean isEmpty();
    public int size();
    public boolean contains(Ponto element);
    public int indexOf(Ponto element);
    public void clear();
    //public void addFirst(int e);
    //public int getFirst();
    //public int getLast();
    //public int removeFirst();
    //public int removeLast();

}
