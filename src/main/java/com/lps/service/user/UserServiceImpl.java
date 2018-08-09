package com.lps.service.user;


import com.lps.dao.users.UserDao;
import com.lps.dao.users.UserDaoImpl;
import com.lps.entity.Users;
import com.lps.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();
    @Override
    public int add(Users users) {
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
}
