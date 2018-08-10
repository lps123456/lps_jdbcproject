package com.lps.service.user;

import com.lps.entity.Users;
import com.lps.service.IUserService;


public interface UserService extends IUserService<Users> {
    /**
     *重写验证用户名的方法
     *
     */
    String  validateName(String username);
    /**
     *登录时的
     */
    Users login(String username,String password);
}
