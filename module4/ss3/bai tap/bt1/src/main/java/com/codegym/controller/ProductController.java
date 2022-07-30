package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
@Autowired
private ProductServiceImpl productService;
    @GetMapping("/product")
    public String index(Model model){
        List<Product> productList= productService.findAll();
        model.addAttribute("product",productList);
        return "index";
    }

    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId((int)( Math.random()*1000));
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product";

    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id,Model  model){
        model.addAttribute("product",productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public  String delete(Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success",     "Removed customer successfully!");
        return  "redirect:/product";
    }
    @GetMapping("{id}/view")
    public  String view(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }
    @GetMapping("/search")
    public String search(@RequestParam("search") String search,Model model ){
        List<Product> productList= productService.findByName(search);
        model.addAttribute("product",productList);
        return "index";
    }
}
