package com.programming.user.repository;


import com.programming.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String userEmail); // Criando um método para encontrar o usuário
    Optional<User> findByUserPassword(String userPassword);
}
