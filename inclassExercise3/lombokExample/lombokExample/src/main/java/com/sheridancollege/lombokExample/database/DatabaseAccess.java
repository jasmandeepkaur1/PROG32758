package com.sheridancollege.lombokExample.database;

import com.sheridancollege.lombokExample.beans.School;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Data
@Repository
public class DatabaseAccess {

    private ArrayList<School> schoolList = new ArrayList<>();


}
