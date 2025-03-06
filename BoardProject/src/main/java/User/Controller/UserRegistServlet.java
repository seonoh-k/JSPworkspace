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

@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {

    UserDTO newUser = null;
    UserRegistService userRegistService = new UserRegistService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String gender = req.getParameter("gender");
        String birth = req.getParameter("birth");

        PrintWriter out = resp.getWriter();

        int user_id = Integer.parseInt(id);
        Date user_birth = Date.valueOf(birth);

        newUser = new UserDTO(user_id, email, name, pwd, gender, user_birth);
        try {
            boolean isRegisted = userRegistService.registUser(newUser);

            if(isRegisted) {
                out.println("<p>Regist Success</p>");
            }else {
                out.println("<p>Regist Denied</p>");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
