<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <title>회원 가입 완료</title>
    <style>
        #contents {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #info {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            border: 1px solid black;
            height: 500px;
            width: 50%;
            margin: 90px auto;
        }

    </style>
</head>
<body>
<div id="container">
    <header>
        <div id="logo">
            <a href="index.html">
                <h1>Youtube Album</h1>
            </a>
        </div>
        <nav>
            <ul id="topmenu">
                <li><a href="#">갤러리</a></li>
                <li><a href="#">나의 앨범</a></li>
                <li><a href="<c:url value='/register'/>">회원가입</a></li>
                <li><a href="#">로그인</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <div id="contents">
            <div id="info">
                <p>회원가입을 축하합니다!</p>
                <p>회원님의 아이디는 ${userDto.id} 입니다.</p>
            </div>
        </div>
    </main>
    <footer>
        <div id="creator">
            <ul>
                <li>Created By Reprisal123123</li>
                <li>문의 : kezy1992@gmail.com</li>
            </ul>
        </div>
    </footer>
</div>
</body>
</html>
