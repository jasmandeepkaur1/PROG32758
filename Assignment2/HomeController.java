package ca.sheridancollege.Assignment2.Controllers;

import ca.sheridancollege.Assignment2.Database.DatabaseAccess;
import ca.sheridancollege.Assignment2.beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.List;

@Controller
public class HomeController {

   private DatabaseAccess database;

   public HomeController (DatabaseAccess database){
       this.database = database;
   }
   @GetMapping ("/")
    public  String goHome() {
       return "index";
       }


     @GetMapping("/listofstudents")
       public String list (Model model) {
         List<Student> student = database.getStudent();
         model.addAttribute("studentList", student);
         return "list-students";
     }

       @GetMapping ("/student-details/{id}")
               public String studentDetail(Model model , @PathVariable int id) {
         Student student = database.getStudentbyid(id);
      //    Student student =database.getStudent();
           model.addAttribute("studentList" , student);
           return "student-details";
         }

         @GetMapping("/lists")
         public String information () {
         return "list-students";
         }
   }



