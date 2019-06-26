<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Foodi/css/all.css">
<link rel="stylesheet" href="/Foodi/css/qook.css">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<jsp:include page="toolbar.jsp"></jsp:include> 
	</nav> 
	<div style="height: 100px;"></div>
	<section>
		<article id="left" class="side">
			좌측
		</article>
		
		<article id="middle">
			<h2>My Qook</h2>
			<div id="map">
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


						}
					};
					var geocoder = new daum.maps.services.Geocoder();
					
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
			
			<ul id="list">
				<c:forEach var="feed" items="${list}">
					<li>
						<div id="feed_content">
							<img alt="no imgs" src="${feed.feedImg}" style="width: 200px; height: 170px;"/>
							<img alt="no img" src="${feed.userImg}" id="user_img" style="width: 40px; height: 40px; font-size: 50px;">${feed.userId}
							<p class="loc">${feed.feedLoc}</p>
						</div>
					</li>				
				</c:forEach>
			</ul>
		</article>
		
		<article id="right" class="side">
			우측
		</article>		
	</section>
</body>
</html>