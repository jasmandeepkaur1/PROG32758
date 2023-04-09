package ca.sheridancollege.Assignment4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String goHome(){
        return "index";
    }

    @GetMapping("/user")
    public String goTOSecured(){
        return"secured/user/index";
    }

    @GetMapping("/manager")
    public String goToManager(){
        return "secured/manager/manager_area";
    }

    @GetMapping("/secured")
    public String goToSecured(){
        return "secured/gateway";
    }
    @GetMapping("/login")
    public String goToCustomLogin(){
        return "login";
    }

    @GetMapping("/permission-denied")
    public String goToDenied(){
        return "error/permission-denied";
    }
}
