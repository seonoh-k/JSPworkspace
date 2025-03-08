package Board.Service;

import Board.DAO.BoardDAO;
import Board.DTO.BoardDTO;

import java.sql.Connection;

import static Util.DBUtil.*;
public class WriteBoardService {

    public boolean writeBoard(BoardDTO newBoard) throws Exception {

        Connection con = getConnection();
        BoardDAO boardDAO = new BoardDAO(con);

        boolean isWriteSuccess = false;
        int isUploaded = boardDAO.insertBoard(newBoard);

        if(isUploaded != 0) {
            isWriteSuccess = true;
            commit(con);
        }else {
            rollback(con);
        }
        return isWriteSuccess;
    }
}
