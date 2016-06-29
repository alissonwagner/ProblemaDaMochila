package br.com.ia.problemadamochila.bo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class ItemBO {

    private BigDecimal valor;
    private BigDecimal peso;

    public ItemBO(BigDecimal pesoMin, BigDecimal pesoMax, BigDecimal valorMin, BigDecimal valorMax) {
        Random rand = new Random();
        this.valor = new BigDecimal(rand.doubles(valorMin.doubleValue(), valorMax.doubleValue()).iterator().next())
                .setScale(2, RoundingMode.HALF_UP);
        this.peso = new BigDecimal(rand.doubles(pesoMin.doubleValue(), pesoMax.doubleValue()).iterator().next())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public ItemBO(BigDecimal valor, BigDecimal peso) {
        this.valor = valor;
        this.peso = peso;
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
}
