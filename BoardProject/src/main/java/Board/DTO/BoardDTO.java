package Board.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BoardDTO {

    private int board_no;
    private int user_no;
    private String title;
    private String content;
    private Timestamp create_at;
    private Timestamp update_at;
    private Timestamp delete_at;
    private String user_id;

    public BoardDTO(int board_no, int user_no, String title, String content, Timestamp create_at, Timestamp update_at, Timestamp delete_at) {
        super();
        this.user_no = user_no;
        this.title = title;
        this.content = content;
        this.create_at = create_at;
        this.update_at = update_at;
        this.delete_at = delete_at;
    }
    public BoardDTO(int board_no, int user_no, String title, Timestamp create_at, Timestamp update_at, String user_id) {
        super();
        this.user_no = user_no;
        this.title = title;
        this.create_at = create_at;
        this.update_at = update_at;
        this.user_id = user_id;
    }
    public BoardDTO(int user_no, String title, String content) {
        super();
        this.user_no = user_no;
        this.title = title;
        this.content = content;
    }
}
