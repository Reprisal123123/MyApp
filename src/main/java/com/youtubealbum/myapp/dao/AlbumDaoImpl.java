package com.youtubealbum.myapp.dao;

import com.youtubealbum.myapp.domain.AlbumDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumDaoImpl implements AlbumDao {

    @Autowired
    SqlSession session;

    private String namespace = "com.youtubealbum.myapp.dao.AlbumMapper.";

    @Override
    public int insert(AlbumDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public AlbumDto select(Integer ano) throws Exception {
        return session.selectOne(namespace + "select", ano);
    }

    @Override
    public List<AlbumDto> selectAll(String writer) throws Exception {
        return session.selectList(namespace + "selectAll", writer);
    }

    @Override
    public int update(AlbumDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    @Override
    public int delete(Integer ano) throws Exception {
        return session.delete(namespace + "delete", ano);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

}
