<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Youtube Album</title>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:url value='/css/menu.css'/>">

	<style>
		@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@400;700&family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap');
		@import url('https://fonts.googleapis.com/css2?family=Merienda:wght@700&display=swap');

		#contents {
			display: grid;
			width: 70%;
			margin: 95px auto;
			background-color: white;
			grid-template-columns: repeat(auto-fill, minmax(450px, 1fr));
		}

		#img {
			width: 1fr;
			height: 550px;
			margin-right: 50px;
			margin-left: 50px;
			border-radius: 24px;
			background-image: url('img/main.jpg');
			background-position: center;
			background-size: cover;
		}

		#information {
			display: flex;
			width: 1fr;
			height: 550px;
			align-items: center;
		}

		#information > p {
			font-size: 40px;
			text-align: center;
			font-family: 'Gowun Dodum', sans-serif;
		}

		@media screen and (max-width: 820px) {

			#img {
				width: 90%;
				height: 400px;
				margin: 0 auto;
			}

			#information {
				width: 90%;
				height: 350px;
				margin: 0 30px 0 30px;
			}

			#information > p {
				font-size: 30px;
				padding-bottom: 100px;
			}

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
				<li><a href="">갤러리</a></li>
				<li><a href="">나의 앨범</a></li>
				<li><a href="<c:url value='/register'/>">회원가입</a></li>
				<li><a href="">로그인</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div id="contents">
			<div id="img"></div>
			<div id="information"><p>다시 보고 싶은 유튜브 동영상들을 모아 앨범을 만들어보세요.<br> 어떤 주제에 관한 동영상인지, 다시 보고 싶은 시간대는 어디인지 메모를 남겨보세요!</p></div>
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