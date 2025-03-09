package Board.Controller;

import Board.DTO.BoardDetailDTO;
import Board.Service.ShowBoardDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ShowBoardDetailController")
public class ShowBoardDetailController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int board_no = Integer.parseInt(req.getParameter("board_no"));
        ArrayList<BoardDetailDTO> boardDetailList = null;

        ShowBoardDetailService showBoardDetailService = new ShowBoardDetailService();

        try {
            boardDetailList = showBoardDetailService.selectBoardDetail(board_no);
        }catch(Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("boardDetailList", boardDetailList);
        req.getRequestDispatcher("view/ShowBoardDetail.jsp").forward(req, resp);

    }
}
