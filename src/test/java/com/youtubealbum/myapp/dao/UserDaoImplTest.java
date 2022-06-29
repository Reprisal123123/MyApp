package com.youtubealbum.myapp.dao;

import com.youtubealbum.myapp.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    public void insertUserTest() throws Exception {

        for (int i = 1; i < 5; i++) {
            UserDto userDto = new UserDto("reprisal" + i, "1234", "kim", new Date(), "male", "aaa@aaa.com", "01012341234");
            int rowCnt = userDao.insertUser(userDto);
            assertTrue(rowCnt == 1);
        }
    }

    @Test
    public void selectUser() {

    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }
}