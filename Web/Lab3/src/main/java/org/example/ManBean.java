package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.Hit;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value="ManBean")
@ApplicationScoped
public class ManBean implements Serializable {
    private Double x;
    private Double y;
    private Double r;
    @Inject
    private DBManager dbManager;
    private ArrayList<Hit> array = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.x = 0.0;
        this.y = 0.0;
        this.r = 1.0;
        this.array = dbManager.getHits();
    }

    public Double getY() {
        return y;
    }
    public Double getR() {
        return r;
    }
    public Double getX() {
        return x;
    }
    public ArrayList<Hit> getArray() {
        return array;
    }

    public void setY(Double y) {
        this.y = y;
    }
    public void setX(Double x) {
        this.x = x;
    }
    public void setR(Double r) {
        this.r = r;
    }
    public void setArray(ArrayList<Hit> array) {
        this.array = array;
    }
    public void get_point() {
        long a = System.nanoTime();
        System.out.println(this.x);
        System.out.println(this.y);
        System.out.println(this.r);
        if (this.x >= -3 && this.x <= 3 && this.y >= -3 && this.y <= 3 && this.r >= 1 && this.r <= 4) {
            boolean result = true;
            if (this.y < -this.r || this.y > this.r || this.x < -this.r || this.x > this.r) {
                result = false;
            } else if (this.y > 0 && this.x > 0) {
                result = false;
            } else if (this.y < 0 && this.x > 0 && Math.abs(this.y) + this.x > this.r) {
                result = false;
            } else if (this.y > 0 && this.x < 0 && Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)) > this.r) {
                result = false;
            } else if (this.y < 0 && this.x < -this.r / 2) {
                result = false;
            }

            String deltTime = String.valueOf(System.nanoTime() - a);
            Hit hit = new Hit(this.r, this.x, this.y, deltTime, result);
            dbManager.addHit(hit);
            array.add(hit);
        }
    }
}
