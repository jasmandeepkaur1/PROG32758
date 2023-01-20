# PROG32758

# in the first class we showed hello world on the web using local host using 

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
