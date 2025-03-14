package com.nonage.controller.action;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JoinAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "member/login.jsp";

        HttpSession session = req.getSession();
        MemberVO member = new MemberVO();

        member.setId(req.getParameter("id"));
        member.setPwd(req.getParameter("pwd"));
        member.setName(req.getParameter("name"));
        member.setEmail(req.getParameter("email"));
        member.setZipNum(req.getParameter("zipNum"));
        member.setAddress(req.getParameter("addr1") + req.getParameter("addr2"));
        member.setPhone(req.getParameter("phone"));

        session.setAttribute("id", member.getId());

        MemberDAO mDAO = MemberDAO.getInstance();
        mDAO.insertMember(member);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
