package com.saeyan.controller.action;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardViewAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/board/boardView.jsp";
        String num = request.getParameter("num");

        BoardDAO bDao = BoardDAO.getInstance();
        BoardVO bVo = bDao.selectOneBoardByNum(num);

        bDao.updateReadCount(num); // 조회수 증가

        request.setAttribute("board", bVo);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
