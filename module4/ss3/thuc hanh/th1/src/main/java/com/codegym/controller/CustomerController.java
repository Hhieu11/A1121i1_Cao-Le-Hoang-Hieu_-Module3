package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

@Controller
public class CustomerController {
    private final CustomerServiceImpl customerService= new CustomerService();
    @GetMapping("/customer")
    public String index(Model model){
        List<Customer> customerList= customerService.findAll();
        model.addAttribute("customer",customerList);
        return "index";
    }

    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/save")
    public String save(Customer customer){
        customer.setId((int)( Math.random()*1000));
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "edit";

    }
    @PostMapping("/update")
    public String update(Customer customer){
        customerService.update(customer.getId(),customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/delete")
    public  String delete(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String remove(Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
            redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";

    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }





}
