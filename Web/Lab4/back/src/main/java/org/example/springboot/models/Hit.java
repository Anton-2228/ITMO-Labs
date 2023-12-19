package org.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="hits")
public class Hit {

    @GeneratedValue
    @Id
    private int id;
    private double r;
    private double x;
    private double y;
    private String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    private String runtime;
    private boolean result;
    @ManyToOne
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Hit(double r, double x, double y, String runtime, boolean result, User user) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.runtime = runtime;
        this.result = result;
        this.user = user;
    }

    public Hit() {

    }

    public int getId() {
        return id;
    }

    public double getR() {
        return this.r;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String getTime() {
        return this.time;
    }

    public String getRunTime() {
        return this.runtime;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
