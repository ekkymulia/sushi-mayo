package com.sushimayo.controllers.publik;

import com.sushimayo.database.Repository.JenisMenuRepository;
import com.sushimayo.database.Repository.MenuRepository;
import com.sushimayo.models.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private JenisMenuRepository jenisMenuRepository;

    @GetMapping
    public String Shop (Model model){
        model.addAttribute("jenis_menu_data", jenisMenuRepository.getAllJenisMenu());
        model.addAttribute("menu_data", menuRepository.getAllMenu());
        return "shop.html";
    }

    @GetMapping(value = "/getSearch")
    public String ShopSearch (@RequestParam String namamenu, Model model){
        model.addAttribute("jenis_menu_data", jenisMenuRepository.getAllJenisMenu());
        model.addAttribute("menu_data", menuRepository.getMenuByName(namamenu));
        return "shop.html";
    }

    @CrossOrigin(origins="*")
    @GetMapping(value = "/getProductDetails", produces = "application/json")
    @ResponseBody
    public MenuModel getMenuDetails(@RequestParam("id") String menuId) {
        // Logic to fetch menu details based on the menuId
        MenuModel menu = menuRepository.getMenuById(Integer.parseInt(menuId));
        return menu;
    }
}
