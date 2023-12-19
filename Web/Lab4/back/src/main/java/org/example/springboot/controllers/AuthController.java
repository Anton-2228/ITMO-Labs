package org.example.springboot.controllers;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.example.springboot.db.UserDB;
import org.example.springboot.l_data.L_User;
import org.example.springboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Key;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {
    private final UserDB userDB;
    private PasswordEncoder passwordEncoder;
    private static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long expirationMs = 3600000; // Время действия токена: 1 час

    @Autowired
    public AuthController(UserDB userDB, PasswordEncoder passwordEncoder) {
        this.userDB = userDB;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/reg")
    public ResponseEntity<?> register(@RequestBody L_User l_user) {
        if(l_user.getLogin().length() > 20) {
            return ResponseEntity.badRequest().body("login is longer than 20 characters");
        }
        if(l_user.getLogin().equals("")) {
            return ResponseEntity.badRequest().body("The login cannot be an empty string");
        }
        if(l_user.getPassword().equals("")) {
            return ResponseEntity.badRequest().body("The password cannot be an empty string");
        }
        if(userDB.existsByLogin(l_user.getLogin())) {
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User exist");
            return ResponseEntity.badRequest().body("User exist");
        }



        User user = new User();
        user.setLogin(l_user.getLogin());
        //user.setPassword(passwordEncoder.encode(l_user.getPassword()));
        user.setPassword(l_user.getPassword());
        System.out.println(user);

        userDB.save(user);
        return ResponseEntity.ok().body("Ok");
    }

    @PostMapping("/log")
    public ResponseEntity<?> login(@RequestBody L_User l_user) {
        System.out.println(76847);
        if(l_user.getLogin().length() > 20) {
            return ResponseEntity.badRequest().body("login is longer than 20 characters");
        }
        if(l_user.getLogin().equals("")) {
            return ResponseEntity.badRequest().body("The login cannot be an empty string");
        }
        if(l_user.getPassword().equals("")) {
            return ResponseEntity.badRequest().body("The password cannot be an empty string");
        }
        if(!userDB.existsByLogin(l_user.getLogin())) {
            return ResponseEntity.badRequest().body("User not exist");
        }
        System.out.println(userDB.findUserByLogin(l_user.getLogin()).get().getPassword());
        System.out.println(passwordEncoder.encode(l_user.getPassword()));
        //if(!userDB.findUserByLogin(l_user.getLogin()).get().getPassword().equals(passwordEncoder.encode(l_user.getPassword()))) {
        if(!userDB.findUserByLogin(l_user.getLogin()).get().getPassword().equals(l_user.getPassword())) {
            System.out.println("Неверный пароль");
            return ResponseEntity.badRequest().body("Password not correct");
        }
        return ResponseEntity.ok().body("Ok");
    }
}
