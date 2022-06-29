package com.youtubealbum.myapp.service;

import com.youtubealbum.myapp.dao.UserDao;
import com.youtubealbum.myapp.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int registerUser(UserDto userDto) throws Exception {
        return userDao.insertUser(userDto);
    }

    @Override
    public UserDto selectUser(String id) throws Exception {
        return userDao.selectUser(id);
    }

    @Override
    public int updateUser(UserDto userDto) throws Exception {
        return userDao.updateUser(userDto);
    }

    @Override
    public int deleteUser(String pwd) throws Exception {
        return userDao.deleteUser(pwd);
    }

    @Override
    public int deleteAllUser() throws Exception {
        return userDao.deleteAllUser();
    }
}
