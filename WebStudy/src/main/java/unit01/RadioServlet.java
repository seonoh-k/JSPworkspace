package unit01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        String gender = req.getParameter("gender");
        String content = req.getParameter("content");

        PrintWriter out = resp.getWriter();
        out.println("<p> 성별 : " + gender + "</p>");
        out.println("<p>" + content + "</p>");
        out.close();
    }
}
