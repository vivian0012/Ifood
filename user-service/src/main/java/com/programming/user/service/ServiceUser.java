package com.programming.user.service;


import com.programming.user.entities.User;
import com.programming.user.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repositoryUser;

    public User creatObjEmail(User obj) {
        return repositoryUser.save(obj);
    }

    // CREAT
    public boolean creatUser(User obj){
            List<User> usuarios = repositoryUser.findAll();
            for (User userExist : usuarios) {
                if ( userExist.getUserEmail().equals(obj.getUserEmail())
                        && userExist.getUserPhone().equals(obj.getUserPhone())) {
                    return false;
                }
            }
            repositoryUser.save(obj);
            return true;
    }

    public boolean authUser(String userName, String userPassword){
        List<User> users = repositoryUser.findAll();
        for (User user : users){
            if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
                return true;
            }
        }
        return false;
    }

    public void deleteById(Long idUser){
        User deleteId = repositoryUser.findById(idUser).get();
        repositoryUser.deleteById(deleteId.getIdUser());
    }
}
