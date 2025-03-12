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
import java.util.List;

@WebServlet("/productList.do")
public class ProductListServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAO pDAO = ProductDAO.getInstance();

        List<ProductVO> productList = pDAO.selectAllProducts();
        req.setAttribute("productList", productList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("product/ProductList.jsp");
        dispatcher.forward(req, resp);
    }
}
