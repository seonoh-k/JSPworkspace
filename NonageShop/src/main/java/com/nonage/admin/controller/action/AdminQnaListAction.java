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
import java.util.ArrayList;

public class AdminQnaListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "admin/qna/AdminQnaList.jsp";
        HttpSession session = req.getSession(false);
        WorkerVO admin = (WorkerVO)session.getAttribute("admin");

        if(admin == null){
            url = "NonageServlet?command=admin_login_form";
        }else{
            QnaDAO qnaDAO = QnaDAO.getInstance();
            ArrayList<QnaVO> qnaList = qnaDAO.adminQnaList();
            req.setAttribute("qnaList",qnaList);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
