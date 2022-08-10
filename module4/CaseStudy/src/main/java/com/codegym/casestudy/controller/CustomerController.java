package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.CustomerType;
import com.codegym.casestudy.service.CustomerService;
import com.codegym.casestudy.service.CustomerTypeService;
import com.codegym.casestudy.validate.CustomerVali;
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
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @GetMapping("/listCustomer")
    public String listCustomer(@PageableDefault(value =5)Pageable pageable, Model model){
        Page<Customer> customers=customerService.findAll(pageable);
        model.addAttribute("customer",customers);
        return"customer/listCus";
    }

    @GetMapping("customer/create")
    public String createCustomer( Model model){
        Iterable<CustomerType>customerTypes=customerTypeService.findAll();
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerType",customerTypes);
        return "customer/createCustomer";
    }
    @PostMapping("/customer/save")
    public String save(@Valid  @ModelAttribute Customer customer, BindingResult bindingResult,Model model){
        CustomerVali customerVali=new CustomerVali();
        customerVali.validate(customer,bindingResult);
        if(bindingResult.hasErrors()){
//            Iterable<CustomerType>customerTypes=customerTypeService.findAll();
//            model.addAttribute("customer",new Customer());
//            model.addAttribute("customerType",customerTypes);
            return "customer/createCustomer";

        }
    customerService.save(customer);
    return "redirect:/listCustomer";
    }

    @GetMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable String id,Model model){
        Iterable<CustomerType>customerTypes=customerTypeService.findAll();
        Optional<Customer> customers=customerService.findById(id);
        model.addAttribute("customer",customers);
        model.addAttribute("customerType",customerTypes);
        return "customer/editCustomer";

    }

    @PostMapping("/customer/update")
    public String updateCustomer(@ModelAttribute Customer customer,Model model){
        customerService.save(customer);
        return  "redirect:/listCustomer";

    }


    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable("id") String id,Model model){
        customerService.remove(id);
        return  "redirect:/listCustomer";

    }

    @GetMapping("/customer/search")
    public String search(@PageableDefault(value =5)Pageable pageable,@RequestParam("name") String name,
                         @RequestParam("address") String address,
                         @RequestParam("email") String email,
                         Model model){
        Page<Customer>customers=customerService.search(name, address, email, pageable);

//        Page<Customer>customers=customerService.findAllByCustomerNameContaining(name, pageable);
        model.addAttribute("customer",customers);
        return"customer/listCus";

    }


}
