package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;
import br.com.unisinos.est_dados.domain.StrategyType;
import br.com.unisinos.est_dados.strategys.DoubleHashing;
import br.com.unisinos.est_dados.strategys.LinearProbing;
import br.com.unisinos.est_dados.strategys.QuadraticProbing;
import br.com.unisinos.est_dados.strategys.Strategy;

import java.util.LinkedList;

public class HashTableSeparateChaining implements Hashtable {

    private final LinkedList<Item>[] array;
    private final int valueForHashing;

    private Strategy strategy;

    public HashTableSeparateChaining(int m, int q, int probing) {
        this.array = new LinkedList[m];
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
    public Item delete(int key) {
        return null;
    }

    @Override
    public int insert(Item item) {
        return 0;
    }

    @Override
    public Item search(int key) {
        return null;
    }

    @Override
    public void print() {

    }
}
