package com.sushimayo.controllers.publik;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/single-product")
public class SingleproductController {

    @GetMapping
    public String SingleProduct (){
        return "single-product.html";
    }

}
