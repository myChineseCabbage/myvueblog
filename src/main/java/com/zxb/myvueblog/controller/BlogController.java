package com.zxb.myvueblog.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxb.myvueblog.common.Result;
import com.zxb.myvueblog.entity.Blog;
import com.zxb.myvueblog.service.IBlogService;
import com.zxb.myvueblog.utils.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-06-04
 */

@Slf4j
@RestController
@RequestMapping("/myvueblog/blog")
public class BlogController {


    @Autowired
    IBlogService blogServiceImpl;

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){

        Page page = new Page (currentPage,5);
        IPage<Blog> pageData = blogServiceImpl.page(page, new QueryWrapper<Blog>().orderByDesc("create_time"));

        return  Result.succ(pageData);
    }


    @GetMapping("/blog/{id}")
    public  Result detail(@PathVariable(name = "id") long id){
        Blog blog = blogServiceImpl.getById(id);
        Assert.notNull(blog,"该博客已经被删除");
        return  Result.succ(blog);
    }


    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public  Result edit(@Validated @RequestBody Blog blog){

        Blog temp = null;
        if(blog.getId()!=null){
            //编辑的状态
            temp = blogServiceImpl.getById(blog.getId());
            //只能编辑自己的文章
            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getPtofile().getId().longValue(),"你没有权限编辑");
        }else{
            temp = new Blog();
            temp.setUserId(ShiroUtil.getPtofile().getId());
            temp.setCreateTime(LocalDateTime.now());
            temp.setStatus(0);
        }

        BeanUtil.copyProperties(blog,temp,"id","userId","createTime","status");
        blogServiceImpl.saveOrUpdate(temp);
        return  Result.succ(null);
    }
}
