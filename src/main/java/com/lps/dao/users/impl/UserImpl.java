package com.lps.dao.users.impl;

import com.lps.dao.users.UserDao;
import com.lps.entity.Users;
import com.lps.util.BaseDaoUtil;
import com.lps.util.PageUtil;
import com.lps.util.ResultSetUtil;


import java.io.Serializable;
import java.util.List;

public class UserImpl extends BaseDaoUtil implements UserDao {

    @Override
    public String validateName(String userName) {
        String sql = "SELECT password FROM news_user WHERE userName=?";
        rs =executeQuery(sql);
        String password = null;
        try { //获取密码
            if (rs.next()) {
                password = rs.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public Users login(String userName, String pawssword) {
        String sql="SELECT id as users_id,userName,PASSWORD,email,userType FROM news_user where userName=? and password=?";
        Object [] params={userName,pawssword};
        rs=executeQuery(sql,params);
        Users users= ResultSetUtil.eachOne(rs,Users.class);
        return users;
    }

    @Override
    public int add(Users users) {
        String sql="insert into news_user(username,password,email) values(?,?,?,?)";
        Object[] params={users.getUserName(),users.getPasssword(),users.getEmail(),users.getEmail()};

        return executeUpdate(sql,params);
    }

    @Override
    public int deleteByCondition(Serializable id) {
        return 0;
    }

    @Override
    public int update(Users users) {
        return 0;
    }

    @Override
    public Users findByCondition(Serializable id) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public int findRownum() {
        return 0;
    }

    @Override
    public List<Users> findAllByPage(PageUtil util, Object... params) {
        return null;
    }
}
