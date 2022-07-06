package com.youtubealbum.myapp.domain;

import java.util.Objects;

public class AlbumDto {
    Integer ano;
    String title;
    String sigid;
    String writer;
    String comment;

    // test
    public AlbumDto(String title, String sigid, String writer, String comment) {
        this.title = title;
        this.sigid = sigid;
        this.writer = writer;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AlbumDto{" +
                "ano=" + ano +
                ", title='" + title + '\'' +
                ", sigid='" + sigid + '\'' +
                ", writer='" + writer + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumDto albumDto = (AlbumDto) o;
        return Objects.equals(ano, albumDto.ano) && Objects.equals(title, albumDto.title) && Objects.equals(sigid, albumDto.sigid) && Objects.equals(writer, albumDto.writer) && Objects.equals(comment, albumDto.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, title, sigid, writer, comment);
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSigid() {
        return sigid;
    }

    public void setSigid(String sigid) {
        // sigid가 특정 두 가지의 형식인 경우 DB에 고유ID만 분리해서 저장하기 위함

        // 1. v= 뒤에 고유ID가 있는 경우 ex) https://www.youtube.com/watch?v=OtYV-AywbRM
        if(sigid.lastIndexOf("v=")!= -1) {
            // 고유ID만 분리해서 반환(11자리)
            this.sigid = sigid.substring(sigid.lastIndexOf("v=")+2, sigid.lastIndexOf("v=")+13);

            // 2. / 뒤에 고유 주소가 있는 경우 ex) https://youtu.be/OtYV-AywbRM
        } else if(sigid.lastIndexOf('/')!= -1) {
            // 고유ID만 분리해서 반환(11자리)
            this.sigid = sigid.substring(sigid.lastIndexOf('/')+1, sigid.lastIndexOf('/')+12);
        }

        // 두 가지의 형태가 아니면(이미 고유ID의 형태인 경우) 그대로 반환 - DB에서 서버로 데이터를 AlbumDto 객체에 저장할 때 사용
        this.sigid = sigid;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
