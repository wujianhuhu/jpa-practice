package com.example.jpapractice.controller;

import com.example.jpapractice.entity.UserEntity;
import com.example.jpapractice.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Ymwjhu
 * @version : 1.0
 * @date ：Created in 14:51 2018/9/28
 */
@RestController
public class Main {

    @Resource
    private UserService userService;

    /**
     * 这是最普通的url的方式
     * localhost:8080/printFindAll
     */
    @RequestMapping("/printFindAll")
    public List<UserEntity> printFindAll(){
        return userService.findAll();
    }

    /**
     * 这种方式是采用@RequestParam
     * localhost:8080/printFindAllById?id=2
     */
    @RequestMapping("/printFindAllById")
    public UserEntity printFindAllById(@RequestParam("id") int id){
        return userService.findAllById(id);
    }

    /**
     * 采用@PathVariable
     * localhost:8080/printDeleteById/2
     */
    @RequestMapping("/printDeleteById/{id}")
    public List<UserEntity> printDeleteById(@PathVariable("id") int id){
        userService.deleteOrderById(id);
        return userService.findAll();
    }

    /**
     * 混合@PathVariable和@RequestParam
     * localhost:8080/printUpdateTelephoneById/17825465874?id=2
     */
    @RequestMapping("/printUpdateTelephoneById/{telephone}")
    public UserEntity printUpdateTelephoneById(@PathVariable("telephone") String telephone, @RequestParam("id") int id){
        userService.updateTelephoneById(telephone, id);
        return userService.findAllById(id);
    }

}
