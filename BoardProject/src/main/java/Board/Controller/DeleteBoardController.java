package Board.Controller;

import Board.Service.DeleteBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteBoardController")
public class DeleteBoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String board_no = req.getParameter("board_no");
        boolean isDeleteSuccess = false;
        String referer = resp.getHeader("Referer");
        PrintWriter out = resp.getWriter();

        DeleteBoardService deleteBoardService = new DeleteBoardService();


        try{
            isDeleteSuccess = deleteBoardService.deleteBoard(board_no);

            if(isDeleteSuccess) {
                out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('게시글을 삭제했습니다.');");
                out.println("window.location.href = '" + referer + "';");
                out.println("</script>");
                out.println("</body></html>");
                return;
            }else {
                out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('게시글 삭제에 실패했습니다.');");
                out.println("window.location.href = '" + referer + "';");
                out.println("</script>");
                out.println("</body></html>");
                return;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
