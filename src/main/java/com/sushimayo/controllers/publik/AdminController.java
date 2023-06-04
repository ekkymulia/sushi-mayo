package com.sushimayo.controllers.publik;

import com.sushimayo.database.Repository.MenuRepository;
import com.sushimayo.models.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping
    public String Admin(Model model){
        model.addAttribute("menu_data", menuRepository.getAllMenu());
        return "admin";
    }

    @GetMapping("addmenu")
    public String AdminAdd(){
        return "admin-add";
    }

    @PostMapping("addmenu")
    public String AdminAddPost(@ModelAttribute("menuModelParam") MenuModel menuModelParam){
//        menuModelParam.setIdMenu(Integer.parseInt(i);
        menuRepository.insertMenu(menuModelParam);
        return "redirect:/admin";
    }

    @GetMapping("edit/{id}")
    public String AdminEdit(Model model,@PathVariable("id") String id){
        model.addAttribute("menu", menuRepository.getMenuById(Integer.parseInt(id)));

        return "admin-edit";
    }

    @PostMapping("edit/{id}")
    public String AdminEditPost(Model model, @PathVariable("id") String id, @ModelAttribute("menuModelParam") MenuModel menuModelParam){
//        menuModelParam.setIdMenu(Integer.parseInt(i);
        menuRepository.updateMenu(menuModelParam);
        model.addAttribute("menu", menuModelParam);

        return "admin-edit";
    }
    @GetMapping("delete/{id}")
    public String AdminMenuDelete(Model model, @PathVariable String id){
        menuRepository.softDeleteMenu(Integer.parseInt(id));
        return "redirect:/admin";
    }


}
