package net.oviedo.backendjava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import net.oviedo.backendjava.entities.UserEntiti;

@Repository
public interface UserRepository extends CrudRepository<UserEntiti, Long> {
    UserEntiti findByEmail(String email);
    


}
