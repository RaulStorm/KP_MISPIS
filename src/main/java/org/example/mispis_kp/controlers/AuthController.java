package org.example.mispis_kp.controlers;

import org.example.mispis_kp.models.User;
import org.example.mispis_kp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // РЕГИСТРАЦИЯ
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(">>> Получен запрос на регистрацию");
        System.out.println(">>> Имя пользователя: " + user.getUsername() + ", Роль: " + user.getRole());

        if (user.getUsername() == null || user.getPassword() == null || user.getRole() == null) {
            System.out.println(">>> Пожалуйста, заполните все поля");
            return ResponseEntity.badRequest().body("Пожалуйста, заполните все поля");
        }

        if (userRepository.findByUsername(user.getUsername()) != null) {
            System.out.println(">>> Пользователь уже существует");
            return ResponseEntity.badRequest().body("Пользователь уже существует");
        }

        userRepository.save(user);
        System.out.println(">>> Пользователь успешно зарегистрирован");
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

    // ВХОД
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existing = userRepository.findByUsername(user.getUsername());

        if (existing == null || !existing.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверные имя пользователя или пароль");
        }

        // Вернём роль, чтобы клиент мог редиректить
        return ResponseEntity.ok(existing.getRole());
    }
}
