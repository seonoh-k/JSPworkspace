package com.nonage.admin.controller.action;

import com.nonage.controller.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;
import com.nonage.dto.WorkerVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminProductUpdateFormAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "admin/product/AdminProductUpdate.jsp";
        String pseq = req.getParameter("pseq");

        HttpSession session = req.getSession(false);
        WorkerVO admin = (WorkerVO) session.getAttribute("admin");

        if(admin == null) {
            url = "NonageServlet?command=admin_login_form";
        }else {
            ProductDAO pDao = ProductDAO.getInstance();
            ProductVO product = pDao.getProduct(pseq);
            req.setAttribute("product", product);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
