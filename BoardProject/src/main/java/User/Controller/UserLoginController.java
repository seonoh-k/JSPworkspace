package User.Controller;

import User.Service.UserLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user_id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        int id = Integer.parseInt(user_id);

        UserLoginService userLoginService = new UserLoginService();
        boolean isLoginSuccess = userLoginService.userLogin(id, pwd);

        if(isLoginSuccess) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            session.setAttribute("pwd", pwd);
            resp.sendRedirect("/view/main.jsp");
        }else {
            resp.sendRedirect("/view/Login.jsp");
        }
    }
}
