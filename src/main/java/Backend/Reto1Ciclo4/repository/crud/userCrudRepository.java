package Backend.Reto1Ciclo4.repository.crud;

import Backend.Reto1Ciclo4.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface userCrudRepository extends CrudRepository<User,Integer>{

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
