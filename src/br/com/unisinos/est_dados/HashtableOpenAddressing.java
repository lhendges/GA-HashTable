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
    private final int valueForHashing;

    private Strategy strategy;

    public HashtableOpenAddressing(int m, int q, int probing) {
        this.array = new Item[m];
        this.valueForHashing = q;
        if (probing == StrategyType.LINEAR_PROBING.getIndex()) {
            this.strategy = new LinearProbing();
        } else if (probing == StrategyType.QUADRATIC_PROBING.getIndex()) {
            this.strategy = new QuadraticProbing();
        } else if (probing == StrategyType.DOUBLE_PROBING.getIndex()) {
            this.strategy = new DoubleHashing();
        }
    }

    @Override
    public Item<V> delete(int key) {
        Item deletedItem = null;
        int index = hashFunction(key, array.length);
        int j = 0;
        do {
            if (nonNull(array[index]) && array[index].getKey() == key) {
                deletedItem = array[index];
                array[index] = null;
            } else {
                index = strategy.getIndexByHash(hashFunction(key, array.length), j++, array.length);
            }
        } while (j < array.length);
        return deletedItem;
    }

    @Override
    public int insert(Item<V> item) {
        int index = hashFunction(item.getKey(), array.length);
        for (int j = 0; j < array.length && nonNull(array[index]); j++) {
            index = strategy.getIndexByHash(hashFunction(item.getKey(), array.length), j, array.length);
        }
        array[index] = item;
        return index;
    }

    //Melhorar código
    @Override
    public Item<V> search(int key) {
        int index = hashFunction(key, array.length);
        int j = 0;
        do {
            if (nonNull(array[index]) && array[index].getKey() == key) {
                return array[index];
            } else {
                index = strategy.getIndexByHash(hashFunction(key, array.length), j++, array.length);
            }
        } while (j < array.length - 1);
        return null;
    }

    @Override
    public void print() {
        for (int i = 0; i < array.length; i++) {
            Integer key = nonNull(array[i]) ? array[i].getKey() : null;
            String value = nonNull(array[i]) ? (String) array[i].getValue() : null;
            System.out.println("index -> " + i + " chave: " + key + " valor: " + value);
        }
    }

    private int hashFunction(int key, int m) {
        return key % m;
    }
}
