package com.saeyan.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {

    public static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/ProductWrite.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        String path = context.getRealPath("upload");
        String encType = "UTF-8";
        int sizeLimit = 20 * 1024 * 1024;

        MultipartRequest multi = new MultipartRequest(req, path, sizeLimit, encType, new DefaultFileRenamePolicy());

        String name = multi.getParameter("name");
        int price = Integer.parseInt(multi.getParameter("price"));
        String description = multi.getParameter("description");
        String pictureUrl = multi.getFilesystemName("pictureUrl");

        ProductVO pVO = new ProductVO();
        pVO.setName(name);
        pVO.setPrice(price);
        pVO.setDescription(description);
        pVO.setPictureUrl(pictureUrl);

        ProductDAO pDAO = ProductDAO.getInstance();
        pDAO.insertProduct(pVO);

        resp.sendRedirect("productList.do");

    }
}
