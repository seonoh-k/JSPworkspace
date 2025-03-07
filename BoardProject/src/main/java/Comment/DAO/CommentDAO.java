package Comment.DAO;

import Board.DTO.BoardDTO;
import Comment.DTO.CommentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDAO {

    Connection con;

    public CommentDAO(Connection con) {
        this.con = con;
    }

    public int insertComment(CommentDTO newComment) throws Exception{

        String sql = "INSERT INTO COMMENTS VALUES (COMMENT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, newComment.getUser_no());
            psmt.setInt(2, newComment.getBoard_no());
            psmt.setString(3, newComment.getContent());
            psmt.setTimestamp(4, newComment.getCreate_at());
            psmt.setTimestamp(5, newComment.getUpdate_at());
            psmt.setTimestamp(6, newComment.getDelete_at());
            psmt.setInt(7, newComment.getRef());


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
