package Board.Service;

import Board.DAO.BoardDAO;
import Board.DTO.BoardDetailDTO;

import java.sql.Connection;
import java.util.ArrayList;

import static Util.DBUtil.*;
public class ShowBoardDetailService{
    public ArrayList<BoardDetailDTO> selectBoardDetail (String board_no) throws Exception {

        Connection con = getConnection();
        ArrayList<BoardDetailDTO> boardDetailList = null;
        BoardDAO boardDAO = new BoardDAO(con);

        boardDetailList = boardDAO.selectBoardDetailList(board_no);

        return boardDetailList;
    }
}
