package Board.Service;

import Board.DAO.BoardDAO;
import Board.DTO.BoardDTO;

import java.sql.Connection;
import java.util.ArrayList;

import static Util.DBUtil.*;
public class ShowBoardListService {

    public ArrayList<BoardDTO> selectBoardList() throws Exception {

        Connection con = getConnection();
        BoardDAO boardDAO = new BoardDAO(con);

        ArrayList<BoardDTO> boardList = boardDAO.selectBoardList();

        return boardList;
    }
    public ArrayList<BoardDTO> selectMyBoardList(int user_no) throws Exception {

        Connection con = getConnection();
        BoardDAO boardDAO = new BoardDAO(con);

        ArrayList<BoardDTO> boardList = boardDAO.selectMyBoardList(user_no);

        return boardList;
    }
}