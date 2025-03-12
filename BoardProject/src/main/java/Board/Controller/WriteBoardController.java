package Board.Controller;

import Board.DTO.BoardDTO;
import Board.Service.WriteBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet("/WriteBoardController")
public class WriteBoardController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        boolean isWriteSuccess = false;
        PrintWriter out = resp.getWriter();

        int user_no = (Integer)session.getAttribute("user_no");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardDTO newBoard = new BoardDTO(user_no, title, content);

        WriteBoardService writeBoardService = new WriteBoardService();
        try {
            isWriteSuccess = writeBoardService.writeBoard(newBoard);
        }catch(Exception e) {
            e.printStackTrace();
        }

        if(isWriteSuccess) {
            resp.sendRedirect("ShowBoardListProcess.jsp");
        }else {
            out.println("<script src='../script/writeComment.js'></script>");
            out.println("<script type='text/javascript'>writeBoardFail();</script>");
        }
    }
}
