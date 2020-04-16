package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;

import static br.com.unisinos.est_dados.domain.StrategyType.*;
import static java.util.Objects.nonNull;

public class OpenAdressingMain {

    public static void main(String[] args) {

        Hashtable<Item> hash1 = new HashtableOpenAddressing<>(11, 7, LINEAR_PROBING.getIndex());
        Hashtable<Item> hash2 = new HashtableOpenAddressing<>(11, 7, QUADRATIC_PROBING.getIndex());
        Hashtable<Item> hash3 = new HashtableOpenAddressing<>(11, 7, DOUBLE_PROBING.getIndex());


        Item item1 = new Item(7, "7");
        Item item2 = new Item(17, "17");
        Item item3 = new Item(36, "36");
        Item item4 = new Item(100, "100");
        Item item5 = new Item(106, "106");
        Item item6 = new Item(205, "205");

        System.out.println("OPEN ADDRESS - LINEAR PROBING\n\n");

        System.out.println("Incluindo os itens...\n");
        hash1.insert(item1);
        hash1.insert(item2);
        hash1.insert(item3);
        hash1.insert(item4);
        hash1.insert(item5);
        hash1.insert(item6);


        System.out.println("Print: \n");
        hash1.print();

        System.out.println("Incluindo os itens...\n");

        System.out.println("\n\nBuscando o item com a chave 205...\n");
        Item foundItem = hash1.search(205);
        if (nonNull(foundItem)) {
            System.out.print(String.format("Item encontrado: Key = %d | Value = %s", foundItem.getKey(), foundItem.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }


        System.out.println("\n\nDeletando os itens...\n\n");

        System.out.println("\n\nDeletando o item com a chave 205...\n");
        Item deletedItem = hash1.delete(205);
        if (nonNull(deletedItem)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItem.getKey(), deletedItem.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }

        System.out.println("\n\nDeletando o item com a chave 7...\n");
        Item deletedItem2 = hash1.delete(7);
        if (nonNull(deletedItem2)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItem2.getKey(), deletedItem2.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 7!");
        }

        System.out.println("\n\nDeletando o item com a chave 22...\n");
        Item deletedItem3 = hash1.delete(22);
        if (nonNull(deletedItem3)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItem3.getKey(), deletedItem3.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 22!");
        }


        System.out.println("\n\nPrint: \n");
        hash1.print();


        System.out.println("OPEN ADDRESS - QUADRATIC PROBING\n\n");

        System.out.println("Incluindo os itens...\n");
        hash2.insert(item1);
        hash2.insert(item2);
        hash2.insert(item3);
        hash2.insert(item4);
        hash2.insert(item5);
        hash2.insert(item6);


        System.out.println("Print: \n");
        hash2.print();

        System.out.println("\n\nBuscando o item com a chave 205...\n");
        Item foundItemUsingQuadraticProbing = hash2.search(205);
        if (nonNull(foundItemUsingQuadraticProbing)) {
            System.out.print(String.format("Item encontrado: Key = %d | Value = %s", foundItemUsingQuadraticProbing.getKey(), foundItemUsingQuadraticProbing.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }


        System.out.println("\n\nDeletando os itens...\n\n");

        System.out.println("\n\nDeletando o item com a chave 205...\n");
        Item deletedItemUsingQuadraticProbing = hash2.delete(205);
        if (nonNull(deletedItemUsingQuadraticProbing)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItemUsingQuadraticProbing.getKey(), deletedItemUsingQuadraticProbing.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }

        System.out.println("\n\nDeletando o item com a chave 7...\n");
        Item deletedItemUsingQuadraticProbing2 = hash2.delete(7);
        if (nonNull(deletedItemUsingQuadraticProbing2)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItemUsingQuadraticProbing2.getKey(), deletedItemUsingQuadraticProbing2.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 7!");
        }

        System.out.println("\n\nDeletando o item com a chave 22...\n");
        Item deletedItemUsingQuadraticProbing3 = hash2.delete(22);
        if (nonNull(deletedItemUsingQuadraticProbing3)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItemUsingQuadraticProbing3.getKey(), deletedItemUsingQuadraticProbing3.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 22!");
        }


        System.out.println("\n\nPrint: \n");
        hash2.print();


        System.out.println("OPEN ADDRESS - DOUBLE HASHING\n\n");

        System.out.println("Incluindo os itens...\n");
        hash3.insert(item1);
        hash3.insert(item2);
        hash3.insert(item3);
        hash3.insert(item4);
        hash3.insert(item5);
        hash3.insert(item6);


        System.out.println("Print: \n");
        hash3.print();

        System.out.println("\n\nBuscando o item com a chave 205...\n");
        Item foundItemUsingDoubleHashing = hash3.search(205);
        if (nonNull(foundItemUsingDoubleHashing)) {
            System.out.print(String.format("Item encontrado: Key = %d | Value = %s", foundItemUsingDoubleHashing.getKey(), foundItemUsingDoubleHashing.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }

        System.out.println("\n\nDeletando os itens...\n\n");

        System.out.println("\n\nDeletando o item com a chave 205...\n");
        Item deletedItemUsingDoubleHashing = hash3.delete(205);
        if (nonNull(deletedItemUsingDoubleHashing)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItemUsingDoubleHashing.getKey(), deletedItemUsingDoubleHashing.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }

        System.out.println("\n\nDeletando o item com a chave 7...\n");
        Item deletedItemUsingDoubleHashing2 = hash3.delete(7);
        if (nonNull(deletedItemUsingDoubleHashing2)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItemUsingDoubleHashing2.getKey(), deletedItemUsingDoubleHashing2.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 7!");
        }

        System.out.println("\n\nDeletando o item com a chave 22...\n");
        Item deletedItemUsingDoubleHashing3 = hash3.delete(22);
        if (nonNull(deletedItemUsingDoubleHashing3)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItemUsingDoubleHashing3.getKey(), deletedItemUsingDoubleHashing3.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 22!");
        }


        System.out.println("\n\nPrint: \n");
        hash3.print();

    }
}
