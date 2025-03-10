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

@WebServlet("/ShowMyBoardListController")
public class ShowMyBoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        ShowBoardListService showBoardListService = new ShowBoardListService();
        PrintWriter out = resp.getWriter();

        if (session.getAttribute("user_no") == null) {
            out.println("<html><body>");
            out.println("<script type='text/javascript'>");
            out.println("alert('먼저 로그인 해주세요.');");
            out.println("window.location.href = 'Login.jsp';");  // 로그인 페이지로 리디렉션
            out.println("</script>");
            out.println("</body></html>");
            return;
        }

        int user_no = (Integer)session.getAttribute("user_no");

        try {
            ArrayList<BoardDTO> boardList = showBoardListService.selectMyBoardList(user_no);

            req.setAttribute("boardList", boardList);
            req.getRequestDispatcher("view/ShowMyBoardList.jsp").forward(req, resp);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }



}
