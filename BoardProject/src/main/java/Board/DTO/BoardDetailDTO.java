package Board.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BoardDetailDTO {

    private int comment_no;
    private int board_no;
    private String b_user_id;
    private String c_user_id;
    private String title;
    private String b_content;
    private String c_content;
    private Timestamp b_create_at;
    private Timestamp b_update_at;
    private Timestamp c_create_at;
    private Timestamp c_update_at;
    private Timestamp c_delete_at;
    private int ref;

    public BoardDetailDTO(int comment_no, int board_no, String b_user_id, String c_user_id, String title, String b_content, String c_content,
                          Timestamp b_create_at, Timestamp b_update_at, Timestamp c_create_at, Timestamp c_update_at, Timestamp c_delete_at, int ref) {
        super();
        this.comment_no = comment_no;
        this.board_no = board_no;
        this.b_user_id = b_user_id;
        this.c_user_id = c_user_id;
        this.title = title;
        this.b_content = b_content;
        this.c_content = c_content;
        this.b_create_at = b_create_at;
        this.b_update_at = b_update_at;
        this.c_create_at = c_create_at;
        this.c_update_at = c_update_at;
        this.c_delete_at = c_delete_at;
        this.ref = ref;
    }
}
