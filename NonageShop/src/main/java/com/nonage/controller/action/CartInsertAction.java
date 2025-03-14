package com.nonage.controller.action;

import com.nonage.controller.NonageServlet;
import com.nonage.dao.CartDAO;
import com.nonage.dto.CartVO;
import com.nonage.dto.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartInsertAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "NonageServlet?command=index";
        HttpSession session = req.getSession(false);

        MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
        CartDAO cDao = CartDAO.getInstance();

        if(loginUser == null) {
            url = "NonageServlet?command=login_form";
        }else {
            CartVO cart = new CartVO();
            cart.setId(loginUser.getId());
            cart.setPseq(Integer.parseInt(req.getParameter("pseq")));
            cart.setQuantity(Integer.parseInt(req.getParameter("quantity")));
            cDao.insertCart(cart);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
