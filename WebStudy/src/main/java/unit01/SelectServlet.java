package unit01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String job = req.getParameter("job");
        String[] jobs = req.getParameterValues("jobs");

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + job + "</h1>");

        for(String s : jobs) {
            out.println("<h1>" + s + "</h1>");
        }
        out.close();
    }
}
