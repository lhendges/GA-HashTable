package br.com.unisinos.est_dados.domain;

public enum StrategyType {

    LINEAR_PROBING(0),
    QUADRATIC_PROBING(1),
    DOUBLE_PROBING(2);

    private int index;

    StrategyType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
