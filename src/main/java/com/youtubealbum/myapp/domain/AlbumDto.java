package com.youtubealbum.myapp.domain;

import java.util.Objects;

public class AlbumDto {
    Integer ano;
    String title;
    String link;
    String writer;
    String comment;

    public AlbumDto(String title, String link, String writer, String comment) {
        this.title = title;
        this.link = link;
        this.writer = writer;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AlbumDto{" +
                "ano=" + ano +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", writer='" + writer + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumDto albumDto = (AlbumDto) o;
        return Objects.equals(ano, albumDto.ano) && Objects.equals(title, albumDto.title) && Objects.equals(link, albumDto.link) && Objects.equals(writer, albumDto.writer) && Objects.equals(comment, albumDto.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, title, link, writer, comment);
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

    public String getLink() {
        return link.substring(link.lastIndexOf('/')+1);
    }

    public void setLink(String link) {
        this.link = link;
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
