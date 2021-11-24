package Backend.Reto1Ciclo4.repository;

import Backend.Reto1Ciclo4.model.User;
import Backend.Reto1Ciclo4.repository.crud.userCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public class userRepository {

    @Autowired
    private userCrudRepository userCrudRepository;

    public List<User> obtenerUser(){
        return (List<User>)userCrudRepository.findAll();
    }

    public Optional<User> obtenerUserId(int id){
        return userCrudRepository.findById(id);
    }

    public User crearUser(User user) {
        return userCrudRepository.save(user);
    }

    public boolean validaEmail (String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> validaEmailPassword (String email, String password){
        return userCrudRepository.findByEmailAndPassword(email,password);
    }
}
