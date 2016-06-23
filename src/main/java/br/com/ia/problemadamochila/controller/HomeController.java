package br.com.ia.problemadamochila.controller;

import br.com.ia.problemadamochila.bo.ItemBO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    private String getIndex(HttpServletRequest request){
        ItemBO item = new ItemBO();
        request.setAttribute("item", item);
        return "index";
    }
}
