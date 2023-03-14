package ca.sheridancollege.crudexample2.databaseAccess;

import ca.sheridancollege.crudexample2.beans.Avenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AvengerRepository extends CrudRepository<Avenger, Long> {
    // this is created or insert operation
    Avenger save(Avenger entity);

    //select *from avenger where id is .....
    Optional<Avenger> findById(Long id);

    //select *from avenger
    Iterable<Avenger> findAll();

    //delete from avenger where  is ........
    void deleteById(Long id);
}
