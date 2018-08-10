package com.lps.web;

import com.lps.entity.Users;
import com.lps.service.ServiceFactory;
import com.lps.service.user.UserService;
import com.lps.util.Md5Encrypt;
import com.lps.util.ResultUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class UserServlet extends BaseServlet {
    //不实例化service对象  让工厂实例化
    private ResultUtil util=new ResultUtil();
    private UserService userService;

    @Override
    public Class getServletClass() {

        return UserServlet.class;
    }
    @Override
    public void init() {
        userService=(UserService) ServiceFactory.getServiceImpl("UserService");
    }

    public String login(HttpServletRequest req, HttpServletResponse resp) {
        //拿到页面的登录信息
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        //get到扥到的用户名
        String  passwordDB =userService.validateName(userName);
        //判断如果数据库的用户名是否存在来判断是否执行以下代码
        if(passwordDB==null){
            try {
                //判断输入的密码和数据库的密文密码是否一样执行登录
                if(Md5Encrypt.validPassword(password,passwordDB)){
                    //拿到user的实例的值
                    Users user=userService.login(userName,passwordDB);
                    req.getSession().setAttribute("loginUser",user);
                    return "main";


                }else {
                    System.out.println("密码错误");
                }

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


        }else{
            //错误
            util.resultFail("用户名不存在");
        }

        //userService.login(userName,password);

        return "login";
    }

    /**
     * 注册
     */
    public String register(HttpServletRequest req, HttpServletResponse resp){
//获取用户输入的参数
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        //创建出User类的实体来

        Users users=new Users();
        users.setUserName(userName);
        try {
            //调用MD5接口给密码加密
            users.setPasssword(Md5Encrypt.getEncryptedPwd(password));
            System.out.println(users.getPasssword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        users.setUserType(0);  //设置用户类型
        int num= userService.add(users);
        if (num>0){
            return  "main";
        }else{
            return "register";
        }

    }

    /**
     * ajax对前台传过来的用户的验证
     * @param req
     * @param resp
     * @return
     */
    public ResultUtil validateName(HttpServletRequest req, HttpServletResponse resp){
        //System.out.println("=========================");
        String  userName=req.getParameter("username");
        System.out.println(userName+"=-=-=-=opopo");
        //调用service的方法
        String passwordDB=userService.validateName(userName);
        System.out.println(passwordDB);
        if(passwordDB==null){
            //验证的用户名不存在也就是说没有这个用户
            //n那么就可以注册用户
            util.resultUtilsuccess();
        }else {
            util.resultFail("昵称已经被注册了亲！！！！");
        }
        return util;
    }


}
