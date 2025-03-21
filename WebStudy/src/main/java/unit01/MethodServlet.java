package unit01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MethodServlet")
public class MethodServlet extends HttpServlet {
    // 필요에 따라 jsp와 연결하는 역할을 수행

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get - post 방식의 요청을 제외한 모든 요청
        // 브라우저에 직접 주소 작성
        // <a href=""> 태그를 사용하는 방식
        // url 뒤에 ?가 붙는다 (쿼리 스트링)

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>get 방식으로 처리됨</h1>");
        out.close();

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // post - form 태그의 메소드 속성 정의

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>post 방식으로 처리됨</h1>");
        out.close();

    }
}
