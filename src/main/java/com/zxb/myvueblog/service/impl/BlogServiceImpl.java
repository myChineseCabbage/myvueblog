package com.zxb.myvueblog.service.impl;

import com.zxb.myvueblog.entity.Blog;
import com.zxb.myvueblog.mapper.BlogMapper;
import com.zxb.myvueblog.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-04
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
