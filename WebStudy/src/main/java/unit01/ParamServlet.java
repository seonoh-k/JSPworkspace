package unit01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("text/html; charset=UTF-8");
        
        // jsp에서 parameter 값을 문자열로 받아옴
        String id = req.getParameter("id");
        String age = req.getParameter("age");

        PrintWriter out = resp.getWriter();
        out.println("<p> id = " + id + "</p>");
        out.println("<p> age = " + age + "</p>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.setCharacterEncoding("UTF-8"); // post 방식에만 작성
        //resp.setContentType("text/html; charset=UTF-8");
        String id = req.getParameter("id");
        String age = req.getParameter("age");

        PrintWriter out = resp.getWriter();
        out.println("<p> id = " + id + "</p>");
        out.println("<p> age = " + age + "</p>");
        out.close();

    }
}
