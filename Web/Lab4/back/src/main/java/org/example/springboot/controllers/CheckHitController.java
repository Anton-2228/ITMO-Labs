package org.example.springboot.controllers;

import org.example.springboot.db.HitDB;
import org.example.springboot.db.UserDB;
import org.example.springboot.l_data.L_Hit;
import org.example.springboot.models.Hit;
import org.example.springboot.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/check")
public class CheckHitController {
    private final UserDB userDB;
    private final HitDB hitDB;
    public CheckHitController(UserDB userDB, HitDB hitDB) {
        this.userDB = userDB;
        this.hitDB = hitDB;
    }

    @PostMapping("/getTable")
    public ResponseEntity<?> getTable(@RequestBody L_Hit l_hit) {
        if (!userDB.existsByLogin(l_hit.getLogin())) {
            return ResponseEntity.badRequest().body("Wrong user");
        }
        User user = userDB.findUserByLogin(l_hit.getLogin()).get();
        ArrayList<Hit> list = hitDB.findHitsByUser(user);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @PostMapping("/point")
    public ResponseEntity<?> newCheckResult(@RequestBody L_Hit l_hit) {
        if (!userDB.existsByLogin(l_hit.getLogin())) {
            return ResponseEntity.badRequest().body("Wrong user");
        }
        if (l_hit.getX() < -5 || l_hit.getX() > 3) {
            return ResponseEntity.badRequest().body("x must be upper -5 and lower 3");
        }
        if (l_hit.getY() < -5 || l_hit.getY() > 5) {
            return ResponseEntity.badRequest().body("y must be upper -5 and lower 5");
        }
        if (l_hit.getR() < 1 || l_hit.getR() > 3) {
            return ResponseEntity.badRequest().body("x must be upper 1 and lower 3");
        }
        checkArea(l_hit);
        return ResponseEntity.ok().body("Ok");
    }

    public void checkArea(L_Hit l_hit) {
        long a = System.nanoTime();
        double x = l_hit.getX();
        double y = l_hit.getY();
        double r = l_hit.getR();

        boolean result = true;
        if (y > 0 && x > 0 && Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) > r) {
            result = false;
        } else if (y < 0 && x > 0 && (-y + x/2) > r/2) {
            result = false;
        } else if (y < -r/2 || x < -r) {
            result = false;
        } else if (y > 0 && x < 0) {
            result = false;
        }

        String deltTime = String.valueOf(System.nanoTime() - a);
        Hit hit = new Hit();
        hit.setR(r);
        hit.setX(x);
        hit.setY(y);
        hit.setResult(result);
        hit.setRuntime(deltTime);
        hit.setUser(userDB.findUserByLogin(l_hit.getLogin()).get());
        hitDB.save(hit);
    }
}