package April._25;

/**
 * Classe que implementa uma lista linear usando arranjo.
 * 
 * @author Isabel H. Manssour, Marcelo Cohen
 */

public class ListArrayPontos implements ListTADPontos {

    // Atributos
    private static final int TAM_PADRAO = 10;
    private Ponto[] data;
    private int count;

    /**
     * Construtor da lista: inicializa capacidade com TAM_PADRAO
     */
    public ListArrayPontos() {
        this(TAM_PADRAO);
    }

    /**
     * Construtor da lista: inicializa capacidade com tamanho informado
     * 
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayPontos(int tam) {
        if (tam <= 0) {
            tam = TAM_PADRAO;
        }
        data = new Ponto[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() {
        data = new Ponto[TAM_PADRAO];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * 
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * 
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * 
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Ponto element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * 
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Ponto get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    /**
     * Retorna o conteúdo da lista como uma string
     * 
     * @return uma string com os elementos da lista
     */
    @Override
    public String toString() {
        String aux = "[ ";
        for (int pos = 0; pos < count; pos++)
            aux = aux + data[pos] + " ";
        aux = aux + "]";
        return aux;
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Ponto[] newData = new Ponto[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * 
     * @param index   a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Ponto set(int index, Ponto element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Ponto aux = data[index];
        data[index] = element;
        return aux;
    }

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a
     * lista contem este elemento.
     * 
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Ponto element) {
        return indexOf(element) != -1;
        // int pos = indexOf(element);
        // if (pos == -1)
        // return false;
        // return true;
    }

    /**
     * Adiciona um elemento antes de uma pos. específica
     * 
     * @param index   posição a inserir o novo elemento
     * @param element elemento a ser adicionado
     * 
     */
    @Override
    public void add(int index, Ponto element) {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException();
        }
        if (count == data.length)
            setCapacity(data.length * 2);
        for (int i = count - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = element;
        count++;
    }

    /**
     * Procura e remove um elemento da lista
     * 
     * @param element elemento a ser removido
     * @return true se encontrar e remover o elemento
     */
    @Override
    public boolean remove(Ponto element) {
        for (int pos = 0; pos < count; pos++) {
            if (data[pos].equals(element)) {
                for (; pos < count - 1; pos++) {
                    data[pos] = data[pos + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Procura e remove um elemento da lista, pela posição
     * 
     * @param element elemento a ser removido
     * @return o item removido
     */
    @Override
    public Ponto removeByIndex(int index) {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException();
        }
        Ponto val = data[index];
        for (int pos=index; pos < count - 1; pos++) {
            data[pos] = data[pos + 1];
        }
        count--;
        return val;
    }

    /**
     * Procura e retorna a posição de um elemento na lista
     * 
     * @param element elemento a ser encontrado
     * @return posição do elemento ou -1 se não encontrar
     */
    @Override
    public int indexOf(Ponto e) {
        for (int pos = 0; pos < count; pos++)
            if (data[pos].equals(e))
                return pos;
        return -1;
    }
}
