package dev.hicaro.AuthSystemAPI.Repository;

import dev.hicaro.AuthSystemAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}
