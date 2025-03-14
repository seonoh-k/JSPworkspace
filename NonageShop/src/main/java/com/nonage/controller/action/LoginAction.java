package com.nonage.controller.action;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "member/login_fail.jsp";
        HttpSession session = req.getSession();

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        MemberDAO mDAO = MemberDAO.getInstance();
        MemberVO loginUser = mDAO.getMember(id,pwd);

        if(loginUser != null){
            session.removeAttribute("id");
            session.setAttribute("loginUser", loginUser);
            url = "NonageServlet?command=index";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
