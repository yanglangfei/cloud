package com.yf.app.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    @ApiModelProperty("用户ID")
    private  Long id;
    @ApiModelProperty("用户名称")
    private  String name;
    @ApiModelProperty("用户年龄")
    private  Integer age;
}
