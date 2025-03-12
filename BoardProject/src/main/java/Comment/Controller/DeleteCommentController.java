package Comment.Controller;

import Comment.Service.DeleteCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteCommentController")
public class DeleteCommentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String comment_no = req.getParameter("comment_no");
        boolean isDeleteSuccess = false;
        PrintWriter out = resp.getWriter();

        DeleteCommentService deleteCommentService = new DeleteCommentService();

        try {
            isDeleteSuccess = deleteCommentService.deleteComment(comment_no);
            if(isDeleteSuccess) {
                out.println("<script src='../script/writeComment.js'></script>");
                out.println("<script type='text/javascript'>deleteCommentSuccess();</script>");
            }else {
                out.println("<script src='../script/writeComment.js'></script>");
                out.println("<script type='text/javascript'>deleteCommentFail();</script>");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
