package com.nonage.admin.controller.action;

import com.nonage.controller.action.Action;
import com.nonage.dao.ProductDAO;
import com.nonage.dto.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AdminProductSearchAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "admin/product/AdminProductSearch.jsp";
        String name = req.getParameter("name");

        HttpSession session = req.getSession(false);
        ProductDAO pDao = ProductDAO.getInstance();

        // 전체 글 개수 받아오기
        // 시작 페이지 번호
        int page = 1;
        // 페이지 개수
        int limit = 5;

        // 요청한 페이지 번호
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }

        // 전체 게시물 개수
        int listcount = pDao.getSearchListCount(name);


        // 총 페이지 수
        int maxpage = (int)((double)listcount / limit + 0.95);

        // 블럭의 시작 페이지 번호 (1, 11, 21 ..)
        int startpage = (((int) ((double)page / 10 + 0.95)) - 1) * 10 + 1;
        // 블럭의 마지막 번호 (10, 20, 30..)
        int endpage = maxpage;

        // 마지막 번호가 10 이상이 된다면 10 단위로 바꿈
        // 현재 블럭의 마지막 페이지 번호
        if(endpage > startpage + 10 - 1) {
            endpage = startpage + 10 - 1;
        }

        if(session == null) {
            url = "NonageServlet?command=admin_login_form";
        }else {
            ArrayList<ProductVO> productList = pDao.adminProductSearchList(name, page, limit);
            req.setAttribute("page", page);
            req.setAttribute("maxpage", maxpage);
            req.setAttribute("startpage", startpage);
            req.setAttribute("endpage", endpage);
            req.setAttribute("listcount", listcount);
            req.setAttribute("productList", productList);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
