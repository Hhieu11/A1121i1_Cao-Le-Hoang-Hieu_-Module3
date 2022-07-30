package com.codegym.demo.controller;

import com.codegym.demo.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ShoppingCartController {
    @ModelAttribute("cart")
public Cart setupCart(){
    return new Cart();
}
//    @GetMapping("/shopping-cart")
//    public String showCart(@SessionAttribute("cart") Cart cart , Model model){
//
//        model.addAttribute("cart",cart);
//        return  "cart";
//
//
//    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}
