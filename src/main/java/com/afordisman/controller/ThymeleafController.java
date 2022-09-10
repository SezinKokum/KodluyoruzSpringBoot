package com.afordisman.controller;

import com.afordisman.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    //optional
    @GetMapping({"/","index"})
    public String index(){
        return "index";
    }
    //Ctrl+alt+L formatter
    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf1() {
        //return "merhabalar";
        return "thymeleaf1"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //Model yapımız vardı
    //http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-1");
        model.addAttribute("key_model2", "Ben modelden geldim-2");

        return "thymeleaf1"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //Model birden fazla göndermek
    //http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-1");
        model.addAttribute("key_model2", "Ben modelden geldim-2");

        return "thymeleaf_file/thymeleaf3"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim-4");
        return "thymeleaf4"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    ////////////////////////////////////////////
    //Model Object Göndermek
    //http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf5ModelObject(Model model) {
        model.addAttribute("key_model1", "text");

        ProductDto productDto =
                ProductDto
                        .builder()
                        .productID(0L)
                        .productName("Ürün Adı")
                        .productPrice(2500)
                        .build();
        model.addAttribute("key_model2", productDto);
        return "thymeleaf5"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //Model Object List Göndermek
    //http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf6ModelObjectList(Model model) {
        model.addAttribute("key_model1", "text");
        List<ProductDto> listem = new ArrayList<>();
        listem.add(ProductDto.builder().productID(1L).productName("Ürün Adı1").productPrice(1500).build());
        listem.add(ProductDto.builder().productID(2L).productName("Ürün Adı2").productPrice(2500).build());
        listem.add(ProductDto.builder().productID(3L).productName("Ürün Adı3").productPrice(3500).build());
        listem.add(ProductDto.builder().productID(4L).productName("Ürün Adı4").productPrice(4500).build());

        model.addAttribute("product_liste", listem);
        return "thymeleaf6"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }

    //@PathVariable
    //http://localhost:8080/thymeleaf7/
    //http://localhost:8080/thymeleaf7/4
    @GetMapping({"/thymeleaf7","/thymeleaf7/{id}"})
    //@ResponseBody //herhangi bir sayfaya yönlendirmeyip direkt gösteriyor
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name = "id", required=false) Long id) {
       if(id!=null){
           model.addAttribute("key_model1", "id"+ id );
       }else{
           model.addAttribute("key_model1", "id bulunamadı");
       }
        return "thymeleaf7"; //direkt bu isimdeki thymeleaf.html sayfasına yönlendirdi
    }
}
