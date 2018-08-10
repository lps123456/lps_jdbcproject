package com.lps.util;

import com.lps.entity.Users;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetUtil {
    public ResultSetUtil(ResultSet rs, Class<Users> usersClass) {
    }

    public static <T> T eachOne(ResultSet rs, Class<T> userClass) {
        return null;
    }
}
