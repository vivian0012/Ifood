package com.programming.pizza.repository;


import com.programming.pizza.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {

    Optional<User> existsByUserEmail(String userEmail); // Criando um método para encontrar o usuário

}
