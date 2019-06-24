<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Timeline</title>
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<style type="text/css">
body{
	width: 1000px;
	height: 3000px;
}
</style>
</head>
<body>
	<h1>${user.userId }의 타임라인</h1>
	<div id="profile_area">
		<div>프로필사진${user.userImg }</div>
		<div>id:${user.userId }</div>
		<div>nickname:${user.userNick }</div>
	</div>
	<div id="map_area" style="width: 350; height: 350px;">
		<div id="map" style="width: 350; height: 350px;"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=503a7e92a9da5d6ce4d523bd9fa20034&libraries=services"></script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new daum.maps.LatLng(37.478964178779556,
						126.8816736103818), // 지도의 중심좌표
				level : 9
			// 지도의 확대 레벨 
			}; 

			// 지도를 생성합니다    
			var map = new daum.maps.Map(mapContainer, mapOption);

			var doneCallback = function(result, status) {
				if (status === daum.maps.services.Status.OK) {

					var coords = new daum.maps.LatLng(result[0].y, result[0].x);
					var marker = new daum.maps.Marker({
						map : map,
						position : coords
					});
					// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
					daum.maps.event.addListener(marker, 'click', function() {
					    alert('가본곳!');
					});
					// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					map.setCenter(coords);
				}
			};
			
			var doneCallback2 = function(result, status) {
				if (status === daum.maps.services.Status.OK) {

					var coords = new daum.maps.LatLng(result[0].y, result[0].x);
					var marker = new daum.maps.Marker({
						map : map,
						position : coords
					});
					// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
					daum.maps.event.addListener(marker, 'click', function() {
					    alert('가고싶은곳!');
					});
					
					// 마커 위에 표시할 인포윈도우를 생성한다
					var infowindow = new daum.maps.InfoWindow({
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
				<div>작성자: ${f.userId }</div>
				<div>작성일: ${f.feedDate }</div>
				<div>이미지: ${f.feedImg }</div>
				<div>내용: ${f.feedContent }</div>
				<div>좋아요: ${f.feedGoodCnt }개</div>
				<div>태그: ${f.tagName }</div>
			</div>
			<br><br>
		</c:forEach>
	</div>
	<div id="ssg_area"></div>
</body>
</html>