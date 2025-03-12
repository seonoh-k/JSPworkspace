package Comment.DAO;

import Board.DTO.BoardDTO;
import Comment.DTO.CommentDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommentDAO {

    Connection con;

    public CommentDAO(Connection con) {
        this.con = con;
    }

    public int insertComment(String user_no, String board_no, String content) throws Exception{

        String sql = "INSERT INTO COMMENTS VALUES (COMMENT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        int result = 0;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, Integer.parseInt(user_no));
            psmt.setInt(2, Integer.parseInt(board_no));
            psmt.setString(3, content);
            psmt.setTimestamp(4, timestamp);
            psmt.setTimestamp(5, null);
            psmt.setTimestamp(6, null);
            psmt.setNull(7, Types.INTEGER);


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int insertCoComment(String user_no, String board_no, String content, String comment_no) throws Exception{

        String sql = "INSERT INTO COMMENTS VALUES (COMMENT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        int result = 0;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, Integer.parseInt(user_no));
            psmt.setInt(2, Integer.parseInt(board_no));
            psmt.setString(3, content);
            psmt.setTimestamp(4, timestamp);
            psmt.setTimestamp(5, null);
            psmt.setTimestamp(6, null);
            psmt.setInt(7, Integer.parseInt(comment_no));


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<CommentDTO> selectMyCommentList(int user_no) throws Exception{

        String sql = "SELECT BOARD_NO, CONTENT, CREATE_AT, UPDATE_AT, USER_ID " +
                "FROM COMMENTS JOIN USERS USING (USER_NO) WHERE USER_NO = ?";
        CommentDTO newComment = null;
        ArrayList<CommentDTO> commentList = new ArrayList<>();

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, user_no);
            try (ResultSet rs = psmt.executeQuery()) {
                while(rs.next()) {
                    int board_no = rs.getInt("BOARD_NO");
                    String content = rs.getString("CONTENT");
                    Timestamp create_at = rs.getTimestamp("CREATE_AT");
                    Timestamp update_at = rs.getTimestamp("UPDATE_AT");
                    String user_id = rs.getString("USER_ID");

                    newComment = new CommentDTO(board_no, content, create_at, update_at, user_id);
                    commentList.add(newComment);
                }
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }

    public CommentDTO selectMyComment(String comment_no) throws Exception {

        String sql = "SELECT * FROM COMMENTS WHERE COMMENT_NO = ?";
        CommentDTO modifyComment = null;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, Integer.parseInt(comment_no));

            try (ResultSet rs = psmt.executeQuery()) {

                if(rs.next()) {
                    int boardNo = rs.getInt("BOARD_NO");
                    int commentNo = rs.getInt("COMMENT_NO");
                    String content = rs.getString("CONTENT");

                    modifyComment = new CommentDTO(boardNo, commentNo, content);
                }
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return modifyComment;
    }

    public int updateComment(String comment_no, String content) throws Exception {

        String sql = "UPDATE COMMENTS SET CONTENT = ?, UPDATE_AT = ? WHERE COMMENT_NO = ?";
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        int result = 0;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setString(1, content);
            psmt.setTimestamp(2, timestamp);
            psmt.setInt(3, Integer.parseInt(comment_no));

            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int deleteComment(String comment_no) throws Exception {

        String sql = "DELETE COMMENTS WHERE COMMENT_NO = ?";
        int result = 0;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, Integer.parseInt(comment_no));

            result = psmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
