package com.codegym.controller;

import com.codegym.entity.Music;
import com.codegym.entity.MusicForm;
import com.codegym.service.MusicService;
import com.codegym.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;
    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/music")
    public String list(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("music", musicList);
        return "list";
    }

    //    @Transactional
    @GetMapping("/create")
    public String create(Model model) {
        MusicForm musicForm = new MusicForm();
        model.addAttribute("music", musicForm);
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("music") MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getPath();
        String path = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(musicForm.getPath().getBytes(), new File(fileUpload + path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getName(), musicForm.getArtist(), musicForm.getGenre(), path);
        musicService.create(music);
        return "redirect:/music";

    }

    @GetMapping("{id}/view")
    public String viewStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "edit";


    }

    @PostMapping("/update")
    public String update(@ModelAttribute("music") Music music) {
        musicService.update(music);
        return "redirect:/music";
    }


}
