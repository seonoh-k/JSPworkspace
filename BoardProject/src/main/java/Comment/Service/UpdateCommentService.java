package Comment.Service;

import Comment.DAO.CommentDAO;
import Comment.DTO.CommentDTO;

import java.sql.Connection;

import static Util.DBUtil.*;
public class UpdateCommentService {
    public CommentDTO selectComment(String comment_no) throws Exception {

        Connection con = getConnection();
        CommentDAO commentDAO = new CommentDAO(con);
        CommentDTO modifyComment = commentDAO.selectMyComment(comment_no);

        return modifyComment;
    }

    public boolean updateComment(String comment_no, String content) throws Exception {

        Connection con = getConnection();
        CommentDAO commentDAO = new CommentDAO(con);
        boolean isUpdateSuccess = false;

        int isUpdated = commentDAO.updateComment(comment_no, content);

        if(isUpdated != 0) {
            isUpdateSuccess = true;
            commit(con);
        }else {
            rollback(con);
        }

        return isUpdateSuccess;
    }
}
