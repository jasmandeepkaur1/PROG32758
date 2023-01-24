package com.sheridancollege.lecture3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

   @GetMapping("/")
   public String goHome(){
       return"index";
     }

     @GetMapping("/register")
    public String registerUser(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam(defaultValue = "off") String rememberMe)
     {
         System.out.println(firstName +"" +lastName +"" + rememberMe);
         return"sucess";
     }

     @GetMapping("/register_page")
    public String goRegister(){
       return "register";
     }

}
