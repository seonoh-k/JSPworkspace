package com.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
public class User {

    private int user_id;
    private String  user_pass;
    private String user_name;
    private String user_email;
    private String  user_gender;
    private Date user_birth;

    public User(int user_id, String user_pass, String user_name, String user_email, String user_gender, Date user_birth) {

        super();
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_gender = user_gender;
        this.user_birth = user_birth;
    }

    public String toString() {
        return user_id + " " + user_pass + " " + user_name + " " + user_email + " " + user_gender + " " + user_birth;
    }
}