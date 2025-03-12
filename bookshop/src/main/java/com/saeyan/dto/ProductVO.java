package com.saeyan.dto;

import lombok.Data;

@Data
public class ProductVO {
    private int code;
    private String name;
    private int price;
    private String pictureUrl;
    private String description;
}
