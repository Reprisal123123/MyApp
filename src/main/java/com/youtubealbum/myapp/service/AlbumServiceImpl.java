package com.youtubealbum.myapp.service;

import com.youtubealbum.myapp.dao.AlbumDao;
import com.youtubealbum.myapp.domain.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDao albumDao;

    // 앨범 쓰기
    @Override
    public int write(AlbumDto dto) throws Exception {
        return albumDao.insert(dto);
    }

    // 앨범 목록 가져오기
    @Override
    public List<AlbumDto> getList(String writer) throws Exception {
        return albumDao.selectAll(writer);
    }

    // 앨범 수정하기
    @Override
    public int modify(AlbumDto dto) throws Exception {
        return albumDao.update(dto);
    }

    // 앨범 하나 삭제하기
    @Override
    public int remove(Integer ano) throws Exception {
        return albumDao.delete(ano);
    }

    // 앨범 전체 삭제하기
    @Override
    public int removeAll() throws Exception {
        return albumDao.deleteAll();
    }

    public int count() throws Exception {
        return albumDao.count();
    }

}
