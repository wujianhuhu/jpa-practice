package com.example.jpapractice.service;

import com.example.jpapractice.entity.UserEntity;

import java.util.List;

/**
 * @author ：Ymwjhu
 * @version : 1.0
 * @date ：Created in 16:18 2018/9/28
 */
public interface UserService {

    /**
     * 通过id来查询数据
     * @param id 参数id
     * @return 返回通过id查询出来的结果
     */
    UserEntity findAllById(int id);

    /**
     * 查询表中所有数据
     *
     * @return 返回所有的数据
     */
    List<UserEntity> findAll();

    /**
     * 通过id删除数据
     *
     * @param id 参数id
     */
    void deleteOrderById(int id);

    /**
     * 通过id确认数据，并修改其telephone的值
     *
     * @param telephone 修改后的telephone
     * @param id 参数id
     */
    void updateTelephoneById(String telephone, int id);

    /**
     * 这是用来联表查询的尝试
     *
     * @param id 参数id
     */
    void updateTelephoneByBusStationById(int id);
}
