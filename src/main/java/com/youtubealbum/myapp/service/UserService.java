package com.youtubealbum.myapp.service;

import com.youtubealbum.myapp.domain.UserDto;

public interface UserService {
    int registerUser(UserDto userDto) throws Exception;

    UserDto selectUser(String id) throws Exception;

    int updateUser(UserDto userDto) throws Exception;

    int deleteUser(String pwd) throws Exception;

    int deleteAllUser() throws Exception;
}
