package com.yf.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysRole implements Serializable {

    private  Long id;

    private  String name;

    private  String role;

    private List<SysPermission> permissions;

}
