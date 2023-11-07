package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="GetJsonServlet", value="/getJson")
public class GetJsonServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jso = "{\"elems\":[";
        AllHit allhit = (AllHit) req.getSession().getAttribute("hits");
        for (Hit hit : allhit) {
            jso += String.format("[\"%f\",\"%f\",\"%f\",\"%s\",\"%s\",\"%s\"],", hit.getR(), hit.getX(), hit.getY(), hit.getTime(), hit.getRunTime(), hit.getResult());
        }
        jso = jso.substring(0, jso.length() - 1);
        jso += "]}";
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(jso);
        printWriter.close();
    }
}
