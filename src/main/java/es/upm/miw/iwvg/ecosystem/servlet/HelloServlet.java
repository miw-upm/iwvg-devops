package es.upm.miw.iwvg.ecosystem.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<h1>Unersidad Politécnica de Madrid. Máster en Ingeniería Web</h1>");
        out.println("<h2>IWVG: Ecosistema software </h2>");
        out.println("<p>Hello!!!");
    }
}