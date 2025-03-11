package Comment.Service;

import Comment.DAO.CommentDAO;
import Comment.DTO.CommentDTO;

import java.sql.*;
import java.util.ArrayList;

import static Util.DBUtil.*;

public class ShowCommentListService {
    public ArrayList<CommentDTO> selectMyCommentList(int user_no) throws Exception {

        Connection con = getConnection();
        CommentDAO commentDAO = new CommentDAO(con);

        ArrayList<CommentDTO> commentList = commentDAO.selectMyCommentList(user_no);

        return commentList;
    }
}
