package com.codegym.demo.controller;

import com.codegym.demo.entity.Music;
import com.codegym.demo.service.MusicService;
import com.codegym.demo.validate.MusicValid;
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
public class MusicController {
    @Autowired
    private MusicService musicService;
    @GetMapping("/list")
    public String list(Model model){
        List<Music> music=musicService.findAll();
        model.addAttribute("music",music);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model  model){
        model.addAttribute("music",new Music());
        return "create";
    }

    @PostMapping("/save")
    public  String save(@Valid @ModelAttribute("music") Music music, BindingResult bindingResult, Model model){
        MusicValid musicValid= new MusicValid();
        musicValid.validate(music,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        else {
            musicService.save(music);
            return "redirect:/list";
        }
    }
    @GetMapping("/{id}/edit")
    public  String edit(@PathVariable("id") Long id,Model  model){
    model.addAttribute("music",musicService.findById(id));
    return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("music") Music music,BindingResult  bindingResult,Model model){
        MusicValid musicValid=new MusicValid();
        musicValid.validate(music ,bindingResult);
        if(bindingResult.hasErrors()){
        return "edit";
        }
        else {
        musicService.save(music);
            return "redirect:/list";

        }
    }
}
