package com.nonage.controller.action;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductDetailAction implements Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "product/productDetail.jsp";
        String pseq = req.getParameter("pseq");

        // DAO 요청
        ProductDAO pDAO = ProductDAO.getInstance();
        ProductVO pVO = pDAO.getProduct(pseq);

        req.setAttribute("product", pVO);
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
