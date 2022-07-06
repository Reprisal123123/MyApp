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
        // sigid�� Ư�� �� ������ ������ ��� DB�� ����ID�� �и��ؼ� �����ϱ� ����

        // 1. v= �ڿ� ����ID�� �ִ� ��� ex) https://www.youtube.com/watch?v=OtYV-AywbRM
        if(sigid.lastIndexOf("v=")!= -1) {
            // ����ID�� �и��ؼ� ��ȯ(11�ڸ�)
            this.sigid = sigid.substring(sigid.lastIndexOf("v=")+2, sigid.lastIndexOf("v=")+13);

            // 2. / �ڿ� ���� �ּҰ� �ִ� ��� ex) https://youtu.be/OtYV-AywbRM
        } else if(sigid.lastIndexOf('/')!= -1) {
            // ����ID�� �и��ؼ� ��ȯ(11�ڸ�)
            this.sigid = sigid.substring(sigid.lastIndexOf('/')+1, sigid.lastIndexOf('/')+12);
        }

        // �� ������ ���°� �ƴϸ�(�̹� ����ID�� ������ ���) �״�� ��ȯ - DB���� ������ �����͸� AlbumDto ��ü�� ������ �� ���
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
