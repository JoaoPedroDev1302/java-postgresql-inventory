package model;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String nome;
    private BigDecimal preco;
    private int quantidade;

    public Produto(int id, String nome, BigDecimal preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return id + " - " + nome +
                " | R$ " + preco +
                " | Quantidade: " + quantidade;
    }
}

