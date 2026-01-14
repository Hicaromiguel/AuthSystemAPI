package dev.hicaro.AuthSystemAPI.Controller;

import dev.hicaro.AuthSystemAPI.Model.User;
import dev.hicaro.AuthSystemAPI.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/user")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public List<User> getAll() {
        return authService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return authService.getById(id);
    }

    @GetMapping("/find")
    public Optional<User> findByEmail(@RequestParam String email) {
        return authService.findByEmail(email);
    }
    @PostMapping
    public User saveUser(@Valid @RequestBody User user) {
        return authService.saveUser(user);
    }


    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        authService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        authService.deleteById(id);
    }
}
