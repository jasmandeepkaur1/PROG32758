package ca.sheridancollege.crudexample2.controllers;

import ca.sheridancollege.crudexample2.beans.Avenger;
import ca.sheridancollege.crudexample2.databaseAccess.AvengerRepository;
import ca.sheridancollege.crudexample2.databaseAccess.DatabaseAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class HomeController {
    Iterable<Avenger> avengerList =new ArrayList<>();
    private AvengerRepository avengerRepository;
    public HomeController(AvengerRepository avengerRepository){
        this.avengerRepository =  avengerRepository;
    }
    @GetMapping("/")
    public String goHome(Model model){
        avengerList =  avengerRepository.findAll();
        model.addAttribute("avengerList",avengerList);
        return "index";
    }
    @GetMapping("/addPage")
    public String goToAdd(Model model){
        model.addAttribute("avenger", new Avenger());
        return "add_avenger";
    }

    @PostMapping("/addAvenger")
    public String addAvenger(@ModelAttribute Avenger avenger){
        try {
            avengerRepository.save(avenger);
            return "success";
        }catch (Exception ex)
        {
            return "failure";
        }
    }

    @GetMapping("/deleteAvenger/{id}")
    public String deleteAvenger(@PathVariable Long id){

        log.info("Trying to delete an avenger from the database with id {}", id);
        avengerRepository.deleteById(id);
        log.info("Database is deleted successfully");
        return "delete_success";
    }

    @GetMapping("/editAvenger/{id}")
    public String editAvenger(@PathVariable Long id, Model model){
        log.info("Trying to edit avenger from the database with id{}", id);

        Optional<Avenger> avenger = avengerRepository.findById(id);
        //avenger not present
        if (!avenger.isPresent()){
            log.error("avenger not found ");
            return "redirect:/";
        }
        model.addAttribute("avenger", avenger.get());
        return "edit_avenger";
    }

    @PostMapping("/updateAvenger")
    public String updateAvenger(@ModelAttribute Avenger avenger){
        log.info("Trying to update avenger {}", avenger);
        avengerRepository.save(avenger);
        return "update_success";

    }
}
