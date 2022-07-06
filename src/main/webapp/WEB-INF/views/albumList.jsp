<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' || loginId==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${loginId=='' || loginId==null ? '로그인' : '로그아웃'}"/>


<!DOCTYPE html>
<html lang="ko">
<head>
    <title>나의 앨범</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            height: 100%;
            border-style: hidden;
        }

        main {
            width: 100%;
        }

        #list {
            width: 70%;
            margin: 50px auto;
            background-color: bisque;
            border-radius: 20px;
            border: 1px solid black;
        }
        th {
            border-top: none;
            border-left: none;
            border-bottom: 1px solid black;
        }
        td {
            text-align: left;
            border: 1px solid black;
        }

        td.no {
            display: none;
        }

        td.video {
            width: 50%;
            padding: 10px 10px;
        }

        td.title {
            width: 15%;
        }

        td.comment {
            width: 35%;
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
                <li><a href="">${loginId}</a></li>
                <li><a href="">갤러리</a></li>
                <li><a href="<c:url value='/album/list'/>">나의 앨범</a></li>
                <li><a href="<c:url value='/register'/>">회원가입</a></li>
                <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <div id="contents">
            <div id="list">
                <table>
                    <th class="no" hidden>번호</th>
                    <th class="video">동영상</th>
                    <th class="title">제목</th>
                    <th class="comment">코멘트</th>
                    <c:forEach var="albumDto" items="${list}" varStatus="status">
                        <tr>
<%--                            <td>${status.index}</td>--%>
                            <td class="no">${albumDto.ano}</td>
                            <td class="video">
                                <iframe width="560" height="315" src="https://www.youtube.com/embed/${albumDto.sigid}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </td>
                            <td class="title">${albumDto.title}</td>
                            <td class="comment">${albumDto.comment}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </main>
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
