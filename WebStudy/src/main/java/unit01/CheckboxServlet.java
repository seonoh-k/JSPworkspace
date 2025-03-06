package unit01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        String[] items = req.getParameterValues("item");

        PrintWriter out = resp.getWriter();

        if(items == null) {
            out.println("선택항목이 없습니다");
        }else {
            for(String s : items) {
                out.println("<h2>" + s + "</h2>");
            }
        }

        out.close();
    }
}
