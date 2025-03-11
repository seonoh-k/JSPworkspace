package com.saeyan.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MemberVO {

    private String name;
    private String userid;
    private String pwd;
    private String email;
    private String phone;
    private int admin;

}