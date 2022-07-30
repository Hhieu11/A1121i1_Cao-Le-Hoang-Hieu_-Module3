package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerImpl;
import com.codegym.repository.CustomerRepo;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    private CustomerServiceImpl customerService=new CustomerService();
    @GetMapping(value = "/home")
    public  String home(Model model){
        model.addAttribute("customer",new Customer());
        return "home";
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@ModelAttribute Customer customer){
        customerService.save(customer);
        List<Customer>customerList=customerService.display();;
        ModelAndView modelAndView= new ModelAndView("save","list",customerList);
        return modelAndView;

    }


}
