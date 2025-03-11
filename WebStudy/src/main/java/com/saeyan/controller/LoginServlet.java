package com.saeyan.controller;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "member/login.jsp";

        // resp.sendRedirect(url);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userid = req.getParameter("userid");
        String pwd = req.getParameter("pwd");

        MemberDAO mDAO = MemberDAO.getInstance();
        int result = mDAO.userCheck(userid, pwd);
        String url = "member/login.jsp";

        if(result == 1) {
            // 로그인 성공
            MemberVO mVO = mDAO.getMember(userid);
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", mVO);
            req.setAttribute("message", "로그인 성공");
            url = "main.jsp";
        }else if(result == 0){
            // 비밀번호 실패
            req.setAttribute("message", "비밀번호 불일치");
        }else if(result == -1) {
            // 회원 정보 없음
            req.setAttribute("message", "회원 정보가 없습니다.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
