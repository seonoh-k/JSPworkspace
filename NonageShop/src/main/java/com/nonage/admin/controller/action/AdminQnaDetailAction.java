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

public class AdminQnaDetailAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "admin/qna/AdminQnaDetail.jsp";
        HttpSession session = req.getSession();

        WorkerVO admin = (WorkerVO)session.getAttribute("admin");

        if(admin == null){
            url = "NonageServlet?command=admin_login_form";
        }else{
            int qseq = Integer.parseInt(req.getParameter("qseq"));
            QnaDAO qnaDAO = QnaDAO.getInstance();
            QnaVO qnaVO = qnaDAO.selectQna(qseq);
            req.setAttribute("qnaVO",qnaVO);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
