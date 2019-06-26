<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Foodi/css/all.css">
<link rel="stylesheet" href="/Foodi/css/timeline.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/Foodi/js/timeline.js"></script>
<title>TimeLine</title>

</head>
<body>
	<nav>
		<jsp:include page="toolbar.jsp"></jsp:include>
	</nav>
	<div style="height: 100px;"></div>
	<section>
		<article id="left" class="side">
			<h2 id="ssg_title">MY SSG</h2>
			<div id="ssg_list">
				<br> <br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg0 }" id=ssg>${ssg0 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg1 }" id=ssg>${ssg1 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg2 }" id=ssg>${ssg2 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg3 }" id=ssg>${ssg3 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg4 }" id=ssg>${ssg4 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg5 }" id=ssg>${ssg5 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg6 }" id=ssg>${ssg6 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg7 }" id=ssg>${ssg7 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg8 }" id=ssg>${ssg8 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg9 }" id=ssg>${ssg9 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg10 }" id=ssg>${ssg10 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg11 }" id=ssg>${ssg11 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg12 }" id=ssg>${ssg12 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg13 }" id=ssg>${ssg13 }</a><br>
				<br> <a
					href="/Foodi/search/searchresult?searchKeyword=${ssg14 }" id=ssg>${ssg14 }</a><br>
				<br>
			</div>
		</article>

		<article id="middle">
			<div id="profile_area">
				<img alt="ProfImg" src="${user.userImg }" id="profile_img" />
				<div id="profile2">
					<div id="profile_id">@${user.userId }</div>
					<div id="profile_nick">${user.userNick }</div>
				</div>
			</div>
			<div id="map_area">
				<div id="map" style="width: 410px; height: 410px;"></div>
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=503a7e92a9da5d6ce4d523bd9fa20034&libraries=services"></script>
				<script>
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center : new daum.maps.LatLng(37.478964178779556,
								126.8816736103818), // 지도의 중심좌표
						level : 11
					// 지도의 확대 레벨
					};

					// 지도를 생성합니다    
					var map = new daum.maps.Map(mapContainer, mapOption);

					var doneCallback = function(result, status) {
						if (status === daum.maps.services.Status.OK) {

							var coords = new daum.maps.LatLng(result[0].y,
									result[0].x);
							var marker = new daum.maps.Marker({
								map : map,
								position : coords
							});
							// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
							daum.maps.event.addListener(marker, 'click',
									function() {
										alert('가본곳!');
									});
							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					};

					var doneCallback2 = function(result, status) {
						if (status === daum.maps.services.Status.OK) {

							var coords = new daum.maps.LatLng(result[0].y,
									result[0].x);
							var marker = new daum.maps.Marker({
								map : map,
								position : coords
							});
							// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
							daum.maps.event.addListener(marker, 'click',
									function() {
										alert('가고싶은곳!');
									});

							// 마커 위에 표시할 인포윈도우를 생성한다
							var infowindow = new daum.maps.InfoWindow(
									{
										content : '<div style="padding:10px;margin-left:30px;">가보고싶다</div>' // 인포윈도우에 표시할 내용
									});

							// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
							infowindow.open(map, marker);
						}
					};
					var geocoder = new daum.maps.services.Geocoder();
					//가본곳 마커 표시
					geocoder.addressSearch('${loc0}', doneCallback);
					geocoder.addressSearch('${loc1}', doneCallback);
					geocoder.addressSearch('${loc2}', doneCallback);
					geocoder.addressSearch('${loc3}', doneCallback);
					geocoder.addressSearch('${loc4}', doneCallback);
					geocoder.addressSearch('${loc5}', doneCallback);
					geocoder.addressSearch('${loc6}', doneCallback);
					geocoder.addressSearch('${loc7}', doneCallback);
					geocoder.addressSearch('${loc8}', doneCallback);
					geocoder.addressSearch('${loc9}', doneCallback);
					geocoder.addressSearch('${loc10}', doneCallback);
					geocoder.addressSearch('${loc11}', doneCallback);
					geocoder.addressSearch('${loc12}', doneCallback);
					geocoder.addressSearch('${loc13}', doneCallback);
					geocoder.addressSearch('${loc14}', doneCallback);
					geocoder.addressSearch('${loc15}', doneCallback);
					geocoder.addressSearch('${loc16}', doneCallback);
					geocoder.addressSearch('${loc17}', doneCallback);
					geocoder.addressSearch('${loc18}', doneCallback);
					geocoder.addressSearch('${loc19}', doneCallback);
					geocoder.addressSearch('${loc20}', doneCallback);

					//가고싶은곳 마커 표시
					geocoder.addressSearch('${qooks0}', doneCallback2);
					geocoder.addressSearch('${qooks1}', doneCallback2);
					geocoder.addressSearch('${qooks2}', doneCallback2);
					geocoder.addressSearch('${qooks3}', doneCallback2);
					geocoder.addressSearch('${qooks4}', doneCallback2);
					geocoder.addressSearch('${qooks5}', doneCallback2);
					geocoder.addressSearch('${qooks6}', doneCallback2);
					geocoder.addressSearch('${qooks7}', doneCallback2);
					geocoder.addressSearch('${qooks8}', doneCallback2);
					geocoder.addressSearch('${qooks9}', doneCallback2);
					geocoder.addressSearch('${qooks10}', doneCallback2);
					geocoder.addressSearch('${qooks11}', doneCallback2);
					geocoder.addressSearch('${qooks12}', doneCallback2);
					geocoder.addressSearch('${qooks13}', doneCallback2);
					geocoder.addressSearch('${qooks14}', doneCallback2);
					geocoder.addressSearch('${qooks15}', doneCallback2);
					geocoder.addressSearch('${qooks16}', doneCallback2);
					geocoder.addressSearch('${qooks17}', doneCallback2);
					geocoder.addressSearch('${qooks18}', doneCallback2);
					geocoder.addressSearch('${qooks19}', doneCallback2);
					geocoder.addressSearch('${qooks20}', doneCallback2);
				</script>
			</div>
			<div id="feed_area">
				<c:forEach var="f" items="${feeds }">
					<div id="feed">
						<div id="feed_top">
							<div id="feedBarButton" class="menuClick">
								<a class="menuOnOff" href="#">
									<img src="/Foodi/css/icon/menuOn.png" width="40px" height="40px" />
								</a>
							</div>
							<div id="feedBar" class="hidden">
								<form action="/Foodi/feed/modifyButton.do" method="post">
									<input type="hidden" value="${f.feedNo}" name="feedNo">
									<input type="submit" value="수정">
								</form>
								<form action="/Foodi/feed/deleteFeed.do" method="post">
									<input type="hidden" value="${f.feedNo}" name="feedNo">
									<input type="submit" value="삭제">
								</form>
							</div>
							<a href="/Foodi/timeline/timeline?userId=${f.userId }">
								<img alt="ProfImg" src="${f.userImg }" id="feed_userimg" /></a>
								
							<a href="/Foodi/timeline/timeline?userId=${f.userId }">
								<div id="feed_userid">${f.userId }</div>
							</a>

							<div id="feed_date">${f.feedDate }</div>

							<div id="feed_content">${f.feedContent }</div>

							<div></div>
						</div>

						<div id="feed_middle">
							<img alt="no images" src="${f.feedImg }" id="feed_img" />
						</div>

						<div id="feed_bottom">
							<button id="good_btn">
								<a href="#">좋아요 : ${f.feedGoodCnt}</a>
							</button>
							<button id="detail_btn">
								<a href="#">상세페이지</a>
							</button>
							<button id="report_btn">
								<a href="#">신고하기</a>
							</button>
						</div>
					</div>
					<br>
					<br>
				</c:forEach>
			</div>

		</article>

		<article id="right" class="side">우측</article>
	</section>

</body>
</html>