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

		* {
			box-sizing: border-box;
			text-decoration: none;
			margin: 0;
			padding: 0;
		}

		#contents {
			display: grid;
			width: 1200px;
			margin: 70px auto;
			background-color: white;
			grid-template-columns: 600px 1fr;
		}

		#img {
			width: 550px;
			height: 550px;
			margin-right: 30px;
			border-radius: 24px;
			background-image: url('img/main.jpg');
			background-position: center;
			background-size: cover;
		}

		#information {
			display: flex;
			width: 550px;
			height: 550px;
			align-items: center;
		}

		#information > p {
			font-size: 40px;
			text-align: center;
			font-family: 'Gowun Dodum', sans-serif;
		}

		@media screen and (max-width: 820px) {
			header {
				display: block;
				width: 100%;
			}

			#topmenu {
				width: 100%;
				height: 50px;
				justify-content: space-between;
				align-items: center;
			}

			#contents {
				display: block;
				width: 100%;
				margin-top: 40px;
				margin-bottom: 40px;
			}

			#img {
				width: 90%;
				height: 400px;
				margin: 0 auto;
			}

			#information {
				width: 90%;
				height: 350px;
				margin: 30px auto;
			}

			#information > p {
				font-size: 30px;
			}

		}
	</style>
</head>
<body>
<div id="container">
	<header>
		<div id="logo">
			<a href="">
				<h1>Youtube Album</h1>
			</a>
		</div>
		<nav>
			<ul id="topmenu">
				<li><a href="#">갤러리</a></li>
				<li><a href="#">나의 앨범</a></li>
				<li><a href="#">회원가입</a></li>
				<li><a href="#">로그인</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div id="contents">
			<div id="img"></div>
			<div id="information"><p>다시 보고 싶은 유튜브 동영상들을 모아 앨범을 만들어보세요.<br> 어떤 주제에 관한 동영상인지, 다시 보고 싶은 시간대는 어디인지 메모를 남겨보세요!</p></div>
		</div>
	</main>
	<footer></footer>
</div>
</body>
</html>