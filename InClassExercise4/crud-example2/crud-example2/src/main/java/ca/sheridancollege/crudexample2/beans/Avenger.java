package ca.sheridancollege.crudexample2.beans;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="avengers")
public class Avenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    public Avenger() {

    }
}
