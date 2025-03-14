package com.nonage.controller.action;



import com.nonage.dao.AddressDAO;
import com.nonage.dto.AddressVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FindZipNumAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "member/findZipNum.jsp";
        String dong = req.getParameter("dong");

        if(dong != null && dong.equals("") == false) {
            AddressDAO aDao = AddressDAO.getInstance();
            ArrayList<AddressVO> addressList = aDao.selectAddressByDong(dong);
            req.setAttribute("addressList", addressList);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }
}
