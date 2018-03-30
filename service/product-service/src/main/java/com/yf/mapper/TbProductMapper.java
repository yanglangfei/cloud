package com.yf.mapper;

import com.yf.lib.mapper.BaseMapper;
import com.yf.model.TbProduct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@CacheConfig(cacheNames = "AllProduct")
public interface TbProductMapper extends BaseMapper<TbProduct> {


    //先从缓存中查询，如果没有则查询数据库
    @Override
    @Cacheable(key = "findAll")
    List<TbProduct> findAll();


    //更新缓存
    @CachePut(key = "findAll")
    Integer update(Map<String,Object> param);

    //清空缓存
    @Override
    @CacheEvict(key = "findAll")
    Integer delete(Long id);
}
