package br.com.ia.problemadamochila.service;

import br.com.ia.problemadamochila.ParametrosForm;
import br.com.ia.problemadamochila.bo.MochilaBO;
import java.math.BigDecimal;
import java.util.List;

public interface MochilaService {

    List<MochilaBO> geraPopulacaoInicial(ParametrosForm params);
    
    List<MochilaBO> calculaFitnessDaPopulacao(List<MochilaBO> populacao, BigDecimal pesoMax);
}
