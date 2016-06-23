package br.com.ia.problemadamochila.bo;

import br.com.ia.problemadamochila.enums.DefaultsEnum;
import java.math.BigDecimal;
import java.util.Random;

public class ItemBO {

    private BigDecimal valor;
    private BigDecimal peso;

    public ItemBO() {
        Random rand = new Random();
        this.valor = new BigDecimal(rand.doubles(DefaultsEnum.ITEM_VALOR_MIN.getValor(), DefaultsEnum.ITEM_VALOR_MAX.getValor()).iterator().next());
        this.peso = new BigDecimal(rand.doubles(DefaultsEnum.ITEM_PESO_MIN.getValor(), DefaultsEnum.ITEM_PESO_MAX.getValor()).iterator().next());
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
