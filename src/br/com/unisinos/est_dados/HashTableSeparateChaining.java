package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;

import java.util.LinkedList;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class HashTableSeparateChaining implements Hashtable {

    private final LinkedList<Item>[] array;

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
        if (isNull(array[index])) array[index] = new LinkedList<>();
        array[index].add(item);
        return index;
    }

    @Override
    public Item search(int key) {
        int index = hashFunction(key, array.length);
        return isNull(array[index]) ? null : array[index].stream().filter(item -> item.getKey() == key).findFirst().orElse(null);
    }

    @Override
    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append("(posição = ");
            stringBuilder.append(i);
            stringBuilder.append("): ");
            if (nonNull(array[i])) {
                stringBuilder.append(" valores = ");
                array[i].forEach(item -> {
                    stringBuilder.append("key: ");
                    stringBuilder.append(item.getKey());
                    stringBuilder.append(" - valor: ");
                    stringBuilder.append(item.getValue());
                    stringBuilder.append(", ");
                });
                System.out.println(stringBuilder.toString());
            } else {
                stringBuilder.append("vazio");
                System.out.println(stringBuilder.toString());
            }
            stringBuilder.setLength(0);
        }
    }

    private int hashFunction(int key, int m) {
        return key % m;
    }
}
