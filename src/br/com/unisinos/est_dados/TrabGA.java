package br.com.unisinos.est_dados;

import br.com.unisinos.est_dados.domain.Item;
import br.com.unisinos.est_dados.domain.StrategyType;

public class TrabGA {

    public static void main(String[] args) {

        Item<String> stringItem = new Item<>(7, "lala");
        Item<String> stringItem1 = new Item<>(17, "lala");
        Item<String> stringItem2 = new Item<>(36, "lala");
        Item<String> stringItem3 = new Item<>(100, "lala");
        Item<String> stringItem4 = new Item<>(106, "lala");

        HashtableOpenAddressing hashtableOpenAddressing = new HashtableOpenAddressing(11, 0, StrategyType.LINEAR_PROBING.getIndex());

        System.out.println("inserindo");
        System.out.println("index " + hashtableOpenAddressing.insert(stringItem) + " key " + stringItem.getKey());
        System.out.println("index " + hashtableOpenAddressing.insert(stringItem1) + " key " + stringItem1.getKey());
        System.out.println("index " + hashtableOpenAddressing.insert(stringItem2) + " key " + stringItem2.getKey());
        System.out.println("index " + hashtableOpenAddressing.insert(stringItem3) + " key " + stringItem3.getKey());
        System.out.println("index " + hashtableOpenAddressing.insert(stringItem4) + " key " + stringItem4.getKey());



        System.out.println();
        System.out.println();
        System.out.println("buscando chave 12");
        System.out.println(hashtableOpenAddressing.search(12));

        System.out.println("chave 7 esperada : " + stringItem);
        System.out.println("chave 7 encontrada : " + hashtableOpenAddressing.search(7));

        System.out.println("chave 106 esperada" + stringItem4);
        System.out.println("chave 106 encontrada" + hashtableOpenAddressing.search(106));

        System.out.println();
        System.out.println();
        hashtableOpenAddressing.print();


        System.out.println();
        System.out.println();
        System.out.println("deletando");
        System.out.println("index " + hashtableOpenAddressing.delete(stringItem.getKey()) + " key " + stringItem.getKey());
        System.out.println("index " + hashtableOpenAddressing.delete(stringItem1.getKey()) + " key " + stringItem1.getKey());
        System.out.println("index " + hashtableOpenAddressing.delete(stringItem2.getKey()) + " key " + stringItem2.getKey());
        System.out.println("index " + hashtableOpenAddressing.delete(stringItem3.getKey()) + " key " + stringItem3.getKey());
        System.out.println("index " + hashtableOpenAddressing.delete(stringItem4.getKey()) + " key " + stringItem4.getKey());


        System.out.println();
        System.out.println();
        hashtableOpenAddressing.print();

    }
}
