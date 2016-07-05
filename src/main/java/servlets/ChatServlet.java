package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander on 04.07.2016.
 */
@WebServlet(name = "ChatServlet", urlPatterns={"/chat"})
public class ChatServlet extends HttpServlet {

//    private BlockingQueue<Pair<String, String>> messages = new ArrayBlockingQueue<Pair<String, String>>(10);
    private Map<String, ArrayList<String>> userMessages = new HashMap<String, ArrayList<String>>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            messages.put(new Pair<String, String>(request.getParameter("from"), request.getParameter("message")));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (!userMessages.containsKey(request.getParameter("from"))) {
            userMessages.put(request.getParameter("from"), new ArrayList<String>());
        }
        for (Map.Entry<String, ArrayList<String>> msg : userMessages.entrySet()) {
            msg.getValue().add(request.getParameter("from") + ": " + request.getParameter("message"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//            Date date = new Date();
//            messages.put(new Pair<String, String>(dateFormat.format(date), "Hi there"));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Pair<String,String> message = messages.take();
//            String responseText = "<div>" + message.getKey() + ": " + message.getValue() + "</div>";
//            response.getWriter().write(responseText);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (!userMessages.containsKey(request.getParameter("from"))) {
            userMessages.put(request.getParameter("from"), new ArrayList<String>());
        }
        String responseText = "";
        for (String msg : userMessages.get(request.getParameter("from"))) {
            responseText += msg + "<br>";
        }
        userMessages.get(request.getParameter("from")).clear();
        response.getWriter().write(responseText);
    }
}
