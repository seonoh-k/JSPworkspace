package board.vo;

import lombok.Data;

@Data
public class User {

    private int user_id;
    private String user_email;
    private String user_name;
    private String  user_pass;
    private String  user_gender;
    private String user_birth;

}