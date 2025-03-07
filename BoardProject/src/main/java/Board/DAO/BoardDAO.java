package Board.DAO;

import Board.DTO.BoardDTO;
import User.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDAO {

    Connection con;

    public BoardDAO(Connection con) {
        this.con = con;
    }

    public int insertBoard(BoardDTO newBoard) throws Exception{

        String sql = "INSERT INTO BOARDS VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (PreparedStatement psmt = con.prepareStatement(sql)) {

            psmt.setInt(1, newBoard.getUser_no());
            psmt.setString(2, newBoard.getTitle());
            psmt.setString(3, newBoard.getContent());
            psmt.setTimestamp(4, newBoard.getCreate_at());
            psmt.setTimestamp(5, newBoard.getUpdate_at());
            psmt.setTimestamp(6, newBoard.getDelete_at());


            result = psmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
