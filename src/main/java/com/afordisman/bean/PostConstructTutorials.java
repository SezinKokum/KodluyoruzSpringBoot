package com.afordisman.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

//import org.apache.logging.log4j.Logger;

@Controller
public class PostConstructTutorials {

   // @Autowired
   // Logger LOG;

    //parametresiz constructor
   /* public PostConstructTutorials() {
        LOG.info("Log info çağrıldı.");
    }*/

    //bean henüz başlamadığından noll pointer this.LOG is null hatası alıyoruz(autowired da daha başlamadığından)
    //burada bağımlılığı enjekte edemiyoruz. yukardaki kapalı kısımla null hatası oluyor.
    //post constuctor ile bean nesnesi oluşturulduğunda bean nesnesi hemen oluşur
   /* @PostConstruct
    public void init(){
        LOG.info("Log info çağrıldı");
    }*/

   /* public static void main(String[] args) {
        PostConstructTutorials beanController = new PostConstructTutorials();
        System.out.println(beanController);
    }*/

}
