package br.com.ia.problemadamochila.controller;

import br.com.ia.problemadamochila.ParametrosForm;
import br.com.ia.problemadamochila.enums.DefaultsEnum;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    private String getIndex(Model model) {
        model.addAttribute("form", new ParametrosForm());
        return "home";
    }
    
    @RequestMapping(path = "/busca", method = RequestMethod.POST)
    public String postParametros(@ModelAttribute("form") ParametrosForm form, Model model){
        
        return "home";
    }
}
