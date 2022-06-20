<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
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
        .form-group {
            display: flex;
            flex-direction: column;
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
            margin-bottom: 5px;
        }
        .check_font {
            font-size: 0.75em;
            padding : 0 5px 5px 5px;
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
    <div class="form-group">
        <label for="reg-id">아이디</label>
        <input class="input-field" id="reg-id" name="id" type="text" placeholder="8~13자리의 영대소문자와 숫자 조합">
        <div class="check_font" id="id_check"></div>
    </div>
    <div class="form-group">
        <label for="reg-pwd">비밀번호</label>
        <input class="input-field" id="reg-pwd" name="pwd" type="password" placeholder="8~13자리의 영대소문자와 숫자, 특수문자 조합">
    </div>
    <div class="form-group">
        <label for="reg-name">이름</label>
        <input class="input-field" id="reg-name" name="name" type="text">
    </div>
    <div class="form-group">
        <label for="reg-birth">생일</label>
        <input class="input-field" id="reg-birth" name="birth" type="date">
    </div>
    <div class="form-group">
        <label for="reg-sex">성별</label>
        <select class="input-field" id="reg-sex">
            <option name="sex" value="male" selected>남자</option>
            <option name="sex" value="female">여자</option>
        </select>
    </div>
    <div class="form-group">
        <label for="reg-email">이메일</label>
        <input class="input-field" id="reg-email" name="email" type="email" placeholder="example@album.com">
    </div>
    <div class="form-group">
        <label for="reg-tel">휴대전화</label>
        <input class="input-field" id="reg-tel" name="tel" type="tel" placeholder="전화번호 입력">
    </div>
    <button>회원 가입</button>
</form>
<script>
    //모든 공백 체크 정규식
    var empJ = /\s/g;
    //아이디 정규식
    var idJ = /^[a-z0-9]{8,13}$/;
    // 비밀번호 정규식
    var pwJ = /^[A-Za-z0-9]{4,12}$/;
    // 이름 정규식
    var nameJ = /^[가-힣]{2,6}$/;
    // 이메일 검사 정규식
    var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 휴대폰 번호 정규식
    var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

    // 아이디 유효성 검사
    $('#reg-id').blur(function() {
        if (idJ.test($('#reg-id').val())) {
            $('#id_check').text('사용가능한 아이디 입니다.');
            $('#id_check').css('color', 'blue');
        } else {
            $('#id_check').text('8~13자리의 영대소문자와 숫자 조합을 입력하세요.');
            $('#id_check').css('color', 'red');
        }
    });
</script>
</body>
</html>
