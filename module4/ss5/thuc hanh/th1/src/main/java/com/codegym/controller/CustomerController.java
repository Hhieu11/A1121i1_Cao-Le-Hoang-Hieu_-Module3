package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customer",customerList);
        return "list";
    }
    @GetMapping("/view/{id}")
    public String viewStudentByParam(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        customerService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String viewCreate() {
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer) {
        customerService.create(customer);
        return "redirect:/list";
    }

}
