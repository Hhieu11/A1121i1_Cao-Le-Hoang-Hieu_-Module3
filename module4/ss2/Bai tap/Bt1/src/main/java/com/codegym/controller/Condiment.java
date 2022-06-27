package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
public class Condiment {

  @GetMapping(value = "/h")
    public String home(){
      return "sandwich";
  }
  @GetMapping("save")
  public String save(@RequestParam("sandwich") String[] sandwich, Model model){

    String output="";

    for(String s:sandwich){
       output= output + s+",";

      System.out.println(s);

    }
    model.addAttribute("sand",output );
    return "sandwich";
  }
}
