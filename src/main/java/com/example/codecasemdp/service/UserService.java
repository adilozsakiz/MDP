package com.example.codecasemdp.service;

import com.example.codecasemdp.entity.User;
import com.example.codecasemdp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public User addUser(User request) {
        var user = modelMapper.map(request,User.class);
        return modelMapper.map(userRepository.save(user), User.class);
    }

    public List<User> getUsers() {
        return userRepository.findAll().stream().map(todo -> modelMapper.map(todo, User.class)).toList();
    }
}
