package br.com.ia.problemadamochila.to;

import java.math.BigDecimal;

public class ResultadoTO implements Comparable<ResultadoTO>{
    private Integer iteracao;
    private BigDecimal valor;
    private BigDecimal peso;
    private BigDecimal fitness;

    public ResultadoTO(Integer iteracao, BigDecimal valor, BigDecimal peso, BigDecimal fitness) {
        this.iteracao = iteracao;
        this.valor = valor;
        this.peso = peso;
        this.fitness = fitness;
    }

    public Integer getIteracao() {
        return iteracao;
    }

    public void setIteracao(Integer iteracao) {
        this.iteracao = iteracao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getFitness() {
        return fitness;
    }

    public void setFitness(BigDecimal fitness) {
        this.fitness = fitness;
    }

    @Override
    public int compareTo(ResultadoTO resultado) {
        return resultado.getIteracao().compareTo(this.getIteracao());
    }
}
