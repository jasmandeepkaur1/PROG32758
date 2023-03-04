package ca.sheridancollege.Assignment2.beans;

import lombok.Data;

@Data
public class Student {

    private int id;
    private String first_name;
    private String last_name;
    private String  program_name;
    private int program_year;
    private Boolean program_coop;
    private Boolean program_internship;




    public Student(int id, String first_name, String last_name, String program_name, int program_year, boolean program_coop, boolean program_internship) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.program_name = program_name;
        this.program_year = program_year;
        this.program_coop = program_coop;
        this.program_internship = program_internship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public int getProgram_year() {
        return program_year;
    }

    public void setProgram_year(int program_year) {
        this.program_year = program_year;
    }

    public Boolean getProgram_coop() {
        return program_coop;
    }

    public void setProgram_coop(Boolean program_coop) {
        this.program_coop = program_coop;
    }

    public Boolean getProgram_internship() {
        return program_internship;
    }

    public void setProgram_internship(Boolean program_internship) {
        this.program_internship = program_internship;
    }

    public Student(){

 }
}
