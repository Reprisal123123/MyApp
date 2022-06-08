<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 400px;
            margin: 100px auto;
            border: 5px solid rgb(89,117,196);
            border-radius: 10px;
        }

        #title {
            margin: 30px 30px;
            font-size: 30px;
        }
        label {
            width: 300px;
            margin-bottom: 5px;
            margin-left: 5px;
        }
        .input-field {
            width: 300px;
            height: 30px;
            border : 1px solid rgb(89,117,196);
            border-radius:10px;
            padding: 0 10px;
            margin-bottom: 10px;
        }

        button {
            background-color: white;
            color : rgb(89,117,196);
            width:150px;
            height:50px;
            font-size: 17px;
            border : 2px solid rgb(89,117,196);
            border-radius: 5px;
            margin : 20px 0 30px 0;
        }

        button:hover {
            background-color: rgb(89,117,196);
            color: white;
        }
    </style>
</head>
<body>
<form>
    <div id="title">Register</div>
    <label for="reg-id">아이디</label>
    <input class="input-field" id="reg-id" name="id" type="text" placeholder="8~13자리의 영대소문자와 숫자 조합">
    <label for="reg-pwd">비밀번호</label>
    <input class="input-field" id="reg-pwd" name="pwd" type="password" placeholder="8~13자리의 영대소문자와 숫자, 특수문자 조합">
    <label for="reg-name">이름</label>
    <input class="input-field" id="reg-name" name="name" type="text">
    <label for="reg-birth">생일</label>
    <input class="input-field" id="reg-birth" name="birth" type="date">
    <label for="reg-sex">성별</label>
    <select class="input-field" id="reg-sex">
        <option name="sex" value="male" selected>남자</option>
        <option name="sex" value="female">여자</option>
    </select>
    <label for="reg-email">이메일</label>
    <input class="input-field" id="reg-email" name="email" type="email" placeholder="example@album.com">
    <label for="reg-tel">휴대전화</label>
    <input class="input-field" id="reg-tel" name="tel" type="tel" placeholder="전화번호 입력">
    <button>회원 가입</button>
</form>
</body>
</html>
