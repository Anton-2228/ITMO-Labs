package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="GetTableServlet", value="/getTable")
public class GetTableServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String table = "<h2>Результаты</h2> " +
                "<table> " +
                "<tr> " +
                "<td><p>R</p></td> " +
                "<td><p>X</p></td> " +
                "<td><p>Y</p></td> " +
                "<td><p>Текущее время</p></td> " +
                "<td><p>Время выполнения</p></td> " +
                "<td><p>Результат</p></td> " +
                "</tr>";
        AllHit allhit = (AllHit) req.getSession().getAttribute("hits");
        for (Hit hit : allhit) {
            table += String.format("<tr>" +
                    "<td><p class='r_cord'>%f</p></td>" +
                    "<td><p class='x_cord'>%f</p></td>" +
                    "<td><p class='y_cord'>%f</p></td>" +
                    "<td><p>%s</p></td>" +
                    "<td><p>%s</p></td>" +
                    "<td><p>%s</p></td></tr>", hit.getR(), hit.getX(), hit.getY(), hit.getTime(), hit.getRunTime(), hit.getResult());
        }
        table += "</table>";
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(table);
        printWriter.close();
    }
}
