package br.com.unisinos.est_dados;

/**
 * Author: Luis Henrique Hendges
 **/

import br.com.unisinos.est_dados.domain.Item;

import static java.util.Objects.nonNull;

public class SeparateChainingMain {
    public static void main(String[] args) {

        Hashtable<Item> hashtable = new HashTableSeparateChaining(11);

        Item item1 = new Item(7, "7");
        Item item2 = new Item(17, "17");
        Item item3 = new Item(36, "36");
        Item item4 = new Item(100, "100");
        Item item5 = new Item(106, "106");
        Item item6 = new Item(205, "205");

        System.out.println("SEPARATE CHAINING \n\n");

        System.out.println("Incluindo os itens...\n");
        hashtable.insert(item1);
        hashtable.insert(item2);
        hashtable.insert(item3);
        hashtable.insert(item4);
        hashtable.insert(item5);
        hashtable.insert(item6);


        System.out.println("Print: \n");
        hashtable.print();

        System.out.println("\n\nBuscando o item com a chave 205...\n");
        Item foundItem = hashtable.search(205);
        if (nonNull(foundItem)) {
            System.out.print(String.format("Item encontrado: Key = %d | Value = %s", foundItem.getKey(), foundItem.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }


        System.out.println("\n\nDeletando os itens...\n\n");

        System.out.println("\n\nDeletando o item com a chave 205...\n");
        Item deletedItem = hashtable.delete(205);
        if (nonNull(deletedItem)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItem.getKey(), deletedItem.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 205!");
        }

        System.out.println("\n\nDeletando o item com a chave 7...\n");
        Item deletedItem2 = hashtable.delete(7);
        if (nonNull(deletedItem2)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItem2.getKey(), deletedItem2.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 7!");
        }

        System.out.println("\n\nDeletando o item com a chave 22...\n");
        Item deletedItem3 = hashtable.delete(22);
        if (nonNull(deletedItem3)) {
            System.out.print(String.format("Item deletado: Key = %d | Value = %s", deletedItem3.getKey(), deletedItem3.getValue()));
        } else {
            System.out.println("Não foi encontrado um item com a chave 22!");
        }


        System.out.println("\n\nPrint: \n");
        hashtable.print();


    }
}
