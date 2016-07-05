package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Alexander on 04.07.2016.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = new String(request.getParameter("userId").getBytes("ISO-8859-1"), "UTF-8");
        if (userId.isEmpty()) {
            PrintWriter out = response.getWriter();
            out.write("<div style=\"text-align: center;\"><h3><span style=\"color: #ff4444; \">Error! Name field cannot be empty</span></h3>");
        } else {
            request.setAttribute("userId", userId);
            response.sendRedirect("chat.jsp");
            request.getSession().setAttribute("userId", userId);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
