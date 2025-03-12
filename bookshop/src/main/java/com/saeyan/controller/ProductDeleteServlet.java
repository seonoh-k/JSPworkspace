package com.saeyan.controller;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {

    public static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");

        ProductDAO pDAO = ProductDAO.getInstance();
        ProductVO pVO = pDAO.selectProductByCode(code);

        req.setAttribute("product", pVO);

        RequestDispatcher dispatcher = req.getRequestDispatcher("product/ProductDelete.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");

        ProductDAO pDAO = ProductDAO.getInstance();
        pDAO.deleteProduct(code);

        resp.sendRedirect("productList.do");
    }
}
