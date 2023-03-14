package ca.sheridancollege.crudexample2.databaseAccess;

import ca.sheridancollege.crudexample2.beans.Avenger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class DatabaseAccess {

    private NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    public int addAvenger(Avenger avenger){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "Insert into avengers (name, age) values (:name , :age)";
        namedParameters.addValue("name",avenger.getName());
        namedParameters.addValue("age",avenger.getAge());

        int returnValue = jdbc.update(query,namedParameters);

        return returnValue;
    }
    public List<Avenger> getAvengers() {

        String query = "Select * from avengers";
        BeanPropertyRowMapper<Avenger> avengerBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Avenger.class);
        List<Avenger> avengers = jdbc.query(query,avengerBeanPropertyRowMapper);
        return avengers;
    }
    public  int deleteAvenger(Long id){
        log.info("Avenger to be deleted with id {}",id);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "DELETE FROM avengers WHERE id = :id";
        namedParameters.addValue("id", id);

        int returnValue = jdbc.update(query,namedParameters);

        return returnValue;
    }

    public Avenger getAvenger(Long id){
        log.info("Calling update  on avenger with id {}", id);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM avengers WHERE id =:id";
        namedParameters.addValue("id", id);
        BeanPropertyRowMapper<Avenger> avengerBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Avenger.class);
        Avenger avenger = null;
        try{
            avenger = jdbc.queryForObject(query, namedParameters, avengerBeanPropertyRowMapper);
        }catch(EmptyResultDataAccessException a){
            log.error("Avenger not found with id {}", id);
        }

        return avenger;
    }

    public int updateAvenger(Avenger avenger){
        log.info("Inside updateAvenger method with the avenger {}", avenger);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "UPDATE avengers set name = :name , age = :age where id = :id";
        namedParameters.addValue("id", avenger.getId());
        namedParameters.addValue("name", avenger.getName());
        namedParameters.addValue("age", avenger.getAge());
        return jdbc.update(query, namedParameters);

    }
}
