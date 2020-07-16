package com.zxb.myvueblog.controller;


import cn.hutool.crypto.SecureUtil;
import com.zxb.myvueblog.common.Result;
import com.zxb.myvueblog.entity.User;
import com.zxb.myvueblog.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-06-04
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userServiceImpl;

    /**
     * @RequiresAuthentication 此注解指出需要通过认证才能访问
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
        User user = userServiceImpl.getById(1L);
        return  Result.succ(user);
    }

    @GetMapping("/save")
    public Result save(@Validated @RequestBody User user){

        //查询是否有重名的

        user.setPassword(SecureUtil.md5(user.getPassword()));
        userServiceImpl.save(user);
        return  Result.succ(user);
    }
}
