package org.example.mispis_kp.controlers;

import org.example.mispis_kp.models.User;
import org.example.mispis_kp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Регистрация нового пользователя
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Получение пользователя по имени
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
