package br.com.ia.problemadamochila.controller;

import br.com.ia.problemadamochila.bo.ParametrosBO;
import br.com.ia.problemadamochila.enums.DefaultsEnum;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    private String getIndex(Model model) {

        model.addAllAttributes(getParametros(null));

        return "home";
    }

    private Map<String, Object> getParametros(ParametrosBO parametros) {
        Map<String, Object> params = new HashMap<>();

        if (parametros != null) {
            
        } else {
            params.putAll(getParametrosDefault());
        }

        return params;
    }

    private Map<String, Object> getParametrosDefault() {
        Map<String, Object> params = new HashMap<>();

        params.put("populacao", DefaultsEnum.POPULACAO.getValor());
        params.put("iteracoes", DefaultsEnum.ITERACOES.getValor());
        params.put("intGer", DefaultsEnum.INTERVALO_GERACAO.getValor());
        params.put("txMutacao", DefaultsEnum.TAXA_MUTACAO.getValor());
        params.put("txAceitacao", DefaultsEnum.MOCHILA_TAXA_ACEIT.getValor());
        params.put("vlIdeal", DefaultsEnum.MOCHILA_VALOR_IDEAL.getValor());
        params.put("pesoMaxMochila", DefaultsEnum.MOCHILA_PESO_MAX.getValor());
        params.put("pesoMaxObj", DefaultsEnum.ITEM_PESO_MAX.getValor());
        params.put("pesoMinObj", DefaultsEnum.ITEM_PESO_MIN.getValor());
        params.put("vlMaxObj", DefaultsEnum.ITEM_VALOR_MAX.getValor());
        params.put("vlMinObj", DefaultsEnum.ITEM_VALOR_MIN.getValor());

        return params;
    }
}
