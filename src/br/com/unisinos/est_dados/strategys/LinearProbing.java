package br.com.unisinos.est_dados.strategys;

/**
 * Author: Luis Henrique Hendges
 **/

public class LinearProbing extends Strategy {

    @Override
    public int getIndexByHash(int occupiedIndex, int j, int m) {
        return (occupiedIndex + j) % m;
    }
}
