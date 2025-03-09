package Board.DAO;

import Board.DTO.BoardDTO;
import Board.DTO.BoardDetailDTO;
import User.DTO.UserDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BoardDAO {

    Connection con;

    public BoardDAO(Connection con) {
        this.con = con;
    }

    public int insertBoard(BoardDTO newBoard) throws Exception{

        String sql = "INSERT INTO BOARDS VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, newBoard.getUser_no());
            psmt.setString(2, newBoard.getTitle());
            psmt.setString(3, newBoard.getContent());
            psmt.setTimestamp(4, timestamp);
            psmt.setTimestamp(5, null);
            psmt.setTimestamp(6, null);


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<BoardDTO> selectBoardList() throws Exception{

        String sql = "SELECT BOARD_NO, USER_NO, TITLE, CREATE_AT, UPDATE_AT, USER_ID " +
                "FROM BOARDS JOIN USERS USING (USER_NO)";
        BoardDTO newBoard = null;
        ArrayList<BoardDTO> boardList = new ArrayList<>();

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            try (ResultSet rs = psmt.executeQuery()) {
                while(rs.next()) {
                    int board_no = rs.getInt("BOARD_NO");
                    int user_no = rs.getInt("USER_NO");
                    String title = rs.getString("TITLE");
                    Timestamp create_at = rs.getTimestamp("CREATE_AT");
                    Timestamp update_at = rs.getTimestamp("UPDATE_AT");
                    String user_id = rs.getString("USER_ID");

                    newBoard = new BoardDTO(board_no, user_no, title, create_at, update_at, user_id);
                    boardList.add(newBoard);
                }
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return boardList;
    }

    public ArrayList<BoardDTO> selectMyBoardList(int user_no) throws Exception{

        String sql = "SELECT BOARD_NO, USER_NO, TITLE, CREATE_AT, UPDATE_AT, USER_ID " +
                "FROM BOARDS JOIN USERS USING (USER_NO) WHERE USER_NO = ?";
        BoardDTO newBoard = null;
        ArrayList<BoardDTO> boardList = new ArrayList<>();

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, user_no);
            try (ResultSet rs = psmt.executeQuery()) {
                while(rs.next()) {
                    int board_no = rs.getInt("BOARD_NO");
                    int userNo = rs.getInt("USER_NO");
                    String title = rs.getString("TITLE");
                    Timestamp create_at = rs.getTimestamp("CREATE_AT");
                    Timestamp update_at = rs.getTimestamp("UPDATE_AT");
                    String user_id = rs.getString("USER_ID");

                    newBoard = new BoardDTO(board_no, user_no, title, create_at, update_at, user_id);
                    boardList.add(newBoard);
                }
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return boardList;
    }

    public ArrayList<BoardDetailDTO> selectBoardDetailList(int board_no) {

        String sql = "SELECT C.COMMENT_NO, B.BOARD_NO, U2.USER_ID AS B_USER_ID, U1.USER_ID AS C_USER_ID, B.TITLE, " +
                "B.CONTENT AS B_CONTENT, C.CONTENT AS C_CONTENT, " +
                "B.CREATE_AT AS B_CREATE_AT, B.UPDATE_AT AS B_UPDATE_AT, " +
                "C.CREATE_AT AS C_CREATE_AT, C.UPDATE_AT AS C_UPDATE_AT, " +
                "C.DELETE_AT AS C_DELETE_AT, C.REF " +
                "FROM BOARDS B " +
                "LEFT JOIN COMMENTS C ON B.BOARD_NO = C.BOARD_NO " +
                "LEFT JOIN USERS U1 ON C.USER_NO = U1.USER_NO " +
                "LEFT JOIN USERS U2 ON B.USER_NO = U2.USER_NO " +
                "WHERE B.BOARD_NO = ?";
        BoardDetailDTO boardDetail = null;
        ArrayList<BoardDetailDTO> boardDetailList = new ArrayList<>();

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, board_no);

            try (ResultSet rs = psmt.executeQuery()) {
                while(rs.next()) {
                    int comment_no = rs.getInt("COMMENT_NO");
                    int boardNo = rs.getInt("BOARD_NO");
                    String b_user_id = rs.getString("B_USER_ID");
                    String c_user_id = rs.getString("C_USER_ID");
                    String title = rs.getString("TITLE");
                    String b_content = rs.getString("B_CONTENT");
                    String c_content = rs.getString("C_CONTENT");
                    Timestamp b_create_at = rs.getTimestamp("B_CREATE_AT");
                    Timestamp b_update_at = rs.getTimestamp("B_UPDATE_AT");
                    Timestamp c_create_at = rs.getTimestamp("C_CREATE_AT");
                    Timestamp c_update_at = rs.getTimestamp("C_UPDATE_AT");
                    Timestamp c_delete_at = rs.getTimestamp("C_DELETE_AT");
                    int ref = rs.getInt("REF");

                    boardDetail = new BoardDetailDTO(comment_no, board_no, b_user_id, c_user_id, title, b_content, c_content, b_create_at, b_update_at, c_create_at, c_update_at, c_delete_at, ref);
                    boardDetailList.add(boardDetail);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return boardDetailList;
    }
}