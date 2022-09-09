package com.afordisman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf1(){
        //return "merhabalar";
        return "thymeleaf1"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf2Model(Model model){
        model.addAttribute( "key_model1","Ben modelden geldim-1");
        model.addAttribute( "key_model2","Ben modelden geldim-2");

        return "thymeleaf1"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf3Model(Model model){
        model.addAttribute( "key_model1","Ben modelden geldim-1");
        model.addAttribute( "key_model2","Ben modelden geldim-2");

        return "thymeleaf_file/thymeleaf3"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf4Model(Model model){
        model.addAttribute( "key_model1","Ben modelden geldim-4");
        return "thymeleaf4"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }
}
