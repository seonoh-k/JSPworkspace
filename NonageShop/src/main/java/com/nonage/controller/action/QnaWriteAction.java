package com.nonage.controller.action;

import com.nonage.dao.QnaDAO;
import com.nonage.dto.MemberVO;
import com.nonage.dto.QnaVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QnaWriteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "NonageServlet?command=qna_list";

        HttpSession session = req.getSession(false);
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        if(loginUser == null) {
            url = "NonageServlet?command=login";
        }else {
            QnaVO qna = new QnaVO();
            QnaDAO qDao = QnaDAO.getInstance();

            qna.setSubject(req.getParameter("subject"));
            qna.setContent(req.getParameter("content"));

            qDao.insertQna(qna, loginUser.getId());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
