package com.nonage.controller.action;

import com.nonage.dao.CartDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "NonageServlet?command=cart_list";

        CartDAO cDao = CartDAO.getInstance();

        String[] cseqArr = req.getParameterValues("cseq");
        for(String cseq : cseqArr) {
            cDao.deleteCart(Integer.parseInt(cseq));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
