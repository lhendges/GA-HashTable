package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;
import br.com.unisinos.est_dados.domain.StrategyType;
import br.com.unisinos.est_dados.strategys.DoubleHashing;
import br.com.unisinos.est_dados.strategys.LinearProbing;
import br.com.unisinos.est_dados.strategys.QuadraticProbing;
import br.com.unisinos.est_dados.strategys.Strategy;

import java.util.*;

import static java.util.Objects.nonNull;

public class HashTableSeparateChaining implements Hashtable {

    private final LinkedList<Item>[] array;
    private Strategy strategy;

    public HashTableSeparateChaining(int m) {
        this.array = new LinkedList[m];
    }

    @Override
    public Item delete(int key) {
        int index = hashFunction(key, array.length);
        Item deletedItem = search(key);
        if (nonNull(deletedItem)) {
            array[index].removeIf(item -> item.getKey() == key);
        }
        return deletedItem;
    }

    @Override
    public int insert(Item item) {
        int index = hashFunction(item.getKey(), array.length);
        array[index].add(item);
        return index;
    }

    @Override
    public Item search(int key) {
        int index = hashFunction(key, array.length);
        return array[index].stream()
                .filter(item -> item.getKey() == key)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= array.length - 1; i++) {
            stringBuilder.append("(posição = ");
            stringBuilder.append(i);
            stringBuilder.append(")");
            if (nonNull(array[i])) {
                array[i].stream().peek(item -> {
                    stringBuilder.append(item.getValue());
                    stringBuilder.append(",");
                }).close();
            }
        }
        stringBuilder.toString();
    }

    private int hashFunction(int key, int m) {
        return key % m;
    }
}
