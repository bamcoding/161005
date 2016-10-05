<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/WebToon/css/layout.css">
<script type="text/javascript" src="/WebToon/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#toLoginBtn").click(function() {
			location.href = '/WebToon/login';
		});
		$("#viewStory").click(function() {
			location.href = '/WebToon/story/viewStory';
		});
		$("#logout").click(function() {
			if(confirm("로그아웃 하시겠습니까?")){
				location.href = '/WebToon/doLogout';
			}
		});
		$("#likeBtn").click(function() {
			$.post("/WebToon/story/doLike", { id : "${story.id }"}, function(data) {
				
				if(data = "true"){
					var count = parseInt($("#like").text());
					$("#like").text(count+1);
				}
					
			});
		});
	});
</script>
<title>신의 탑 :: 네이버 만화</title>
</head>
<body>
	<div id="wrapper"
		style="background: #fff; font-size: 11px; margin: auto; width: 950px;">
		<!-- 첫번째 줄 -->
		<div style="margin: 20px 10px 20px 10px;">
			<div class="block" id="viewStory">
			<div class="block"
				style="width: 80px; height: 15px; vertical-align: middle;">
				<img src="/WebToon/img/naver.PNG" style="width: 100%; height: 100%;" />
			</div>
			<div class="block"
				style="width: 40px; height: 20px; vertical-align: middle;">
				<img src="/WebToon/img/manha.png" style="width: 100%; height: 100%;" />
			</div>
			</div>
			&nbsp;&nbsp;|&nbsp;
			<div class="block">웹소설</div>
			<div class="block" style="vertical-align: middle;">
				<input type="text" placeholder="제목/작가로 검색할 수 있습니다."
					style="margin-left: 20px; width: 200px; height: 15px; border: 3px solid #4fa52b" />
			</div>
			<div class="block" style="vertical-align: middle;">
				<input type="button" value="검색"
					style="background: #4fa52b; color: white; width: 50px; border: 0px; padding: 3px" />
			</div>
			<c:if test="${not empty sessionScope._USER_INFO_ }">
				<div class="block right">
					<div class="block" style="font-size: 17px; margin-right: 10px;">${sessionScope._USER_INFO_.nick }
						: <span id="point">${sessionScope._USER_INFO_.point }</span>pt
					</div>
					<div class="block" style="vertical-align: bottom;">
						<input id="logout" type="button" value="로그아웃" />
					</div>
					<div class="block" style="vertical-align: bottom;">
						<img src="/WebToon/img/menu_top4.png" />
					</div>
				</div>
			</c:if>
			<c:if test="${empty sessionScope._USER_INFO_ }">
				<div class="block right">
					<div class="block" style="vertical-align: bottom;">
						<input id="toLoginBtn" type="button" value="로그인" />
					</div>
					<div class="block" style="vertical-align: bottom;">
						<img src="/WebToon/img/menu_top4.png" />
					</div>
				</div>
			</c:if>
		</div>
		<!-- 두번째 줄 -->
		<div class="clear_right">
			<!-- 검은 줄 -->
			<div
				style="font-weight: bold; color: white; background: #424242; width: 100%; height: 40px;">
				<div style="margin: 0px 20px 0px 20px;">
					<div class="block small_menu">만화홈</div>
					<div class="block small_menu">웹툰</div>
					<div class="block small_menu">베스트 도전</div>
					<div class="block small_menu">도전만화</div>
					<div class="block small_menu">마이페이지</div>
					<div class="block small_menu">N스토어</div>
					<div class="block small_menu">단행본 만화</div>
					<div class="block small_menu">장르소설</div>
				</div>
			</div>
			<!-- 회색줄 -->
			<div
				style="font-weight: bold; color: black; background: #f1f1f1; width: 100%; height: 40px;">
				<div style="margin: 0px 20px 0px 20px;">
					<div class="block small_menu">요일별</div>
					|
					<div class="block small_menu">장르별</div>
					|
					<div class="block small_menu">작품별</div>
					|
					<div class="block small_menu">작가별</div>
					|
					<div class="block small_menu">연도별</div>
					|
					<div class="block small_menu">테마웹툰</div>
					|
					<div class="block small_menu">완결웹툰</div>
				</div>
			</div>
		</div>

		<!-- 본문 -->
		<div>
			<!-- 만화 정보 -->
			<div style="margin: 10px 20px 30px 0px;">
				<div style="margin: 0px 0px 0px 0px;">
					<div class="block div_btn">요일전체</div>
					<div class="block div_btn">월요웹툰</div>
					<div class="block div_btn">화요웹툰</div>
					<div class="block div_btn">수요웹툰</div>
					<div class="block div_btn">목요웹툰</div>
					<div class="block div_btn">금요웹툰</div>
					<div class="block div_btn">토요웹툰</div>
					<div class="block div_btn">일요웹툰</div>
				</div>
				<div class="clear_left" style="width: 100%; border: 1px solid gray;">
				</div>
				<!-- 사진줄 -->
				<div style="margin: 30px 0px 30px 0px;">
					<div class="block vertical" style="width: 250px; height: 150px">
						<img style="width: 100%; height: 100%"
							src="/WebToon/img/story_info.PNG" />
					</div>
					<div class="block vertical" style="margin: 0px 20px 0px 40px;">
						<div>
							<span style="font-size: 20px; font-weight: bold;">신의탑</span> <span
								style="font-size: 14px;">${story.managerId}</span>
						</div>
						<br /> <br />
						<div>
							<span style="font-size: 16px;"> 자신의 모든 것이었던 소녀를 좋아 탑에 들어온
								소년<br />그리고 그런 소년을 시험하는 탑
							</span>
						</div>
						<br /> <br />
						<div style="margin: 0px 0px 0px 0px;">
							<div class="block div_btn">☆관심웹툰</div>
							<div class="block div_btn">첫회보기</div>
							<div class="block div_btn">작가의 다른 작품</div>
							<div class="block div_btn">
								<a href="./write">글쓰기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="clear_left" style="width: 100%; border: 1px solid #ccc;">
				</div>
				<div style="font-size: 20px;">

					<div style="background: #efefef; padding: 5px 20px 5px 20px;">
						<div class="block">${story.title }</div>
						<div class="block right">
							<a href="./doDelete?id=${story.id }">삭제</a>
						</div>
					</div>
					<div class="right_clear"
						style="padding: 5px 20px 5px 20px; border-bottom: 1px solid #efefef;">
						<div class="block" id="likeBtn">☆☆☆☆☆별점 <span id="like">${story.likeCount}</span></div>
						<div class="block">조회수 ${story.hitCount}</div>
						<div class="block right">${story.createdDate }</div>
					</div>
					<div class="right_clear"
						style="padding: 5px 20px 5px 20px; height: 500px;">${story.content }</div>
				</div>
			</div>
		</div>

		<!-- 이용약관 -->
		<div style="text-align: center; margin: 30px;">
			<div style="margin-bottom: 10px;">
				<div class="block">이용약관</div>
				&nbsp;&nbsp;|&nbsp;
				<div class="block">개인정보취급방침</div>
				&nbsp;&nbsp;|&nbsp;
				<div class="block">책임의 한계와 법적고지</div>
				&nbsp;&nbsp;|&nbsp;
				<div class="block">회원정보 고객센터</div>
			</div>
			<div style="font-size: 9px;">
				<div class="block">
					<img id="small_home" src="/Naver/img/naver.png" /> Copyright ⓒ <span
						style="font-weight: bold;">NAVER Corp.</span> All Rights Reserved.
				</div>
			</div>
		</div>
	</div>
</body>
</html>