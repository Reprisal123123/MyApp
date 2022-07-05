package com.youtubealbum.myapp.service;

import com.youtubealbum.myapp.domain.AlbumDto;

import java.util.List;

public interface AlbumService {
    // 앨범 쓰기
    int write(AlbumDto dto) throws Exception;

    // 앨범 목록 가져오기
    List<AlbumDto> getList(String writer) throws Exception;

    // 앨범 수정하기
    int modify(AlbumDto dto) throws Exception;

    // 앨범 하나 삭제하기
    int remove(Integer ano) throws Exception;

    // 앨범 전체 삭제하기
    int removeAll() throws Exception;

    // 앨범 갯수 카운트하기
    int count() throws Exception;
}
