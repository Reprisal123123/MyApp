package com.youtubealbum.myapp.domain;

import java.util.Date;
import java.util.Objects;

public class UserDto {
    private String id; // 아이디
    private String pwd; // 비밀번호
    private String name; // 이름
    private Date birth; // 생일
    private String sex; // 성별
    private String email; // 이메일
    private String tel; // 휴대전화
    private Date reg_date; // 가입일

    public UserDto() {}

    public UserDto(String id, String pwd, String name, Date birth, String sex, String email, String tel) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.email = email;
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(pwd, userDto.pwd) && Objects.equals(name, userDto.name) && Objects.equals(birth, userDto.birth) && Objects.equals(sex, userDto.sex) && Objects.equals(email, userDto.email) && Objects.equals(tel, userDto.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pwd, name, birth, sex, email, tel);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", reg_date=" + reg_date +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
}
