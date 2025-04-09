package org.example.mispis_kp.service;

import org.example.mispis_kp.models.User;
import org.example.mispis_kp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Метод для регистрации пользователя
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Метод для поиска пользователя по имени
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
