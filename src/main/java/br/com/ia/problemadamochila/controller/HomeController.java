package br.com.ia.problemadamochila.controller;

import br.com.ia.problemadamochila.enums.DefaultsEnum;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    private String getIndex(HttpServletRequest request){
        request.setAttribute("populacao", DefaultsEnum.POPULACAO.getValor());
        request.setAttribute("iteracoes", DefaultsEnum.ITERACOES.getValor());
        request.setAttribute("intGer", DefaultsEnum.INTERVALO_GERACAO.getValor());
        request.setAttribute("txMutacao", DefaultsEnum.TAXA_MUTACAO.getValor());
        request.setAttribute("txAceitacao", DefaultsEnum.MOCHILA_TAXA_ACEIT.getValor());
        request.setAttribute("vlIdeal", DefaultsEnum.MOCHILA_VALOR_IDEAL.getValor());
        request.setAttribute("pesoMaxMochila", DefaultsEnum.MOCHILA_PESO_MAX.getValor());
        request.setAttribute("pesoMaxObj", DefaultsEnum.ITEM_PESO_MAX.getValor());
        request.setAttribute("pesoMinObj", DefaultsEnum.ITEM_PESO_MIN.getValor());
        request.setAttribute("vlMaxObj", DefaultsEnum.ITEM_VALOR_MAX.getValor());
        request.setAttribute("vlMinObj", DefaultsEnum.ITEM_VALOR_MIN.getValor());
        
        return "home";
    }
}
