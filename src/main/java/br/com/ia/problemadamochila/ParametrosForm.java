package br.com.ia.problemadamochila;

import br.com.ia.problemadamochila.enums.DefaultsEnum;
import java.math.BigDecimal;

public class ParametrosForm {

    private Integer populacao;
    private Integer iteracoes;
    private Integer intGer;
    private Integer txMutacao;
    private Integer txAceitacao;
    private Integer vlIdeal;
    private Integer itensMochila;
    private BigDecimal pesoMaxMochila;
    private BigDecimal pesoMaxObj;
    private BigDecimal pesoMinObj;
    private BigDecimal vlMaxObj;
    private BigDecimal vlMinObj;

    public ParametrosForm() {
        populacao = Integer.parseInt(DefaultsEnum.POPULACAO.getValor());
        iteracoes = Integer.parseInt(DefaultsEnum.ITERACOES.getValor());
        intGer = Integer.parseInt(DefaultsEnum.INTERVALO_GERACAO.getValor());
        txMutacao = Integer.parseInt(DefaultsEnum.TAXA_MUTACAO.getValor());
        txAceitacao = Integer.parseInt(DefaultsEnum.MOCHILA_TAXA_ACEIT.getValor());
        vlIdeal = Integer.parseInt(DefaultsEnum.MOCHILA_VALOR_IDEAL.getValor());
        itensMochila = Integer.parseInt(DefaultsEnum.ITENS_MOCHILA.getValor());
        pesoMaxMochila = new BigDecimal(DefaultsEnum.MOCHILA_PESO_MAX.getValor());
        pesoMaxObj = new BigDecimal(DefaultsEnum.ITEM_PESO_MAX.getValor());
        pesoMinObj = new BigDecimal(DefaultsEnum.ITEM_PESO_MIN.getValor());
        vlMaxObj = new BigDecimal(DefaultsEnum.ITEM_VALOR_MAX.getValor());
        vlMinObj = new BigDecimal(DefaultsEnum.ITEM_VALOR_MIN.getValor());
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public Integer getIteracoes() {
        return iteracoes;
    }

    public void setIteracoes(Integer iteracoes) {
        this.iteracoes = iteracoes;
    }

    public Integer getIntGer() {
        return intGer;
    }

    public void setIntGer(Integer intGer) {
        this.intGer = intGer;
    }

    public Integer getTxMutacao() {
        return txMutacao;
    }

    public void setTxMutacao(Integer txMutacao) {
        this.txMutacao = txMutacao;
    }

    public Integer getTxAceitacao() {
        return txAceitacao;
    }

    public void setTxAceitacao(Integer txAceitacao) {
        this.txAceitacao = txAceitacao;
    }

    public Integer getVlIdeal() {
        return vlIdeal;
    }

    public void setVlIdeal(Integer vlIdeal) {
        this.vlIdeal = vlIdeal;
    }

    public Integer getItensMochila() {
        return itensMochila;
    }

    public void setItensMochila(Integer itensMochila) {
        this.itensMochila = itensMochila;
    }

    public BigDecimal getPesoMaxMochila() {
        return pesoMaxMochila;
    }

    public void setPesoMaxMochila(BigDecimal pesoMaxMochila) {
        this.pesoMaxMochila = pesoMaxMochila;
    }

    public BigDecimal getPesoMaxObj() {
        return pesoMaxObj;
    }

    public void setPesoMaxObj(BigDecimal pesoMaxObj) {
        this.pesoMaxObj = pesoMaxObj;
    }

    public BigDecimal getPesoMinObj() {
        return pesoMinObj;
    }

    public void setPesoMinObj(BigDecimal pesoMinObj) {
        this.pesoMinObj = pesoMinObj;
    }

    public BigDecimal getVlMaxObj() {
        return vlMaxObj;
    }

    public void setVlMaxObj(BigDecimal vlMaxObj) {
        this.vlMaxObj = vlMaxObj;
    }

    public BigDecimal getVlMinObj() {
        return vlMinObj;
    }

    public void setVlMinObj(BigDecimal vlMinObj) {
        this.vlMinObj = vlMinObj;
    }
}
