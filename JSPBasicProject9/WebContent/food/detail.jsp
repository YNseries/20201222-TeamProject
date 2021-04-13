<%@page import="java.util.List"%>
<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%--
	  main.jsp?mode=2&no=10
	  ===============
	    => detail.jsp&no=10 과 같음
--%>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"></jsp:useBean>
<!-- 
	될 수 있으면 new FoodDAO 이런식으로 쓰지 마 => 사용자 지정이기 때문에 
	메모리가 살아있어서 계속 누적됨. => 메모리 누수현상. 속도 느려짐
	(현재 10개 지정해 뒀기 때문에 DAO를 disConnection()없이 진행하면, 10개 이후 작동 안함)
	
	=> 때문에 라이브러리를 써야 함. 해제(disConnection())까지 다 해줌. 
 -->
<%
	String no=request.getParameter("no");
	String cno=request.getParameter("cno");
	FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
	// 주소(지역) 갖고오기
	String s=vo.getAddress();                 // 인천광역시 부평구 경인로 952
	String ss=s.substring(s.indexOf(" ")+1);  // 부평구 경인로 952(첫번째 공백~)
	ss=ss.substring(0,ss.indexOf(" "));       // 부평구(첫번째 공백까지)
	System.out.println(s);
	List<FoodVO> list=dao.foodLocation(ss);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
    <table class="table">
      <tr>
        <%
        	StringTokenizer st=new StringTokenizer(vo.getPoster(),"^");
        	while(st.hasMoreTokens())
        	{
        %>
        	<td><img src="<%=st.nextToken() %>" width=100%></td>
        <%
        	}
        %>
      </tr>
    </table>
  </div>
  <div class="row">
    <div class="col-sm-6"> <!-- 총 합이 12만 되면 됨 -->
      <table class="table">
        <tr>
          <td>
            <h3><%=vo.getTitle() %>&nbsp;<span style="color:orange"><%=vo.getScore()%></span></h3>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">주소</th>
          <td width=80%><%=vo.getAddress().substring(0, vo.getAddress().lastIndexOf("지")) %></td>
          <!--                                                         지번~ 의 "지" 부터 삭제 -->
        </tr>
        <tr>
          <th width=20% class="text-right">전화</th>
          <td width=80%><%=vo.getTel() %></td>
        </tr>
        <tr>
          <th width=20% class="text-right">음식 종류</th>
          <td width=80%><%=vo.getType() %></td>
        </tr>
        <tr>
          <th width=20% class="text-right">가격대</th>
          <td width=80%><%=vo.getPrice() %></td>
        </tr>
        <tr>
          <th width=20% class="text-right">주차</th>
          <td width=80%><%=vo.getParking() %></td>
        </tr>
        <tr>
          <th width=20% class="text-right">영업시간</th>
          <td width=80%><%=vo.getTime() %></td>
        </tr>
        <%
        	if(!vo.getMenu().equals("no")) {
        	// 이 조건 없으면 오류남('원'이 있어야 자를 수 있기 때문에)
        %>
        <tr>
          <th width=20% class="text-right">메뉴</th>
          <td width=80%>
            <ul style="list-style-type:none">
            <%
            	st=new StringTokenizer(vo.getMenu(),"원");
            	while(st.hasMoreTokens())
            	{
            %>
            		<li><%=st.nextToken().trim() %>원</li>
            		<%-- '원'에서 잘라서 밑으로 내림 --%>
            <%
            	}
            %>
            </ul>
          </td>
        </tr>
        <%
        	}  // => 메뉴가 없는(null) 경우엔 출력x(<tr>을(라벨도) 없앰)
        %>
      </table>
    </div>
    <div class="col-sm-6">
      <script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('<%=vo.getAddress().substring(0, vo.getAddress().lastIndexOf("지")) %>', function(result, status) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=vo.getTitle() %></div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
	    </script>
	    <div style="height:20px"></div>
	    <table class="table">
	      <caption><b>주변 인기 맛집</b></caption>
	      <%
	      	  for(FoodVO fvo:list){
	      %>
	      		<tr>
	      		  <td><img src="<%=fvo.getPoster().substring(0,fvo.getPoster().indexOf("^")) %>" width=30 height=30></td>
	      		  <td><%=fvo.getTitle() %></td>
	      		  <td><%=fvo.getType() %></td>
	      		  <td><%=fvo.getPrice() %></td>
	      		</tr>
	      <%
	      	  }
	      %>
	    </table>
	  <div style="height:30px"></div>
	  <div class="row">
	    <table class="table">
	      <tr>
	        <td class="text-right">
	          <a href="#" class="btn btn-sm btn-danger">예약</a>
	          <a href="#" class="btn btn-sm btn-success">찜하기</a>
	          <a href="main.jsp?mode=1&cno=<%=cno %>" class="btn btn-sm btn-primary">목록</a>
	        </td>
	      </tr>
	    </table>
	    <table class="table">
	      <tr>
	        <td class="text-right">
	          맛있다 (<%=vo.getGood() %>)&nbsp;괜찮다 (<%=vo.getSoso() %>)&nbsp;별로 (<%=vo.getBad() %>)
	        </td>
	      </tr>
	    </table>
	  </div>
    </div>
  </div>
</body>
</html>