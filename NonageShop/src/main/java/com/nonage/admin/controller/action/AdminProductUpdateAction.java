package com.nonage.admin.controller.action;

import com.nonage.controller.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminProductUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "NonageServlet?command=admin_product_list";

        ProductVO product = new ProductVO();
        product.setPseq(Integer.parseInt(req.getParameter("pseq")));
        product.setKind(req.getParameter("kind"));
        product.setName(req.getParameter("name"));
        product.setPrice1(Integer.parseInt(req.getParameter("price1")));
        product.setPrice2(Integer.parseInt(req.getParameter("price2")));
        product.setPrice3(Integer.parseInt(req.getParameter("price3")));
        product.setContent(req.getParameter("content"));
        product.setImage(req.getParameter("image"));
        product.setUseyn(req.getParameter("useyn"));
        product.setBestyn(req.getParameter("bestyn"));


        ProductDAO pDao = ProductDAO.getInstance();
        pDao.adminProductUpdate(product);

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
