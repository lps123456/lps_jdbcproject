package com.lps.dao.users;

import com.lps.dao.IBaseDao;
import com.lps.entity.Users;


public interface UserDao extends IBaseDao<Users>{
    /**
     * 只需要写自己特有的方法就可以了  比如用户登陆功能
     */

    String validateName (String userName);
    /**
     * 登陆验证
     */
    Users login(String userName, String pawssword);
}
