package br.com.ia.problemadamochila.bo;

import java.math.BigDecimal;
import java.util.List;

public class MochilaBO implements Comparable<MochilaBO>{
    private List<ItemBO> itens;
    private BigDecimal valor;
    private BigDecimal peso;
    private BigDecimal fitness;

    public MochilaBO() {
    }

    public List<ItemBO> getItens() {
        return itens;
    }

    public void setItens(List<ItemBO> itens) {
        this.itens = itens;
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
    public int compareTo(MochilaBO mochila){
        int retorno = mochila.getFitness().compareTo(this.getFitness());
        
        if(retorno == 0){
            retorno = mochila.getValor().compareTo(this.getValor());
        }
        
        if(retorno == 0){
            retorno = 1;
        }
        
        return retorno;
    }
}
