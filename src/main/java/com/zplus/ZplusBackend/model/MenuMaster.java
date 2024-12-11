package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class MenuMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    private String dishName;

    private Integer price;

    private String image;

    private String status;


}
