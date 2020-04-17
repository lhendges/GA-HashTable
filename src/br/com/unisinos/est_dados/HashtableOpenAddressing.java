package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;
import br.com.unisinos.est_dados.domain.StrategyType;
import br.com.unisinos.est_dados.strategys.DoubleHashing;
import br.com.unisinos.est_dados.strategys.LinearProbing;
import br.com.unisinos.est_dados.strategys.QuadraticProbing;
import br.com.unisinos.est_dados.strategys.Strategy;

import static java.util.Objects.nonNull;

public class HashtableOpenAddressing<V> implements Hashtable<V> {

    private final Item[] array;
    private final int valueForDoubleHashing;

    private Strategy strategy;

    public HashtableOpenAddressing(int m, int q, int probing) {
        this.array = new Item[m];
        this.valueForDoubleHashing = q;
        if (probing == StrategyType.LINEAR_PROBING.getIndex()) {
            this.strategy = new LinearProbing();
        } else if (probing == StrategyType.QUADRATIC_PROBING.getIndex()) {
            this.strategy = new QuadraticProbing();
        } else if (probing == StrategyType.DOUBLE_PROBING.getIndex()) {
            this.strategy = new DoubleHashing();
        }
    }

    /*
     * Busca o índice com base na função hash;
     * Se o item a ser excluído estiver na posição do índice, remove o item e o retorna;
     *
     * Se o item não estiver na posição do índice, entra num laço para calcular o novo indice com base nas funções de colisão;
     * */
    @Override
    public Item<V> delete(int key) {
        Item deletedItem = null;
        int primaryIndex = hashFunction(key, array.length);
        int recalculatedIndex = primaryIndex;
        int j = 0;
        do {
            if (nonNull(array[recalculatedIndex]) && array[recalculatedIndex].getKey() == key) {
                deletedItem = array[recalculatedIndex];
                array[recalculatedIndex] = null;
                j = array.length;
            } else {
                if (strategy instanceof DoubleHashing) {
                    recalculatedIndex = strategy.getIndexByHash(key, hashFunction(key, array.length), j, array.length, valueForDoubleHashing);
                } else {
                    recalculatedIndex = strategy.getIndexByHash(primaryIndex, j, array.length);
                }
            }
        } while (j++ < array.length);
        return deletedItem;
    }

    /*
     * Calcula o índice onde o item deve ser salvo;
     * Caso a posição esteja ocupada, entra no laço e calcula o novo indice com base nas funções de colisão
     * Quando a posição calculada estiver disponível, salva o item e retorna o seu indice
     * */
    @Override
    public int insert(Item<V> item) {
        int primaryIndex = hashFunction(item.getKey(), array.length);
        int recalculatedIndex = primaryIndex;
        for (int j = 0; j < array.length && nonNull(array[recalculatedIndex]); j++) {
            if (strategy instanceof DoubleHashing) {
                recalculatedIndex = strategy.getIndexByHash(item.getKey(), hashFunction(item.getKey(), array.length), j, array.length, valueForDoubleHashing);
            } else {
                recalculatedIndex = strategy.getIndexByHash(primaryIndex, j, array.length);
            }
        }
        array[recalculatedIndex] = item;
        return recalculatedIndex;
    }

    /* Calcula o indice através da função hash
     * Caso o item esteja na posição calcualada, retorna o item;
     * Caso não esteja, entra em um laço e recalcula o novo infice com base na função de colisão
     * Caso o item seja encontrado, retorna o item e finaliza a busca;
     * Caso o item não seja encontrado, retona null
     * */
    @Override
    public Item<V> search(int key) {
        int primaryIndex = hashFunction(key, array.length);
        int recalculatedIndex = primaryIndex;
        int j = 0;
        do {
            if (nonNull(array[recalculatedIndex]) && array[recalculatedIndex].getKey() == key) {
                return array[recalculatedIndex];
            } else {
                if (strategy instanceof DoubleHashing) {
                    recalculatedIndex = strategy.getIndexByHash(key, hashFunction(key, array.length), j, array.length, valueForDoubleHashing);
                } else {
                    recalculatedIndex = strategy.getIndexByHash(hashFunction(key, array.length), j, array.length);
                }
            }
        } while (j++ < array.length);
        return null;
    }

    /*
     * Perccorre o array printando os items;
     * Caso a posição esteja vazia, printa vazio
     * */
    @Override
    public void print() {
        for (int i = 0; i < array.length; i++) {
            Integer key = nonNull(array[i]) ? array[i].getKey() : null;
            String value = nonNull(array[i]) ? (String) array[i].getValue() : "vazio";
            System.out.println("index -> " + i + " chave: " + key + " valor: " + value);
        }
    }

    // Função hash
    private int hashFunction(int key, int m) {
        return key % m;
    }
}
