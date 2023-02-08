package com.sheridancollege.lombokExample.Controllers;

import com.sheridancollege.lombokExample.beans.School;
import com.sheridancollege.lombokExample.database.DatabaseAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private DatabaseAccess da;
    public HomeController(DatabaseAccess da) {
        this.da = da;
    }

    @GetMapping("/")
    public String goHome() {
        return "index";
    }

    @GetMapping("/addSchoolForm")
    public String addSchoolForm(Model model) {
        model.addAttribute("school", new School());
        return "addSchool";
    }

    @PostMapping ("/add")
    public String addSchoolForm(Model model , @ModelAttribute School school)
    {
        da.getSchoolList().add(school);
        model.addAttribute("schoolList" ,da.getSchoolList());
        return "listing";
    }

//    @GetMapping("/addSchoolForm")
//
//    public String addSchoolForm(Model model) {
//        model.addAttribute("school", new School("sheridan","davis",45000));
//        return "addSchool";
//    }

    @GetMapping("/removeAll")
     public String removeandGo() {
        da.getSchoolList().clear();
        return "redirect:/";
    }
    @GetMapping("/viewSchools")
    public String viewPage(Model model){
        model.addAttribute("schoolList" , da.getSchoolList());
        return "listing";
    }

}

