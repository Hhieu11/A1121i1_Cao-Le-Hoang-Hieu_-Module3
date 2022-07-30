package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.ICustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService service;

    @GetMapping("/create")
    public  String create(Model model){
//        Customer customer= new Customer();
//        model.addAttribute("customer",customer);
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("customer")Customer  customer, RedirectAttributes redirectAttributes){
        service.save(customer);
        redirectAttributes.addFlashAttribute("mess","Them moi thanh cong");
        return "redirect:/list";
    }
    @GetMapping("/list")
    public String list(Model model){
        Iterable<Customer> customers=service.findAll();
        model.addAttribute("customer",customers);
        return "list";
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = service.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }
    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        service.save(customer);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("mess", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = service.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        service.remove(customer.getId());
        return "redirect:list";
    }

}
