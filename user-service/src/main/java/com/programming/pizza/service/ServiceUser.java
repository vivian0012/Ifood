package com.programming.pizza.service;


import com.programming.pizza.entities.User;
import com.programming.pizza.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repositoryUser;

    public User creatObjEmail(User obj) {
        return repositoryUser.save(obj);
    }

    // CREAT AND VERIFY IF UserEmail EXIST
    public boolean creatUser(User obj){
        try {
            List<User> usuarios;
            usuarios = repositoryUser.findAll();
            for (User userExist : usuarios) {
                if ( userExist.getUserEmail().equals(obj.getUserEmail())
                        && userExist.getUserPhone().equals(obj.getUserPhone())) {
                    return false;
                }
            }
            repositoryUser.save(obj);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    public boolean authUser(String userEmail, String userPassword){
        List<User> users = repositoryUser.findAll();
        for (User user : users){
            if (user.getUserEmail().equals(userEmail) && user.getUserPassword().equals(userPassword)) {
                return true;
            }
        }
        return false;
    }

}
