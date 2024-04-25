package April._25;

// Interface ListTADPontos:
// Define os métodos que qualquer implementação
// de lista deve ter
// (isto é, eles PRECISAM ser implementados)
//
public interface ListTADPontos {
    void add(Ponto element);
    void add(int index, Ponto element);
    Ponto get(int index);
    Ponto set(int index, Ponto element);
    boolean remove(Ponto element);
    Ponto removeByIndex(int index);
    boolean isEmpty();
    int size();
    boolean contains(Ponto element);
    int indexOf(Ponto element);
    void clear();

    void addFirst(Ponto e);
    Ponto getFirst();
    Ponto getLast();
    Ponto removeFirst();
    Ponto removeLast();
}

