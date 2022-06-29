package com.youtubealbum.myapp.dao;

import com.youtubealbum.myapp.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession session;

    private String namespace = "com.youtubealbum.myapp.dao.UserMapper.";

    @Override
    public int insertUser(UserDto userDto) throws Exception {
        return session.insert(namespace + "insert", userDto);
    }

    @Override
    public UserDto selectUser(String id) throws Exception {
        return session.selectOne(namespace + "select", id);
    }

    @Override
    public int updateUser(UserDto userDto) throws Exception {
        return session.update(namespace + "update", userDto);
    }

    @Override
    public int deleteUser(String pwd) throws Exception {
        return session.delete(namespace + "delete", pwd);
    }

    @Override
    public int deleteAllUser() throws Exception {
        return session.delete(namespace+"deleteAll");
    }
}
