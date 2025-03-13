package com.saeyan.controller.action;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardListAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/board/boardList.jsp";
        BoardDAO bDao = BoardDAO.getInstance();

        // 전체 글 개수 받아오기
        // 시작 페이지 번호
        int page = 1;
        // 페이지 개수
        int limit = 10;

        // 요청한 페이지 번호
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // 전체 게시물 개수
        int listcount = bDao.getListCount();

        //List<BoardVO> boardList = bDao.selectAllBoards();
        List<BoardVO> boardList = bDao.getBoardList(page, limit);

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

        request.setAttribute("page", page);
        request.setAttribute("maxpage", maxpage);
        request.setAttribute("startpage", startpage);
        request.setAttribute("endpage", endpage);
        request.setAttribute("listcount", listcount);
        request.setAttribute("boardList", boardList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response); // forward 사용시 예외처리 필수
    }
}
