package com.youtubealbum.myapp.service;

import com.youtubealbum.myapp.dao.AlbumDao;
import com.youtubealbum.myapp.domain.AlbumDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AlbumServiceImplTest {

    @Autowired
    AlbumDao albumDao;


    @Test
    public void write() throws Exception {
        albumDao.deleteAll();
        assertTrue(albumDao.count()==0);

        AlbumDto dto = new AlbumDto("테스트 중입니다.", "kDi0dGmedmM", "reprisal123", "잘 되나?");
        System.out.println("dto = " + dto);
        assertTrue(albumDao.insert(dto)==1);
        assertTrue(albumDao.count()==1);

        dto = new AlbumDto("테스트 중입니다.", "OtYV-AywbRM", "reprisal123", "잘 되나?");
        System.out.println("dto = " + dto);
        assertTrue(albumDao.insert(dto)==1);
        assertTrue(albumDao.count()==2);
    }

    @Test
    public void getList() throws Exception {
        List<AlbumDto> list = albumDao.selectAll("reprisal123");
        for(AlbumDto dto : list) {
            System.out.println("dto = " + dto);
        }
    }

    @Test
    public void modify() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void removeAllTest() throws Exception {

        albumDao.deleteAll();
        assertTrue(albumDao.count()==0);

        AlbumDto dto = new AlbumDto("테스트 중입니다.", "https://youtu.be/kDi0dGmedmM", "reprisal123", "잘 되나?");
        assertTrue(albumDao.insert(dto)==1);
        assertTrue(albumDao.deleteAll()==1);
        assertTrue(albumDao.count()==0);

        dto = new AlbumDto("테스트 중입니다.", "https://youtu.be/kDi0dGmedmM", "reprisal123", "잘 되나?");
        assertTrue(albumDao.insert(dto)==1);
        assertTrue(albumDao.insert(dto)==1);
        assertTrue(albumDao.deleteAll()==2);
        assertTrue(albumDao.count()==0);

    }
}