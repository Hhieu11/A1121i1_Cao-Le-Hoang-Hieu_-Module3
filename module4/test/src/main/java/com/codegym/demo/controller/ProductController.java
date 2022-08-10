package com.codegym.demo.controller;

import com.codegym.demo.entity.Catelogy;
import com.codegym.demo.entity.Product;
import com.codegym.demo.service.CatelogyService;
import com.codegym.demo.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CatelogyService catelogyService;

    @GetMapping("/product/list")
    public String list(@PageableDefault(value = 3 )Pageable pageable, Model model){
        Page<Product> productPage=productService.findAll(pageable);
        model.addAttribute("product",productPage);
        return "product/listProduct";
    }

    @GetMapping("/product/create")
    public String create(Model model){
        List<Catelogy> catelogies=catelogyService.findAll();
        model.addAttribute("catelogy",catelogies);
        model.addAttribute("product",new Product());
        return "product/create";
    }

    @PostMapping("/product/save")
    public String save(@Valid @ModelAttribute Product product, BindingResult bindingResult , Model model){
//        CustomerVali customerVali=new CustomerVali();
//        customerVali.validate(customer,bindingResult);
        if(bindingResult.hasErrors()){
            List<Catelogy> catelogies=catelogyService.findAll();
            model.addAttribute("catelogy",catelogies);

//            return "redirect:/product/create";
            return "/product/create";

        }
        else{
            productService.save(product);
            return "redirect:/product/list";
        }

    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        Optional<Product> product=productService.findById(id);
        List<Catelogy> catelogies=catelogyService.findAll();
        model.addAttribute("product",product);
        model.addAttribute("catelogy",catelogies);
        return "product/edit";
    }

    @PostMapping("product/update")
    public String update(@ModelAttribute Product product,BindingResult bindingResult,Model model){
            productService.save(product);
            return "redirect:/product/list";

    }

    @GetMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.remove(id);
        return "redirect:/product/list";
    }

    @GetMapping("product/search")
    public String search(@PageableDefault(value = 3) Pageable pageable, @RequestParam("name") String name,
                         @RequestParam("catelogyName") String catelogyName,Model model ){

        Page<Product> products=productService.search(name, catelogyName, pageable);
        model.addAttribute("product",products);

        return "product/listProduct";

    }
    @GetMapping("product/search2")
    public String search2(@PageableDefault(value = 3) Pageable pageable, @RequestParam("name") String name,
                       Model model ){

        Page<Product> products=productService.findAllByProductNameContaining(name, pageable);
        model.addAttribute("product",products);

        return "product/listProduct";

    }

    }


