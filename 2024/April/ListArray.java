package April;
/**
 * Classe que implementa uma lista linear usando arranjo.
 * 
 * @author Isabel H. Manssour, Marcelo Cohen
 */

public class ListArray implements ListTAD {

    // Atributos
    private static final int TAM_PADRAO = 10;
    private int[] data;
    private int count;

    /**
     * Construtor da lista: inicializa capacidade com TAM_PADRAO
     */
    public ListArray() {
        this(TAM_PADRAO);
    }

    /**
     * Construtor da lista: inicializa capacidade com tamanho informado
     * 
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArray(int tam) {
        if (tam <= 0) {
            tam = TAM_PADRAO;
        }
        data = new int[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() {
        data = new int[TAM_PADRAO];
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
    public void add(int element) {
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
    public int get(int index) {
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
            int[] newData = new int[newCapacity];
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
    public int set(int index, int element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        int aux = data[index];
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
    public boolean contains(int element) {
        //return indexOf(element) != -1;
        int pos = indexOf(element);
        if (pos == -1)
            return false;   
        //else
        return true;
    }

    /**
     * Adiciona um elemento antes de uma pos. específica
     * 
     * @param index   posição a inserir o novo elemento
     * @param element elemento a ser adicionado
     * 
     */
    @Override
    public void add(int index, int element) {
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
    public boolean remove(int element) {
        /* 
        for (int pos = 0; pos < count; pos++) {
            if (data[pos] == element) {
                for (; pos < count - 1; pos++) {
                    data[pos] = data[pos + 1];
                }
                count--;
                return true;
            }
        }
        return false;
        */
        int pos = indexOf(element);
        if (pos == -1)
            return false;
        else {
            for (int i = pos; i<count-1;i++) {
                data[i] = data[i+1];
            }
            count--;
            return true;
        }
    }

    /**
     * Procura e retorna a posição de um elemento na lista
     * 
     * @param element elemento a ser encontrado
     * @return posição do elemento ou -1 se não encontrar
     */
    @Override
    public int indexOf(int e) {
        for (int pos = 0; pos < count; pos++)
            if (data[pos] == e)
                return pos;
        return -1;
    }

    /**
     * Inverte o conteúdo da lista
     */
    public void reverse() {
        int i = 0;
        int j = count - 1;
        // for(i=0; i<count/2; i++)
        while (i < j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            i++;
            j--;
        }

    }

    /**
     * 
     * 
     * 
     * Procura um elemento e retorna o total de ocorrências
     * 
     * @param element elemento a ser encontrado
     * @return total de ocorrências
     */
    public int countOccurrences(int e) {
        int total = 0;
        for (int pos = 0; pos < count; pos++)
            if (data[pos] == e)
                total++;
        return total;
    }

    
    /**
     * Insere um elemento na posição correta considerando
     * a ordem natural dos valores
     * 
     * @param element elemento a ser inserido
     */
    public void addIncreasingOrder(int element) {
        for (int pos = 0; pos < count; pos++) {
            if (element < data[pos]) {
                add(pos, element);
                return;
            }
        }
        add(element);
    }

    /**
     * Insere um elemento na posição correta considerando
     * a ordem natural invertida dos valores
     * 
     * @param element elemento a ser inserido
     */
    public void addDecreasingOrder(int element) {
        for (int pos = 0; pos < count; pos++) {
            if (element > data[pos]) {
                add(pos, element);
                return;
            }
        }
        add(element);
    }
}
