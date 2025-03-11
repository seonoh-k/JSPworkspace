package Comment.Controller;

import Board.DTO.BoardDetailDTO;
import Board.Service.ShowBoardDetailService;
import Comment.DTO.CommentDTO;
import Comment.Service.UpdateCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UpdateCommentController")
public class UpdateCommentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String comment_no = (String)req.getAttribute("comment_no");

        UpdateCommentService updateCommentService = new UpdateCommentService();
        CommentDTO modifyComment = null;

        try {
            modifyComment = updateCommentService.selectComment(comment_no);
        }catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("modifyComment", modifyComment);
        req.getRequestDispatcher("view/UpdateComment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String board_no = (String)req.getParameter("board_no");
        String comment_no = (String)req.getParameter("comment_no");
        String content = (String)req.getParameter("content");
        UpdateCommentService updateCommentService = new UpdateCommentService();

        boolean isUpdateSuccess = false;

        try {
            isUpdateSuccess = updateCommentService.updateComment(comment_no, content);
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
