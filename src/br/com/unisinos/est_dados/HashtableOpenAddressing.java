package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;
import br.com.unisinos.est_dados.domain.StrategyType;
import br.com.unisinos.est_dados.strategys.DoubleHashing;
import br.com.unisinos.est_dados.strategys.LinearProbing;
import br.com.unisinos.est_dados.strategys.QuadraticProbing;
import br.com.unisinos.est_dados.strategys.Strategy;

import static java.util.Objects.isNull;

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
        return null;
    }

    @Override
    public int insert(Item<V> item) {
        int index = hashFunction(item.getKey(), array.length);
        if (isNull(array[index])) {
            array[index] = item;
        } else {
            index = strategy.getIndexByHash(index, array);
        }
        return index;
    }

    @Override
    public Item<V> search(int key) {
        return null;
    }

    @Override
    public void print() {

    }

    private int hashFunction(int key, int m) {
        return key % m;
    }
}
