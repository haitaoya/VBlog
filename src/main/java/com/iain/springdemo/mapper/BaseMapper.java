package com.iain.springdemo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname BaseMapper
 * @Description TODO
 * @Date 2020/8/26 12:39 下午
 * @Created by wht
 */
public interface BaseMapper<T> {
    List<T> findAll();
    int insertOne(T row);
    List<T> findByMap(Map<String,Object> args);
    int update(T row);
    int deleteByPk(@Param("pkId") String pkId);
    int insertList(List<T> rows);
}
