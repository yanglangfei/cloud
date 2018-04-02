package com.yf.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfo  implements Serializable{
    private List<SysRole> roleList;

    private  int status;

    private  String userName;

    private  String password;

    private  String credentialsSalt;

}
