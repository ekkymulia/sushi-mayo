package com.sushimayo.controllers.publik;

import com.sushimayo.database.Repository.DetailNotaRepository;
import com.sushimayo.database.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping
    public String Index(Model model){

        model.addAttribute("detail_nota", menuRepository.getAllMenuNames());
        return "index.html";

    }
}
