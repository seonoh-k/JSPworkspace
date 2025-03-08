package Board.DAO;

import Board.DTO.BoardDTO;
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
}
