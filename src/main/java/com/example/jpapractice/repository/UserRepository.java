package com.example.jpapractice.repository;

import com.example.jpapractice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ：Ymwjhu
 * @version : 1.0
 * @date ：Created in 16:13 2018/9/28
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * 通过id来查询user表中的数据
     *
     * @param id 参数id
     * @return 返回通过id查询出来的实体
     */
    UserEntity findAllById (int id);

    /**
     * 查询所有的数据
     *
     * @return 返回表中所有的数据
     */
    @Override
    List<UserEntity> findAll();

    /**
     * 利用原始的sql语句进行对指定id数据的删除
     *
     * @param id 参数id
     *
     * 这种方式是使用@Param方式，采用的是:id,然后和Param中的名字一致
     */
    @Query(value = "delete from user where user.id = :id ", nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    void deleteOrderById(@Param("id") int id);

    /**
     * 通过id来改变这条数据中的电话号码
     *
     * @param telephone 需要改变的电话号码
     * @param id 参数id
     *
     * 这里的参数采用了?1,?2这样的方式，直接对应第几个参数
     */
    @Query(value = "update user set user.telephone = ?1 where user.id = ?2", nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    void updataTelephoneById(String telephone, int id);

    /**
     * 这是用来进行一次联表查询的
     *
     * @param id 参数id
     */
    @Query(value = "update user set user.telephone = (select name from bus_station where bus_station.id = 1094201500) where user.id = ?1", nativeQuery = true)
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    void updateTelephoneByBusStationById(int id);

}
