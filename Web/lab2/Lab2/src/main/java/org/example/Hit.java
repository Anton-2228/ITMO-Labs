package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Hit {
    private float r;
    private float x;
    private float y;
    private String time;
    private String runtime;
    private boolean result;

    public Hit(float r, float x, float y, String runtime, boolean result) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.runtime = runtime;
        this.result = result;
    }

    public float getR() {
        return this.r;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public String getTime() {
        return this.time;
    }

    public String getRunTime() {
        return this.runtime;
    }

    public boolean getResult() {
        return this.result;
    }
}
