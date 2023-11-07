package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="AreaCheckServlet", value="/check")
public class AreaCheckServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long a = System.nanoTime();
        String rawX = req.getParameter("x");
        String rawY = req.getParameter("y");
        String rawR = req.getParameter("r");

        float x = 0;
        try {
            x = Float.parseFloat(rawX);
        } catch (Exception e) {
            resp.setContentType("text/html");
            resp.sendError(401, "X странный проник на сервер. Что-то не санкцианированное произошло.");
            return;
        }

        float r = 0;
        try {
            r = Float.parseFloat(rawR);
        } catch (Exception e) {
            resp.setContentType("text/html");
            resp.sendError(401, "R странный проник на сервер. Что-то не санкцианированное произошло.");
            return;
        }

        float y = 0;
        try {
            y = Float.parseFloat(rawY);
        } catch (Exception e) {
            resp.setContentType("text/html");
            resp.sendError(401, "Y странный проник на сервер. Что-то не санкцианированное произошло.");
            return;
        }

        boolean result = true;
        if (y < -r/2.0 || y > r || x < -r || x > r) {
            result = false;
        }else if (y < 0 && x < 0) {
            result = false;
        }else if (y > 0 && x > 0 && y+x > r/2.0) {
            result = false;
        }else if (y > 0 && x < 0 && Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) > r) {
            result = false;
        }

        String deltTime = String.valueOf(System.nanoTime() - a);
        resp.setStatus(201);
        AllHit allhit = (AllHit) req.getSession().getAttribute("hits");
        allhit.addHit(new Hit(r,x,y,deltTime,result));
    }
}
