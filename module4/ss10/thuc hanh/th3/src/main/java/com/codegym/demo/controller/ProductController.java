package com.codegym.demo.controller;

import com.codegym.demo.entity.Cart;
import com.codegym.demo.entity.Product;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Action;
import java.util.List;
import java.util.Optional;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService service;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public  String showShop(ModelMap model){
        List<Product>products =service.findAll();
        model.addAttribute("products",products);
        return"shop";
    }

//    @GetMapping("/add/{id}")
//    public  String addToCard(@PathVariable("id") Long id, @ModelAttribute Cart cart, @RequestParam("action") String action ){
//        Optional<Product> products= service.findById(id);
//
//        if (!products.isPresent()) {
//            return "/error.404";
//        }
//        if (action.equals("show")) {
//            cart.addProduct(products.get());
//            return "redirect:/shopping-cart";
//        }
//        cart.addProduct(products.get());
//        return "redirect:/shop";
//    }


//    @GetMapping("/shop")
//    public ModelAndView showShop() {
//        ModelAndView modelAndView = new ModelAndView("/shop");
//        modelAndView.addObject("products", service.findAll());
//        return modelAndView;
//    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = service.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("-")){
            cart.downItem(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("del")){
            cart.deleteProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/view/{id}")
    public  String view(@PathVariable("id") Long id,ModelMap model){
        Optional<Product> product=service.findById(id);
        model.addAttribute("product",product.get());
        return "view";
    }


}
