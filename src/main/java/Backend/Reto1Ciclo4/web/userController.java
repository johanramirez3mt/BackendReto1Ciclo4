package Backend.Reto1Ciclo4.web;

import Backend.Reto1Ciclo4.model.User;
import Backend.Reto1Ciclo4.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class userController {

    @Autowired
    userService userService;

    @GetMapping("/all")
    public List<User> getUser() {
        return userService.obtenerUser();
    }

    @GetMapping("/(id)")
    public Optional<User> getUserId(@PathVariable("id") int userId) {
        return userService.obtenerUserId(userId);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user){
        return userService.crearUser(user);
    }

    @GetMapping("/{email}")
    public Boolean getValidaEmail (@PathVariable("email")String email){
        return userService.getValidaEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User getValidaEmailPassword (@PathVariable("email")String email, @PathVariable("password")String password){
        return userService.getValidaEmailPassword(email,password);
    }
}
