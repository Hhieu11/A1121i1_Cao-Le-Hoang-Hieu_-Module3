package com.codegym.controller;

import com.codegym.model.Mailbox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailboxController {

@GetMapping(value = "/form")
    public String form(Model model){
    model.addAttribute("mailbox",new Mailbox());
    return "/create";

}
@PostMapping(value = "/info")
    public String submit(@ModelAttribute("mailbox") Mailbox mailbox,Model model){
    model.addAttribute("languages",mailbox.getLanguages());
    model.addAttribute("size",mailbox.getSize());
    model.addAttribute("spams",mailbox.isSpams());
    model.addAttribute("signature",mailbox.getSignature());
    return "info";

}
}
