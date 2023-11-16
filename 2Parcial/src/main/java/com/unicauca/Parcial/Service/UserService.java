package com.unicauca.Parcial.Service;

import com.unicauca.Parcial.Model.User;
import com.unicauca.Parcial.Repository.IUserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    /**
     * @param idUser User id to register
     */
    public void registerUser(int idUser){
        if(userRepository.findById(idUser) != null){
            return;
        }
        userRepository.addUser(new User(idUser));
    }
}
