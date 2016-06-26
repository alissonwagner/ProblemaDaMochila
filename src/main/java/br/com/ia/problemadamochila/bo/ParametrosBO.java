package br.com.ia.problemadamochila.bo;

import java.math.BigDecimal;

public class ParametrosBO {

    private Integer populacao;
    private Integer iteracoes;
    private Integer intGer;
    private BigDecimal txMutacao;
    private BigDecimal txAceitacao;
    private Integer vlIdeal;
    private Integer pesoMaxMochila;
    private Integer pesoMaxObj;
    private Integer pesoMinObj;
    private Integer vlMaxObj;
    private Integer vlMinObj;

    public ParametrosBO() {
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

    public BigDecimal getTxMutacao() {
        return txMutacao;
    }

    public void setTxMutacao(BigDecimal txMutacao) {
        this.txMutacao = txMutacao;
    }

    public BigDecimal getTxAceitacao() {
        return txAceitacao;
    }

    public void setTxAceitacao(BigDecimal txAceitacao) {
        this.txAceitacao = txAceitacao;
    }

    public Integer getVlIdeal() {
        return vlIdeal;
    }

    public void setVlIdeal(Integer vlIdeal) {
        this.vlIdeal = vlIdeal;
    }

    public Integer getPesoMaxMochila() {
        return pesoMaxMochila;
    }

    public void setPesoMaxMochila(Integer pesoMaxMochila) {
        this.pesoMaxMochila = pesoMaxMochila;
    }

    public Integer getPesoMaxObj() {
        return pesoMaxObj;
    }

    public void setPesoMaxObj(Integer pesoMaxObj) {
        this.pesoMaxObj = pesoMaxObj;
    }

    public Integer getPesoMinObj() {
        return pesoMinObj;
    }

    public void setPesoMinObj(Integer pesoMinObj) {
        this.pesoMinObj = pesoMinObj;
    }

    public Integer getVlMaxObj() {
        return vlMaxObj;
    }

    public void setVlMaxObj(Integer vlMaxObj) {
        this.vlMaxObj = vlMaxObj;
    }

    public Integer getVlMinObj() {
        return vlMinObj;
    }

    public void setVlMinObj(Integer vlMinObj) {
        this.vlMinObj = vlMinObj;
    }

}
