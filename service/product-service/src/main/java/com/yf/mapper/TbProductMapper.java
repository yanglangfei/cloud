package com.yf.mapper;

import com.yf.lib.mapper.BaseMapper;
import com.yf.model.TbProduct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "AllProduct")
public interface TbProductMapper extends BaseMapper<TbProduct> {


    @Override
    @Cacheable
    List<TbProduct> findAll();
}
