package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.*;
import com.codegym.casestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private PositionService positionService;


    @GetMapping("/employee/listEmployee")
    public String listEmployee(@PageableDefault(value = 5) Pageable pageable, Model model){
        Page<Employee>employees=employeeService.findAll(pageable);
        model.addAttribute("employee",employees);
        return "employee/list";
    }

    @GetMapping("employee/create")
    public String createEmployee(Model model){
        Iterable<Division> division=divisionService.findAll();
        Iterable<Education>education=educationService.findAll();
        Iterable<Position> position=positionService.findAll();
        model.addAttribute("employee",new Employee());
        model.addAttribute("division",division);
        model.addAttribute("education",education);
        model.addAttribute("position",position);
        return "employee/create";

    }

    @PostMapping("employee/save")
    public  String saveEmployee(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/listEmployee";
    }

    @GetMapping("employee/edit/{id}")
    public String editEmployee(@PathVariable Integer id,Model model){
        Optional<Employee> employee=employeeService.findById(id);
        Iterable<Division> division=divisionService.findAll();
        Iterable<Education>education=educationService.findAll();
        Iterable<Position> position=positionService.findAll();
        model.addAttribute("division",division);
        model.addAttribute("education",education);
        model.addAttribute("position",position);
        model.addAttribute("employee",employee);
        return "employee/edit";


    }

    @PostMapping("employee/update")
    public String updateEmployee(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/listEmployee";
    }


    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        employeeService.remove(id);
        return "redirect:/employee/listEmployee";

    }

    @GetMapping("employee/search")
    public String search(@RequestParam("name") String name,Model model){
        Iterable<Employee>employees=employeeService.search(name);
        model.addAttribute("employee",employees);
        return "employee/list";

    }
}
