package br.com.unisinos.est_dados.strategys;

public class LinearProbing extends Strategy {

    @Override
    public int getIndexByHash(int occupiedIndex, int j, int m) {
        return (occupiedIndex + j) % m;
    }
}
