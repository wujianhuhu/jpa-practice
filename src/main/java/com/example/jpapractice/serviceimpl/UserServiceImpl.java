package com.example.jpapractice.serviceimpl;

import com.example.jpapractice.entity.UserEntity;
import com.example.jpapractice.repository.UserRepository;
import com.example.jpapractice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Ymwjhu
 * @version : 1.0
 * @date ：Created in 16:22 2018/9/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity findAllById(int id) {
        return userRepository.findAllById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteOrderById(int id) {
        userRepository.deleteOrderById(id);
    }

    @Override
    public void updateTelephoneById(String telephone, int id) {
        userRepository.updataTelephoneById(telephone, id);
    }

    @Override
    public void updateTelephoneByBusStationById(int id) {
        userRepository.updateTelephoneByBusStationById(id);
    }
}
