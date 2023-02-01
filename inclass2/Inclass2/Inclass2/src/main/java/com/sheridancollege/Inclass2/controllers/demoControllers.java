package com.sheridancollege.Inclass2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class demoControllers {
//    @GetMapping("/")
//    public String goHome(){
//        return"index";
//    }

    @PostMapping("/process_submit")
    public String submitUser(@RequestParam String ID,
                               @RequestParam String Message,
                               Model model ) {
        model.addAttribute("ID",ID);
        model.addAttribute("Message",Message);
        return "success";
    }

    @GetMapping("/submit_page")
    public String goSubmit(){

        return "submitForm";
    }

}
