package com.youtubealbum.myapp.dao;

import com.youtubealbum.myapp.domain.AlbumDto;

import java.util.List;

public interface AlbumDao {
    int insert(AlbumDto dto) throws Exception;

    AlbumDto select(Integer ano) throws Exception;

    List<AlbumDto> selectAll(String writer) throws Exception;

    int update(AlbumDto dto) throws Exception;

    int delete(Integer ano) throws Exception;

    int deleteAll() throws Exception;

    int count() throws Exception;
}
