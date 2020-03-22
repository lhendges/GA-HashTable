package br.com.unisinos.est_dados.strategys;

import br.com.unisinos.est_dados.domain.Item;

public class LinearProbing implements Strategy {

    @Override
    public int getIndexByHash(int occupiedIndex, Item[] array) {
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            index = (occupiedIndex + j) % array.length;
            if (array[index] == null) {
                return index;
            }
        }
        return index;
    }
}
