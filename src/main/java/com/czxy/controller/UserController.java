package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<String> login(User user, HttpServletRequest request){
        User login = userService.login(user);
        if (login==null){
            return ResponseEntity.ok("账号或密码错误!");
        }
        request.getSession().setAttribute("user",login);
        return ResponseEntity.ok("登陆成功");
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(){
        System.out.println("添加功能。。。。");
        return new ResponseEntity<>("add",HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<String> update(){
        System.out.println("修改功能。。。。");
        return new ResponseEntity<>("update",HttpStatus.CREATED);
    }
    @PostMapping("/del")
    public ResponseEntity<String> del(){
        System.out.println("删除功能。。。。");
        return new ResponseEntity<>("del",HttpStatus.CREATED);
    }
}
