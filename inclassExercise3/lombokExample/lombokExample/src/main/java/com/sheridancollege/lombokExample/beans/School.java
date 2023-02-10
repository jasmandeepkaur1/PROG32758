package com.sheridancollege.lombokExample.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@NoArgsConstructor
@Component
public class School {

    private  String name;
     private String address;
    private int numStudents;


//    public School(String name, String address, int numStudents) {
//        this.name = name;
//        this.address = address;
//        this.numStudents = numStudents;
//    }
}
