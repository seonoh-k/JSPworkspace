package Comment.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CommentDTO {

    private int comment_no;
    private int user_no;
    private int board_no;
    private String content;
    private Timestamp create_at;
    private Timestamp update_at;
    private Timestamp delete_at;
    private int ref;
    private String user_id;

    public CommentDTO(int user_no, int board_no, String content, Timestamp create_at, Timestamp update_at, Timestamp delete_at, int ref) {
        super();
        this.board_no = board_no;
        this.user_no = user_no;
        this.content = content;
        this.create_at = create_at;
        this.update_at = update_at;
        this.delete_at = delete_at;
        this.ref = ref;
    }

    public CommentDTO(int board_no, String content,Timestamp create_at, Timestamp update_at, String user_id) {
        super();
        this.board_no = board_no;
        this.content = content;
        this.create_at = create_at;
        this.update_at = update_at;
        this.user_id = user_id;
    }

    public CommentDTO(int board_no, int comment_no, String content) {
        super();
        this.board_no = board_no;
        this.comment_no = comment_no;
        this.content = content;
    }
}
