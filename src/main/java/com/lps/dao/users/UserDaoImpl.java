package com.lps.dao.users;

import com.lps.entity.Users;
import com.lps.util.BaseDaoUtil;
import com.lps.util.PageUtil;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl extends BaseDaoUtil implements UserDao {
    @Override
    public int add(Users users) {
        String sql="INSERT INTO news_user(userName,`upwd`,email,userType) VALUES(?,?,?,?)";
        Object[] params={users.getUserName(),users.getPasssword(),users.getEmail(),users.getUserType()};
        return executeUpdate(sql,params);
    }

    public int executeUpdate(String sql, Object[] params) {
        return 0;
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

    @Override
    public String validateName(String userName) {
        String sql = "SELECT `passWord` FROM news_userinfo WHERE userName=?";
        ResultSet rs =executeQuery(sql,userName);
        System.out.println(userName+sql);
        String password = null;
        try { //获取密码
            if (rs.next()) {
                password = rs.getString("passWord");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public Users login(String userName, String pawssword) {
        return null;
    }
}
