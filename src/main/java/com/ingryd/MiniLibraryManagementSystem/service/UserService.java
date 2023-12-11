package com.ingryd.MiniLibraryManagementSystem.service;

import com.ingryd.MiniLibraryManagementSystem.model.User;
import com.ingryd.MiniLibraryManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public ResponseEntity<User> findUserById(int id){
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "Deleted Successfully";
    }
    public User updateUser(int id, User user){
        User userUpdate = userRepository.findById(id).orElse(null);
        assert userUpdate != null;
        userUpdate.setFullName(user.getFullName());
        userUpdate.setAge(user.getAge());
        userUpdate.setAddress(user.getAddress());
        userUpdate.setEmail(user.getEmail());
        return userRepository.save(userUpdate);
    }
}
