package br.com.ia.problemadamochila.service;

import br.com.ia.problemadamochila.ParametrosForm;
import br.com.ia.problemadamochila.bo.MochilaBO;

public interface AlgoritmoGeneticoService {
    
    MochilaBO execute(ParametrosForm form);
}
