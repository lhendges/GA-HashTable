package br.com.unisinos.est_dados.strategys;

/**
 * Author: Luis Henrique Hendges
 **/

public class DoubleHashing extends Strategy {

    @Override
    public int getIndexByHash(int key, int occupiedIndex, int j, int m, int q) {
        return (occupiedIndex + j * secondaryHashFunction(key, q)) % m;
    }

    private int secondaryHashFunction(int key, int q) {
        return q - (key % q);
    }
}
