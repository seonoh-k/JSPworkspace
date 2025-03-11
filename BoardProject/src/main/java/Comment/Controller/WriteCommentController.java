package Comment.Controller;

import Board.DTO.BoardDetailDTO;
import Board.Service.ShowBoardDetailService;
import Comment.Service.WriteCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/WriteCommentController")
public class WriteCommentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user_no = req.getParameter("user_no");
        String board_no = req.getParameter("board_no");
        String content = req.getParameter("content");
        String comment_no = req.getParameter("comment_no");
        boolean isWriteSuccess = false;

        WriteCommentService writeCommentService = new WriteCommentService();

        try {
            if (comment_no != null) {
                isWriteSuccess = writeCommentService.writeCoComment(user_no, board_no, content, comment_no);
            }else {
                isWriteSuccess = writeCommentService.writeComment(user_no, board_no, content);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        if(isWriteSuccess) {

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
