package com.nonage.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderVO {

    private int oseq;
    private String id;
    private Timestamp indate;
}
