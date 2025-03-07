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
import java.util.ArrayList;

@WebServlet("/ShowBoardListController")
public class ShowBoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ShowBoardListService showBoardListService = new ShowBoardListService();

        try {
            ArrayList<BoardDTO> boardList = showBoardListService.selectBoardList();

            req.setAttribute("boardList", boardList);
            req.getRequestDispatcher("view/ShowBoardList.jsp").forward(req, resp);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }



}
