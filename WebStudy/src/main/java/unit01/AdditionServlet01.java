package unit01;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 주소 - http://localhost:9999/WebStudy/AdditionServlet01
@WebServlet("/AdditionServlet01")
public class AdditionServlet01 extends HttpServlet {
// servlet -> url 요청을 통해서만 동작한다.
// 웹에서 html 코드가 노출되지 않기 때문에 보안성이 높아진다.
//    @Override
//    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
//
//        req.setCharacterEncoding("text/html; charset=UTF-8");
//        int num1 = 20;
//        int num2 = 10;
//        int add = num1 + num2;
//
//        // PrintWriter 객체 생성
//        PrintWriter out = resp.getWriter();
//
//        // HTML 코드 삽입
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>");
//        out.println("</title>");
//        out.println("</head>");
//        out.println("<body>");
//
//        out.println(num1 + " + " + num2 + " = " + add);
//        out.println("<p>느금마 고려장</p>");
//        out.println("</body>");
//        out.println("</html>");
//    }

    // Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        int num1 = 20;
        int num2 = 10;
        int add = num1 + num2;

        // PrintWriter 객체 생성
        PrintWriter out = resp.getWriter();

        // HTML 코드 삽입
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");

        out.println(num1 + " + " + num2 + " = " + add);
        out.println("<p>느금마 고려장</p>");
        out.println("</body>");
        out.println("</html>");
    }

    // Post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
