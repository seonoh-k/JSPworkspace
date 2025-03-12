package Comment.Service;

import Comment.DAO.CommentDAO;

import java.sql.Connection;

import static Util.DBUtil.*;
public class DeleteCommentService {
    public boolean deleteComment(String comment_no) throws Exception {

        Connection con = getConnection();
        CommentDAO commentDAO = new CommentDAO(con);

        boolean isDeleteSuccess = false;
        int isDeleted = commentDAO.deleteComment(comment_no);

        if(isDeleted != 0) {
            isDeleteSuccess = true;
            commit(con);
        }else {
            rollback(con);
        }

        return isDeleteSuccess;
    }
}
