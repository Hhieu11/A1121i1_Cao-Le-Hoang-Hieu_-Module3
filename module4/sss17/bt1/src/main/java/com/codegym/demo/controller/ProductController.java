package com.codegym.demo.controller;

import com.codegym.demo.entity.Product;
import com.codegym.demo.service.ProductService;
import com.codegym.demo.validate.ProductValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public String list(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("product",productList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
    Product product=new Product();
    model.addAttribute("product",product);
    return "create";
    }

    @PostMapping("/save")
    public String save(@Valid  @ModelAttribute("product") Product product, BindingResult bindingResult){
        ProductValid productValid= new ProductValid();
        productValid.validate(product,bindingResult);
        if(bindingResult.hasErrors()){
        return "create";
        }
        else {
            productService.save(product);
            return "redirect:/list";

        }

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product,BindingResult bindingResult){
        ProductValid productValid=new ProductValid();
        productValid.validate(product,bindingResult);
        if(bindingResult.hasErrors()){
            return "edit";
        }
        else {
            productService.save(product);
            return "redirect:/list";
        }


    }
    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") Long id){
        productService.remove(id);
        return "redirect:/list";

    }


}
