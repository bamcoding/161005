<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/WebToon/css/layout.css">
<script type="text/javascript" src="/WebToon/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var error = "${error}";
		if (error == 1) {
			alert("비밀번호가 틀렸습니다.");
		}
		if (error == 2) {
			alert("아이디를 입력해주세요.");
		}
		if (error == 3) {
			alert("비밀번호를 입력해주세요.");
		}
		if (error == 4) {
			var result = confirm("존재하지 않는 아이디입니다.\n 회원가입 하시겠습니까?");
			if (result) {
				location.href = './join';
			}
		}

		$("#loginBtn").click(function() {
			$("#loginForm").attr({
				"method" : "post",
				"action" : "./doLogin"
			}).submit();
		});

	});
</script>
<title>다음 : 로그인</title>
</head>
<body>
	<div>
		<div style="width: 600px; margin: auto;">
			<!-- 로고 -->
			<div style="margin: 50px 0px 20px 0px;">
				<a href="http://www.daum.net"><img id="home"
					src="/WebToon/img/daum.png" /></a>
			</div>
			<div>
				<!-- 왼쪽 -->
				<div class="block"
					style="width: 50%; border-right: 1px solid #ccc; margin-bottom: 15px">
					<div style="width: 90%;">
						<!-- 입력 부분 -->
						<form id="loginForm">
							<div class="input">
								<input id="id" name="id" class="input2" type="text"
									placeholder="&nbsp;&nbsp;아이디" />
							</div>
							<div class="input">
								<input id="password" name="password" class="input2" type="text"
									placeholder="&nbsp;&nbsp;비밀번호" />
							</div>
							<!-- 로그인 상태유지 행 -->
							<div>
								<div class="block" style="float: left;">로그인 상태 유지</div>
								<div style="float: right;">
									<div class="block">IP보안 ON</div>
								</div>
								<div style="clear: both;"></div>
							</div>
							<div>
								<input id="loginBtn" type="button" value="로그인" />
							</div>
						</form>
						<!-- 아이디 찾기 행 -->
						<div
							style="text-align: center; font-size: 11px; margin-bottom: 20px;">
							<a href="./join">아이디 찾기</a> &nbsp;&nbsp;|&nbsp; <a href="./join">비밀번호
								찾기</a> &nbsp;&nbsp;|&nbsp; <a href="./join">회원가입</a>
						</div>
						<div>
							<input class="btn" type="button" value="카카오계정으로 로그인" />
						</div>
					</div>
				</div>
				<!-- 오른쪽 -->
				<div class="block right" style="vertical-align: top; width: 45%;">
					<a href="http://distribute.tistory.com"> <img class="right"
						style="height: 100%; width: 100%;" src="/WebToon/img/ad3.png" />
					</a>
				</div>
			</div>
			<hr />
			<!-- 아래 나머지 -->
			<div class="clear_right"
				style="margin-top: 20px; text-align: center; font-size: 11px;">
				Copyright ⓒ <span style="font-weight: bold;">Kakao Corp.</span> All
				Rights Reserved. | 로그인 도움말
			</div>
		</div>
	</div>
</body>
</html>