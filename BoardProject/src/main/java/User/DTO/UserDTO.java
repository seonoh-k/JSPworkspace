package User.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UserDTO {

    private int user_no;
    private String user_id;
    private String user_pass;
    private String user_email;
    private String user_name;
    private String user_gender;
    private Date user_birth;

    public UserDTO(String user_id, String user_email, String user_name, String user_pass, String user_gender, Date user_birth) {

        super();
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_email = user_email;
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_birth = user_birth;
    }
}