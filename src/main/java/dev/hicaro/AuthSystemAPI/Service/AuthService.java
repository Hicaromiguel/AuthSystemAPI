package dev.hicaro.AuthSystemAPI.Service;

import dev.hicaro.AuthSystemAPI.Model.User;
import dev.hicaro.AuthSystemAPI.Repository.AuthRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    public AuthService(AuthRepository authRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthRepository authRepository;

    public List<User> getAll(){
        return authRepository.findAll();
    }

    public Optional<User> getById(Long id){
        return authRepository.findById(id);
    }

    public User saveUser(User user){
        if (!user.getPassword().startsWith("$2")) {// garante que não vai criptografar algo ja criptografadp
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return authRepository.save(user);
    }

    public void deleteById(Long id){
        authRepository.deleteById(id);
    }

    public void deleteAll(){
        authRepository.deleteAll();
    }

    public Optional<User> findByEmail(String email){
        return authRepository.findByEmail(email);
    }

}
