package com.codegym.casestudy.controller.restController;

import com.codegym.casestudy.entity.Employee;
import com.codegym.casestudy.repository.EmployeeRepository;
import com.codegym.casestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {
@Autowired
    private EmployeeService employeeService;
@GetMapping("/employee/searchName")
@ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> search(@RequestParam("nameEmp")String name){
return employeeService.search(name);

}
}
