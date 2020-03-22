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

        System.out.println(hashtableOpenAddressing.insert(stringItem) + " " + stringItem.getKey());
        System.out.println(hashtableOpenAddressing.insert(stringItem1) + " " + stringItem1.getKey());
        System.out.println(hashtableOpenAddressing.insert(stringItem2) + " " + stringItem2.getKey());
        System.out.println(hashtableOpenAddressing.insert(stringItem3) + " " + stringItem3.getKey());
        System.out.println(hashtableOpenAddressing.insert(stringItem4) + " " + stringItem4.getKey());

    }
}
