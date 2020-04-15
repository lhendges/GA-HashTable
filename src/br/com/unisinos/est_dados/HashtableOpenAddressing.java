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
                    recalculatedIndex = strategy.getIndexByHash(primaryIndex, j, key);
                }
            }
        } while (j++ < array.length);
        return deletedItem;
    }

    @Override
    public int insert(Item<V> item) {
        int primaryIndex = hashFunction(item.getKey(), array.length);
        int recalculatedIndex = primaryIndex;
        for (int j = 0; j < array.length && nonNull(array[recalculatedIndex]); j++) {
            if (strategy instanceof DoubleHashing) {
                recalculatedIndex = strategy.getIndexByHash(item.getKey(), hashFunction(item.getKey(), array.length), j, array.length, valueForDoubleHashing);
            } else {
                recalculatedIndex = strategy.getIndexByHash(primaryIndex, j, item.getKey());
            }
        }
        array[recalculatedIndex] = item;
        return recalculatedIndex;
    }

    @Override
    public Item<V> search(int key) {
        int primaryIndex = hashFunction(key, array.length);
        int recalculatedIndex = primaryIndex;
        int j = 0;
        do {
            if (nonNull(array[recalculatedIndex]) && array[recalculatedIndex].getKey() == key) {
                return array[recalculatedIndex];
            } else {
                recalculatedIndex = strategy.getIndexByHash(hashFunction(key, array.length), j++, array.length);
            }
        } while (j < array.length - 1);
        return null;
    }

    @Override
    public void print() {
        for (int i = 0; i < array.length; i++) {
            Integer key = nonNull(array[i]) ? array[i].getKey() : null;
            String value = nonNull(array[i]) ? (String) array[i].getValue() : "vazio";
            System.out.println("index -> " + i + " chave: " + key + " valor: " + value);
        }
    }

    private int hashFunction(int key, int m) {
        return key % m;
    }
}
