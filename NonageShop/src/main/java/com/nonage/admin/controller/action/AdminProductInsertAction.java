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

public class AdminProductInsertAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "NonageServlet?command=admin_product_list";

        ProductVO product = new ProductVO();
        product.setKind(req.getParameter("kind"));
        product.setName(req.getParameter("name"));
        product.setPrice1(Integer.parseInt(req.getParameter("price1")));
        product.setPrice2(Integer.parseInt(req.getParameter("price2")));
        product.setPrice3(Integer.parseInt(req.getParameter("price3")));
        product.setContent(req.getParameter("content"));
        product.setImage(req.getParameter("image"));


        ProductDAO pDao = ProductDAO.getInstance();
        pDao.adminProductInsert(product);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
