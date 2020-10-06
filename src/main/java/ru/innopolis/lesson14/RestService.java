package ru.innopolis.lesson14;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RestService extends HttpServlet {

    @EJB
    Accessor accessor;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Map.Entry<String, String>> environment = accessor.getEnvironment();
        for (Map.Entry<String, String> entry : environment) {
            resp.getWriter().println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
