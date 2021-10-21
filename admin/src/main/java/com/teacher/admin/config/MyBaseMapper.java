package com.teacher.admin.config;


import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/***
 *@author : Ray
 *@date :  2021/1/23 22:06
 *description: base mapper
 ***/
public interface MyBaseMapper<T> extends Mapper<T> ,IdsMapper<T>, InsertListMapper<T> {
}
