package br.com.unisinos.est_dados.strategys;

/**
 * Author: Luis Henrique Hendges
 **/

public class QuadraticProbing extends Strategy {

    @Override
    public int getIndexByHash(int occupiedIndex, int j, int m) {
        return (int) (occupiedIndex + Math.pow(j, 2)) % m;
    }
}
