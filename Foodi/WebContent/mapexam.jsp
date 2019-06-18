<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
</head>
<body>
	<!-- appkey=503a7e92a9da5d6ce4d523bd9fa20034 -->
	<div id="map" style="width: 600; height: 800px;"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=503a7e92a9da5d6ce4d523bd9fa20034&libraries=services"></script>

	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new daum.maps.LatLng(37.478964178779556, 126.8816736103818 ), // 지도의 중심좌표
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
				// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				map.setCenter(coords);
			}
		};
		var geocoder = new daum.maps.services.Geocoder();
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
	</script>

</body>
</html>