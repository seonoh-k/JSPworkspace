package com.nonage.controller.action;

import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductKindAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "product/productKind.jsp";
        String kind = req.getParameter("kind");

        ProductDAO pDAO = ProductDAO.getInstance();
        ArrayList<ProductVO> productList = pDAO.getProductListByKind(kind);

        req.setAttribute("productList", productList);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
