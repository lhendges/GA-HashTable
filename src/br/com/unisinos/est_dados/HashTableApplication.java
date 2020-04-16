package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;
import br.com.unisinos.est_dados.domain.StrategyType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HashTableApplication {

    public static void main(String[] args) {

        // A utilização de hashtables proporciona uma velocidade muito maior na busca por elementos específicos quando comparamos a uma simples Lista.

        int size = 1_000_000;

        Item[] array = new Item[size];
        Hashtable<Item> hashtable = new HashtableOpenAddressing(size, 0, StrategyType.LINEAR_PROBING.getIndex());
        List<Item> list;

        for (int i = 0; i < size; i++) {
            int key = getRandomNumberInRange(size * 2, size * 5);
            array[i] = new Item(key, "Item " + i);
            hashtable.insert(new Item(key, "Item " + i));
        }
        list = Arrays.asList(array);


        int keyToFind = array[size - 1].getKey();

        Long initialTimeForListSearch = System.nanoTime();
        System.out.println("Chave encontrada: " + list.stream().filter(item -> item.getKey() == keyToFind).findFirst().get().getKey());
        Long finalTimeForListSearch = System.nanoTime();
        double listResult = (double) (finalTimeForListSearch - initialTimeForListSearch) / 1_000_000_000;

        System.out.println();
        System.out.println("Tempo necessário para concluir a busca na Lista (em segundos): " + listResult);

        System.out.println();

        Long initialTimeForHashtableSearch = System.nanoTime();
        System.out.println("Chave encontrada: " + hashtable.search(keyToFind).getKey());
        Long finalTimeTimeForHashtableSearch = System.nanoTime();
        double hashTableResult = (double) (finalTimeTimeForHashtableSearch - initialTimeForHashtableSearch) / 1_000_000_000;

        System.out.println();
        System.out.println("Tempo necessário para concluir a busca na HashTable (em segundos): " + hashTableResult);

        System.out.println("O método mais rápido foi: " + (hashTableResult > listResult ? "Lista" : "Hashtable"));

        System.out.println();
        System.out.println();
        System.out.println("Diferença entre os dois métodos (em segundos): " + Math.abs(listResult - hashTableResult));

    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
