<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.net.URLDecoder"%>
<%@ page session="false" %>

<c:set var="loginId" value="${pageContext.request.getSession(false)==null? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' || loginId==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${loginId=='' || loginId==null ? '로그인' : '로그아웃'}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
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
            width: 450px;
            border: none;
            position:absolute;  /* top, left에 의해 위치 지정 */
            top:50%;  /* 위쪽에서 50% 부터 */
            left:50%;  /* 왼쪽에서 50% 부터 */
            transform:translate(-50%, -50%);  /* 요소를 화면 중앙에 표시하기 위해 이동 */
        }

        #title {
            margin: 30px 30px;
            font-size: 40px;
            font-weight: bold;
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
            width: 350px;
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
    <div id="container">
        <header>
            <div id="logo">
                <a href="<c:url value='/'/>">
                    <h1>Youtube Album</h1>
                </a>
            </div>
            <nav>
                <ul id="topmenu">
                    <li><a href="">갤러리</a></li>
                    <li><a href="">나의 앨범</a></li>
                    <li><a href="<c:url value='/register'/>">회원가입</a></li>
                    <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
                </ul>
            </nav>
        </header>
        <form action="<c:url value="/register"/>" method="POST" onsubmit="return formCheck()">
            <div id="title">Register</div>
            <div class="form-group">
                <label for="reg-id">아이디</label>
                <input class="input-field" id="reg-id" name="id" type="text" value="<c:out value='${userDto.id}'/>" placeholder="8~12자리의 영문 소문자와 숫자 조합">
                <div class="check_font" id="id_check"></div>
            </div>
            <div class="form-group">
                <label for="reg-pwd">비밀번호</label>
                <input class="input-field" id="reg-pwd" name="pwd" type="password" placeholder="8~12자리의 영대소문자와 숫자, 특수문자 조합">
                <div class="check_font" id="pwd_check"></div>
            </div>
            <div class="form-group">
                <label for="reg-name">이름</label>
                <input class="input-field" id="reg-name" name="name" type="text" value="<c:out value='${userDto.name}'/>" placeholder="2~6자리의 한글 이름">
                <div class="check_font" id="name_check"></div>
            </div>
            <div class="form-group">
                <label for="reg-birth">생일</label>
                <input class="input-field" id="reg-birth" name="birth" type="date" min="1900-01-01" max="2022-01-01" value="<c:out value='${userDto.birth}'/>">
                <div class="check_font" id="birth_check"></div>
            </div>
            <div class="form-group">
                <label for="reg-gender">성별</label>
                <select class="input-field" id="reg-gender" name="gender">
                    <option value="male" selected>남자</option>
                    <option value="female">여자</option>
                </select>
            </div>
            <div class="form-group">
                <label for="reg-email">이메일</label>
                <input class="input-field" id="reg-email" name="email" type="email" value="<c:out value='${userDto.email}'/>"placeholder="example@album.com">
            </div>
            <div class="form-group">
                <label for="reg-tel">휴대전화</label>
                <input class="input-field" id="reg-tel" name="tel" type="tel" value="<c:out value='${userDto.tel}'/>"placeholder="전화번호 입력">
            </div>
            <button>회원 가입</button>
        </form>
        <footer>
            <div id="creator">
                <ul>
                    <li>Created by Reprisal123123</li>
                    <li>문의 : kezy1992@gmail.com</li>
                </ul>
            </div>
        </footer>
    </div>
<script>

    // id 유효성 검사하는 메서드
    function idCheck() {
        let id = $('#reg-id').val();
        let checkResult;

        $.ajax({
            type: 'GET',
            url: '/myapp/idCheck',
            // headers: {"content-type": "application/x-www-form-urlencoded"},
            headers: {"content-type": "application/json"},
            dataType: 'text',
            data: {
                id : id
            },
            async: false,
            success: function(result) {
                checkResult = JSON.parse(result);
            },
            error: function() {
                alert("idcheck error");
            }
        }); // $.ajax()

        return checkResult;
    }

    // form 전송여부를 정하는 onsubmit 함수
    function formCheck() {
        if(idResult && pwdResult && nameResult && birthResult) {
            return true;
        } else {
            return false;
        }
    }

    //모든 공백 체크 정규식
    var empJ = /\s/g;
    //아이디 정규식
    var idJ = /^[a-z0-9]{8,12}$/;
    // 비밀번호 정규식, 영문, 숫자, 특수기호(!@$%^&* 만 허용)
    var pwJ = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;
    // 이름 정규식
    var nameJ = /^[가-힣]{2,6}$/;
    // 이메일 검사 정규식
    var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 휴대폰 번호 정규식
    var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

    // 유효성 검사 결과를 저장할 전역 변수 선언
    idResult = false;
    pwdResult = false;
    nameResult = false;
    birthResult = false;

    // 아이디 유효성 검사
    $('#reg-id').blur(function() {
        // id 유효성 검사결과를 변수에 저장
        idResult = idJ.test($('#reg-id').val());

        if (idResult) {
            if(idCheck()) {
                $('#id_check').text('사용가능한 아이디 입니다.');
                $('#id_check').css('color', 'blue');
            } else {
                $('#id_check').text('이미 사용중인 아이디 입니다.');
                $('#id_check').css('color', 'red');
                idResult = false;
            }
        } else {
            $('#id_check').text('8~12자리의 영문 소문자와 숫자 조합을 입력하세요.');
            $('#id_check').css('color', 'red');
        }
    });

    // 비밀번호 유효성 검사
    $('#reg-pwd').blur(function() {
        // 비밀번호 유효성 검사결과를 변수에 저장
        pwdResult = pwJ.test($('#reg-pwd').val());

        if (pwdResult) {
            $('#pwd_check').text('사용가능한 비밀번호 입니다.');
            $('#pwd_check').css('color', 'blue');
        } else {
            $('#pwd_check').text('8~12자리의 영대소문자와 숫자, 특수기호 조합을 입력하세요.');
            $('#pwd_check').css('color', 'red');
        }
    });

    // 이름 유효성 검사
    $('#reg-name').blur(function() {
        // 이름 유효성 검사 결과를 변수에 저장
        nameResult = nameJ.test($('#reg-name').val());

        if (nameResult) {
           $('#name_check').text('');
       } else {
           $('#name_check').text('2~6자리의 한글을 입력하세요.');
           $('#name_check').css('color', 'red');
       }
    });

    // 생일 유효성 검사
    $('#reg-birth').blur(function() {
        // 생일 유효성 검사 결과를 변수에 저장
        birthResult = $('#reg-birth').val() !== '';

        if(birthResult) {
            $('#birth_check').text('');
        } else {
            $('#birth_check').text('정확한 생년월일을 입력하세요.');
            $('#birth_check').css('color', 'red');
        }
    });
    $('#reg-birth').val();

    // 이메일, 휴대전화 검증 ㄱㄱ

</script>
</body>
</html>
