package Board.Service;

import Board.DAO.BoardDAO;
import Board.DTO.BoardDTO;

import java.sql.Connection;

import static Util.DBUtil.*;
public class UpdateBoardService {
    public BoardDTO selectMyBoard(String board_no) throws Exception {

        Connection con = getConnection();
        BoardDAO boardDAO = new BoardDAO(con);
        BoardDTO modifyBoard = boardDAO.selectMyBoard(board_no);

        return modifyBoard;
    }

    public boolean updateBoard(String title, String content, String board_no) {

        boolean isUpdatesuccess = false;
        Connection con = getConnection();
        BoardDAO boardDAO = new BoardDAO(con);

        int isModified = boardDAO.updateBoard(title, content, board_no);

        if(isModified != 0) {
            isUpdatesuccess = true;
            commit(con);
        }else {
            rollback(con);
        }

        return isUpdatesuccess;
    }
}
