<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.net.URLDecoder"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>

    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            text-decoration: none;
        }

        form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 400px;
            height: 500px;
            border: 5px solid rgb(89,117,196);
            border-radius: 10px;
            position:absolute;  /* top, left에 의해 위치 지정 */
            top:50%;  /* 위쪽에서 50% 부터 */
            left:50%;  /* 왼쪽에서 50% 부터 */
            transform:translate(-50%, -50%);  /* 요소를 화면 중앙에 표시하기 위해 이동 */
        }

        #title {
            font-size: 50px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        #msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            font-weight: bold;
            color:red;
            margin-bottom: 20px;
        }

        .input-field {
            width: 250px;
            height: 40px;
            border : 1px solid rgb(89,117,196);
            border-radius: 10px;
            padding: 0 10px;
            margin-bottom: 10px;
        }

        button {
            background-color: white;
            color : rgb(89,117,196);
            width:150px;
            height:50px;
            font-size: 17px;
            font-weight: bold;
            border : 2px solid rgb(89,117,196);
            border-radius: 10px;
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
                <li><a href="<c:url value='/login'/>">로그인</a></li>
            </ul>
        </nav>
    </header>
    <form action="<c:url value='/login'/>" method="post">
        <div id="title">Login</div>
        <div id="msg">
            <c:if test="${not empty param.msg}">
                <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg, "UTF-8")}</i>
            </c:if>
        </div>
        <input class="input-field" id="login-id" name="id" value="${cookie.id.value}" type="text" placeholder="아이디">
        <input class="input-field" id="login-pwd" name="pwd" type="password" placeholder="비밀번호">
        <input type="hidden" name="toURL" value="${param.toURL}">
        <button>로그인</button>
        <div>
            <label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> 아이디 기억</label> |
            <a href="">아이디 찾기</a> |
            <a href="">비밀번호 찾기</a>
        </div>
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
</body>
</html>
