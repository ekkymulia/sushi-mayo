package com.sushimayo.controllers.publik;

import com.sushimayo.database.Repository.DetailNotaRepository;
import com.sushimayo.database.Repository.JenisMenuRepository;
import com.sushimayo.database.Repository.MenuRepository;
import com.sushimayo.database.Repository.NotaRepository;
import com.sushimayo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private JenisMenuRepository jenisMenuRepository;
    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private DetailNotaRepository detailNotaRepository;

    @GetMapping
    public String Shop (Model model){
        model.addAttribute("jenis_menu_data", jenisMenuRepository.getAllJenisMenu());
        model.addAttribute("menu_data", menuRepository.getAllMenu());
        return "shop.html";
    }

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/postNota", produces = "application/json")
    @ResponseBody
    public ResponseModel postNota(@RequestBody OrderModel orderModel) {

        // Extract the order details from the OrderModel
        String name = orderModel.getNamaPelanggan();
        String address = orderModel.getAlamat();
        String phone = orderModel.getTelpPelanggan();

        // Create a new NotaModel object and set its properties
        NotaModel notaModel = new NotaModel();
        notaModel.setNamaPelanggan(name);
        notaModel.setMetodePembayaran("QRIS");
        notaModel.setAlamat(address);
        notaModel.setTelpPelanggan(phone);
        notaModel.setTanggalPemesanan(new Date());

        // Save the NotaModel to the database using the NotaRepository or any other appropriate method
        int idNota = notaRepository.saveNota(notaModel);

        // Iterate through the list of OrderMenuModel objects in the OrderModel
        List<OrderMenuModel> orderMenuModels = orderModel.getOrderMenuModel();
        for (OrderMenuModel orderMenuModel : orderMenuModels) {
            // Extract the menu details from the OrderMenuModel
            int menuId = orderMenuModel.getIdMenu();
            int quantity = orderMenuModel.getQuantity();

            // Create a new DetailNotaModel object and set its properties
            DetailNotaModel detailNotaModel = new DetailNotaModel();
            detailNotaModel.setIdNota(idNota);
            detailNotaModel.setIdMenu(menuId);
            detailNotaModel.setQty(quantity);

            // Save the DetailNotaModel to the database using the NotaRepository or any other appropriate method
            detailNotaRepository.saveDetailNota(detailNotaModel);
        }

        ResponseModel responseModel = new ResponseModel();
        responseModel.setMessage("Success");
        responseModel.setStatus(true);

        // Return the created NotaModel
        return responseModel;
    }
}
