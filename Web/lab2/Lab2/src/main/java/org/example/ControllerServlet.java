package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ControllerServlet", value="/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("getTable")) {
            req.getRequestDispatcher("/getTable").forward(req, resp);
        } else if (req.getParameter("type").equals("addHit")) {
            req.getRequestDispatcher("/check").forward(req, resp);
        } else if (req.getParameter("type").equals("getJson")) {
            req.getRequestDispatcher("/getJson").forward(req, resp);
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
