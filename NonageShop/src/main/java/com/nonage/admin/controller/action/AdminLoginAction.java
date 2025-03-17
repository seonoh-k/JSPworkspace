package com.nonage.admin.controller.action;

import com.nonage.controller.NonageServlet;
import com.nonage.controller.action.Action;
import com.nonage.dao.WorkerDAO;
import com.nonage.dto.WorkerVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminLoginAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "NonageServlet?command=admin_product_list";

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        WorkerDAO wDao = WorkerDAO.getInstance();
        WorkerVO admin = (WorkerVO) wDao.getAdmin(id, pwd);

        if(admin == null) {
            url = "NonageServlet?command=admin_login";
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("admin", admin);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
