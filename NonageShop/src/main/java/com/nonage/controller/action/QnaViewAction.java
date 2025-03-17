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

public class QnaViewAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "qna/qna_view.jsp";

        HttpSession session = req.getSession(false);
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        QnaDAO qDao = QnaDAO.getInstance();
        if(loginUser == null) {
            url = "NonageServlet?command=login";
        }else {
            int qseq = Integer.parseInt(req.getParameter("qseq"));
            QnaVO qna = qDao.selectQna(qseq);
            req.setAttribute("qna", qna);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
