package User.Controller;

import User.Service.UserLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        UserLoginService userLoginService = new UserLoginService();
        boolean isLoginSuccess = userLoginService.userLogin(id, pwd);
        PrintWriter out = resp.getWriter();

        if(isLoginSuccess) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            session.setAttribute("pwd", pwd);
            resp.sendRedirect("main.jsp");
        }else {
            out.println("<html><body>");
            out.println("<script type='text/javascript'>");
            out.println("alert('ID 또는 비밀번호가 틀렸습니다.');");
            out.println("window.location.href = 'Login.jsp';");  // 로그인 페이지로 리디렉션
            out.println("</script>");
            out.println("</body></html>");
        }
    }
}
