package com.yf.search.model;

import com.esotericsoftware.kryo.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 *   indexName  相当于 mysql 的 database
 *   type       相当于 Table
 *   Document   相当于   row
 *   @Id注解加上后，在Elasticsearch里相应于该列就是主键了，在查询时就可以直接用主键查询
 *   refreshInterval  刷新间隔  默认 5s
 *   加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词
 *
 */
@Data
@Document(indexName = "users", type = "userInfo",refreshInterval = "1s")
public class UserInfo implements Serializable{
    @Id
    @NotNull
    private String id;

    @NotNull
    private String userName;

    @NotNull
    private String email;


}
