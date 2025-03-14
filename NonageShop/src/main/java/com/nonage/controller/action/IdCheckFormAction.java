package com.nonage.controller.action;

import com.nonage.dao.MemberDAO;
import com.nonage.dto.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdCheckFormAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "member/id_check.jsp";
        String id = req.getParameter("id");

        MemberDAO mDAO = MemberDAO.getInstance();

        int message = mDAO.confirmId(id);

        req.setAttribute("message", message);
        req.setAttribute("id", id);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
