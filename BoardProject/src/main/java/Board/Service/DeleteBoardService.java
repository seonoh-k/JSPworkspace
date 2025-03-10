package Board.Service;

import Board.DAO.BoardDAO;

import java.sql.Connection;

import static Util.DBUtil.*;

public class DeleteBoardService {
    public boolean deleteBoard(String board_no) throws Exception {

        Connection con = getConnection();
        BoardDAO boardDAO = new BoardDAO(con);

        boolean isDeleteSuccess = false;
        int isDeleted = boardDAO.deleteBoard(board_no);

        if(isDeleted != 0) {
            isDeleteSuccess = true;
            commit(con);
        }else {
            rollback(con);
        }

        return isDeleteSuccess;
    }
}
