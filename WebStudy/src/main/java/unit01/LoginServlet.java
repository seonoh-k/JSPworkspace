package unit01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("text/html; charset=UTF-8");

        String id = req.getParameter("id");
        String userpwd = req.getParameter("userpwd");

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + id + "</h1>");
        out.println("<h1>" + userpwd + "</h1>");
        out.close();
    }
}
