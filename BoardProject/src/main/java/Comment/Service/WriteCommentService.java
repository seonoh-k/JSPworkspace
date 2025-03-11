package Comment.Service;


import Comment.DAO.CommentDAO;

import java.sql.Connection;

import static Util.DBUtil.*;
public class WriteCommentService {
    public boolean writeComment(String user_no, String board_no, String content) throws Exception {

        Connection con = getConnection();
        CommentDAO commentDAO = new CommentDAO(con);

        boolean isWriteSuccess = false;
        int isUploaded = commentDAO.insertComment(user_no, board_no, content);

        if(isUploaded != 0) {
            isWriteSuccess = true;
            commit(con);
        }else {
            rollback(con);
        }
        return isWriteSuccess;
    }

    public boolean writeCoComment(String user_no, String board_no, String content, String comment_no) throws Exception {

        Connection con = getConnection();
        CommentDAO commentDAO = new CommentDAO(con);

        boolean isWriteSuccess = false;
        int isUploaded = commentDAO.insertCoComment(user_no, board_no, content, comment_no);

        if(isUploaded != 0) {
            isWriteSuccess = true;
            commit(con);
        }else {
            rollback(con);
        }
        return isWriteSuccess;
    }
}
