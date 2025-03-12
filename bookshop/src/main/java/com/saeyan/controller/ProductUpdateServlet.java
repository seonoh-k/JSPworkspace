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

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {

    public static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");

        ProductDAO pDAO = ProductDAO.getInstance();
        ProductVO pVO = pDAO.selectProductByCode(code);

        req.setAttribute("product", pVO);

        RequestDispatcher dispatcher = req.getRequestDispatcher("product/ProductUpdate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        String path = context.getRealPath("upload");
        String encType = "UTF-8";
        int sizeLimit = 20 * 1024 * 1024;

        MultipartRequest multi = new MultipartRequest(req, path, sizeLimit, encType, new DefaultFileRenamePolicy());

        String code = multi.getParameter("code");
        String name = multi.getParameter("name");
        int price = Integer.parseInt(multi.getParameter("price"));
        String description = multi.getParameter("description");
        String pictureUrl = multi.getFilesystemName("pictureUrl");
        if(pictureUrl == null) {
            pictureUrl = multi.getParameter("nonmakeImg");
        }

        ProductVO pVO = new ProductVO();
        pVO.setCode(Integer.parseInt(code));
        pVO.setName(name);
        pVO.setPrice(price);
        pVO.setDescription(description);
        pVO.setPictureUrl(pictureUrl);

        ProductDAO pDAO = ProductDAO.getInstance();
        pDAO.updateProduct(pVO);

        resp.sendRedirect("productList.do");
    }
}
