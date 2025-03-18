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

public class AdminQnaInsertReplyFormAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "admin/qna/AdminQnaInsertReply.jsp";

        HttpSession session = req.getSession();
        WorkerVO admin = (WorkerVO) session.getAttribute("admin");

        if (admin == null) {
            resp.sendRedirect("NonageServlet?command=admin_login_form");
        }

        int qseq = Integer.parseInt(req.getParameter("qseq"));
        QnaDAO qnaDAO = QnaDAO.getInstance();
        QnaVO qnaVO = qnaDAO.selectQna(qseq); // 해당 QnA 조회

        if (qnaVO != null) {
            req.setAttribute("qnaVO", qnaVO); // JSP에서 사용 가능하도록 저장
        } else {
            req.setAttribute("errorMessage", "해당 Q&A 정보를 찾을 수 없습니다.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);


    }
}