package br.com.unisinos.est_dados.strategys;

import br.com.unisinos.est_dados.domain.Item;

public interface Strategy {

    int getIndexByHash(int occupiedIndex, Item[] array);
}
