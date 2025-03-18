package com.nonage.admin.controller.action;

import com.nonage.controller.action.Action;
import com.nonage.dao.QnaDAO;
import com.nonage.dto.MemberVO;
import com.nonage.dto.QnaVO;
import com.nonage.dto.WorkerVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminQnaInsertReplyAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int qseq = Integer.parseInt(req.getParameter("qseq"));
        String rep = req.getParameter("rep");
        String reply = req.getParameter("reply");
        String url = "NonageServlet?command=admin_qna_detail&qseq="+qseq;

        HttpSession session = req.getSession();
        WorkerVO admin = (WorkerVO) session.getAttribute("admin");

        if (admin == null) {
            url = "NonageServlet?command=admin_login_form";
        }else {
            QnaDAO qDao = QnaDAO.getInstance();
            QnaVO qna = new QnaVO();
            qna.setQseq(qseq);
            qna.setRep(rep);
            qna.setReply(reply);
            qDao.adminQnaInsertReply(qna);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
