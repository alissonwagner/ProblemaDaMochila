package br.com.ia.problemadamochila.controller;

import br.com.ia.problemadamochila.ParametrosForm;
import br.com.ia.problemadamochila.bo.MochilaBO;
import br.com.ia.problemadamochila.service.MochilaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private MochilaService mochilaService;
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    private String getIndex(Model model) {
        model.addAttribute("form", new ParametrosForm());
        return "home";
    }
    
    @RequestMapping(path = "/busca", method = RequestMethod.POST)
    public String postParametros(@ModelAttribute("form") ParametrosForm form, Model model){
        List<MochilaBO> geraPopulacaoInicial = mochilaService.geraPopulacaoInicial(form);
        return "home";
    }
}
