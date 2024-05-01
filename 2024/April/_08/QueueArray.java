package April._08;

/**
 * Classe que implementa uma fila linear usando array.
 * 
 * @author Marcelo Cohen
 */

public class QueueArray implements QueueTAD {

    // Atributos
    private static final int TAM_PADRAO = 10;
    private int[] data;
    private int count;

    /**
     * Construtor da fila: inicializa capacidade com TAM_PADRAO
     */
    public QueueArray() {
        this(TAM_PADRAO);
    }

    /**
     * Construtor da fila: inicializa capacidade com tamanho informado
     * 
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public QueueArray(int tam) {
        if (tam <= 0) {
            tam = TAM_PADRAO;
        }
        data = new int[tam];
        count = 0;
    }

    /**
     * Esvazia a fila.
     */
    public void clear() {
        data = new int[TAM_PADRAO];
        count = 0;
    }

    /**
     * Retorna true se a fila nao contem elementos.
     * 
     * @return true se a fila nao contem elementos
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Retorna o numero de elementos armazenados na fila.
     * 
     * @return o numero de elementos da fila
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da fila.
     * 
     * @param element elemento a ser adicionado ao final da fila
     */
    public void enqueue(int element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento no início da fila
     * 
     * @return o elemento no início
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int head() {
        if (count == 0) {
            throw new IndexOutOfBoundsException("Fila vazia!");
        }
        return data[0];
    }

    /**
     * Remove e retorna o elemento no início
     * 
     * @return elemento no início
     */
    @Override
    public int dequeue() {
        int aux = data[0];
        for (int pos = 0; pos < count - 1; pos++) {
            data[pos] = data[pos + 1];
        }
        count--;
        return aux;
    }

    /**
     * Retorna o conteúdo da fila como uma string
     * 
     * @return uma string com os elementos da fila
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

}
