package com.yf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private  Long id;

    private  String userName;

    private  String password;

    private  Double salary;

    private Date birthday;

    private String gender;

    private  String station;

    private  String telPhone;

    private String remark;
}
