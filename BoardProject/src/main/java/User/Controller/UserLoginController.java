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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        UserLoginService userLoginService = new UserLoginService();
        int user_no = userLoginService.userLogin(id, pwd);
        PrintWriter out = resp.getWriter();

        if(user_no != 0) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            session.setAttribute("pwd", pwd);
            session.setAttribute("user_no", user_no);
            resp.sendRedirect("main.jsp");
        }else {
            out.println("<script src='../script/writeComment.js'></script>");
            out.println("<script type='text/javascript'>loginFail();</script>");
        }
    }
}
