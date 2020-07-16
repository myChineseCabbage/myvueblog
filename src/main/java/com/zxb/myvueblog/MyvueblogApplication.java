package com.zxb.myvueblog;

import com.zxb.myvueblog.utils.JwtUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyvueblogApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyvueblogApplication.class, args);
    }



//    @Bean
//    public JwtUtils jwtUtils(){
//        return  new JwtUtils();
//    }
}
