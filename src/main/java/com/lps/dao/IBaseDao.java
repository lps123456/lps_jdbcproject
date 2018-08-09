package com.lps.dao;

import com.lps.util.PageUtil;

import java.io.Serializable;
import java.util.List;

/**
 *所有接口的父接口
 * 所有接口的公共方法
 * @param <T>
 */
public interface IBaseDao<T> {

    int add(T t);
    int deleteByCondition(Serializable id);
    int update(T t);
    T findByCondition(Serializable id);
    List<T> findAll();
    int findRownum();
    List<T>  findAllByPage(PageUtil util, Object ...params);
}
