package Board.Controller;

import Board.DTO.BoardDTO;
import Board.DTO.BoardDetailDTO;
import Board.Service.ShowBoardDetailService;
import Board.Service.UpdateBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/UpdateBoardController")
public class UpdateBoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String board_no = (String)req.getAttribute("board_no");
        UpdateBoardService updateBoardService = new UpdateBoardService();
        BoardDTO modifyBoard = null;

        try {
            modifyBoard = updateBoardService.selectMyBoard(board_no);
        }catch(Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("modifyBoard", modifyBoard);
        req.getRequestDispatcher("view/UpdateBoard.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = (String)req.getAttribute("title");
        String content = (String)req.getAttribute("content");
        String board_no = (String)req.getAttribute("board_no");
        UpdateBoardService updateBoardService = new UpdateBoardService();
        boolean isUpdateSuccess = false;

        try {
            isUpdateSuccess = updateBoardService.updateBoard(title, content, board_no);
        }catch(Exception e) {
            e.printStackTrace();
        }

        if(isUpdateSuccess) {

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
}
