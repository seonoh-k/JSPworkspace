package User.Controller;

import User.DTO.UserDTO;
import User.Service.UserRegistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/UserRegistController")
public class UserRegistController extends HttpServlet {

    UserDTO newUser = null;
    UserRegistService userRegistService = new UserRegistService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String id = req.getParameter("id");
        String user_email = req.getParameter("user_email");
        String domain = req.getParameter("domain");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String gender = req.getParameter("gender");
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");


        String email = user_email + "@" + domain;
        String user_birth = year + "-" + month + "-" + day;
        PrintWriter out = resp.getWriter();


        Date birth = Date.valueOf(user_birth);

        newUser = new UserDTO(id, email, name, pwd, gender, birth);

        try {
            boolean isRegisted = userRegistService.registUser(newUser);

            if(isRegisted) {
                out.println("<script src='../script/writeComment.js'></script>");
                out.println("<script type='text/javascript'>registSuccess();</script>");
            }

        }catch(Exception e) {
            out.println("<script src='../script/writeComment.js'></script>");
            out.println("<script type='text/javascript'>registFail();</script>");
        }

    }
}
