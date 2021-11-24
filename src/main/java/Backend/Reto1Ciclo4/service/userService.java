package Backend.Reto1Ciclo4.service;

import Backend.Reto1Ciclo4.model.User;
import Backend.Reto1Ciclo4.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    userRepository userRepository;

    public List<User> obtenerUser() {
        return userRepository.obtenerUser();
    }

    public Optional<User> obtenerUserId(int id) {
        return userRepository.obtenerUserId(id);
    }

    public User crearUser(User user) {
        if(user.getId() == null){
           if(getValidaEmail(user.getEmail()) == false){
                return userRepository.crearUser(user);
            }else {
               return user;
           }
        }else{
            return user;
        }
    }

    public Boolean getValidaEmail(String email){
        return userRepository.validaEmail(email);
    }

    public User getValidaEmailPassword(String email, String password){
        Optional<User> usuario = userRepository.validaEmailPassword(email, password);

        if(usuario.isEmpty()){
            return new User(email, password, "No definido");
        }else {
            return usuario.get();
        }
    }
}
