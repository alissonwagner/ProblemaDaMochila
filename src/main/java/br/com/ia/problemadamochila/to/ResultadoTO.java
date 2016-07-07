package br.com.ia.problemadamochila.to;

import br.com.ia.problemadamochila.bo.ItemBO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResultadoTO implements Comparable<ResultadoTO>{
    private Integer iteracao;
    private BigDecimal valor;
    private BigDecimal peso;
    private BigDecimal fitness;
    private List<ItemBO> itens = new ArrayList<>();

    public ResultadoTO(Integer iteracao, BigDecimal valor, BigDecimal peso, BigDecimal fitness, List<ItemBO> itens) {
        this.iteracao = iteracao;
        this.valor = valor;
        this.peso = peso;
        this.fitness = fitness;
        this.itens = itens;
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

    public List<ItemBO> getItens() {
        return itens;
    }

    public void setItens(List<ItemBO> itens) {
        this.itens = itens;
    }

    @Override
    public int compareTo(ResultadoTO resultado) {
        return resultado.getIteracao().compareTo(this.getIteracao());
    }
}
