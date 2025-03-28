package Board.Controller;

import Board.DTO.BoardDTO;
import Board.Service.ShowBoardListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/ShowBoardListController")
public class ShowBoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        ShowBoardListService showBoardListService = new ShowBoardListService();
        PrintWriter out = resp.getWriter();

        if (session.getAttribute("user_no") == null) {
            out.println("<script src='../script/writeComment.js'></script>");
            out.println("<script type='text/javascript'>loginFirst();</script>");
            return;
        }

        try {
            ArrayList<BoardDTO> boardList = showBoardListService.selectBoardList();

            req.setAttribute("boardList", boardList);
            req.getRequestDispatcher("view/ShowBoardList.jsp").forward(req, resp);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}
