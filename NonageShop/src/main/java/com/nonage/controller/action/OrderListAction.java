package com.nonage.controller.action;

import com.nonage.dao.OrderDAO;
import com.nonage.dto.MemberVO;
import com.nonage.dto.OrderVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class OrderListAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "mypage/order_list.jsp";
        String oseq = req.getParameter("oseq");
        String result = "1";

        HttpSession session = req.getSession(false);
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        OrderDAO oDao = OrderDAO.getInstance();

        if(oseq == null) {
            url = "NonageServlet?command=index";
        }else {
            ArrayList<OrderVO> orderList = oDao.listOrderById(loginUser.getId(), result, Integer.parseInt(oseq));
            req.setAttribute("orderList", orderList);

            int totalPrice = 0;
            for(OrderVO order : orderList) {
                totalPrice += order.getPrice2() * order.getQuantity();
            }

            req.setAttribute("orderList", orderList);
            req.setAttribute("totalPrice", totalPrice);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
