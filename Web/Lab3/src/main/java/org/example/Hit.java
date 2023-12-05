package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    private String time;
    private String runtime;
    private boolean result;

    public Hit(double r, double x, double y, String runtime, boolean result) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.runtime = runtime;
        this.result = result;
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
}
