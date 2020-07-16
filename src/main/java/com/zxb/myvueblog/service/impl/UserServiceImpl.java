package com.zxb.myvueblog.service.impl;

import com.zxb.myvueblog.entity.User;
import com.zxb.myvueblog.mapper.UserMapper;
import com.zxb.myvueblog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}
