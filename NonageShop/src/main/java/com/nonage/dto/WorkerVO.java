package com.nonage.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class WorkerVO {
    private String id;
    private String pwd;
    private String name;
    private String phone;
}
