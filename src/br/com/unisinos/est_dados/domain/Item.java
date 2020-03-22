package br.com.unisinos.est_dados.domain;

/**
 * Classe Item que representa um item contendo uma chave (key) e um valor associado a esta chave (value).
 * A chave sempre deverá ser um inteiro.
 * Não altere essa classe, apenas a utilize em sua implementação.
 *
 * @author Felipe de Morais e Patricia Jaques
 */
public class Item<V> {

    /**
     * Variaveis privadas do objeto Item, que armazenam a chave (key) e um valor associado a esta chave (value)
     */
    private int key;
    private V value;

    /**
     * Metodo construtor da classe Item
     *
     * @param key   - chave do tipo int
     * @param value - valor do tipo V
     */
    public Item(int key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Metodo de acesso da chave
     *
     * @return chave do tipo int
     */
    public int getKey() {
        return key;
    }

    /**
     * Metodo de acesso do valor
     *
     * @return value do tipo V
     */
    public V getValue() {
        return value;
    }
}
