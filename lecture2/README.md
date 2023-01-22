# PROG32758
# lecture2 in class work in we made diiferent package and learnt about spring frameworks and getmapping and how to show the text on the web screen using postman

#HelloWorldController.java
package com.sheridancollege.helloWorld.controllers2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
   public String getHelloWorld (){
       return "Hello World  ";
    }

}

#HelloWorldFailController
package com.sheridancollege.helloWorld.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldFailController {

   @GetMapping ("/link")
     public String getHelloWorld() {
        return "Hello";
   }

 //  @GetMapping ("/testing")
 //  public String getWorld() {
    //    return "World";
  // }
}

#Controller.java
package com.sheridancollege.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
   @GetMapping("/test")
   public String getWorld() {
       return "World";
    }
}

