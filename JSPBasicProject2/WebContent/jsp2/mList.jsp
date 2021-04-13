<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
	//오라클로부터 출력할 데이터를 읽어 온다
	MusicDAO dao=new MusicDAO();
	ArrayList<MusicVO> list=dao.musicListData();
	for(MusicVO vo:list){
		String t=vo.getTitle();
		String s=vo.getSinger();
		if(t.length()>20){
			t=t.substring(0,20)+"...";
		}
		if(s.length()>13){
			s=s.substring(0,13)+"...";
		}
		vo.setTitle(t);
		vo.setSinger(s);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   width:100%;
   margin: 0px auto;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.img').css("cursor","pointer");
	$('.img').click(function(){
		let no=$(this).attr("data");
		$.ajax({
			type:'POST',
			url:'mDetail.jsp',
			data:{"no":no},
			success:function(result) /*오류없이 정상수행 했을 때*/
			{
				$('.col-sm-4').html(result);
			}
		})
	})
});
</script>
</head>
<body>
  <div style="height: 30px"></div>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-8">
        <%
        	for(MusicVO vo:list){
        %>
       		  <div class="col-md-3">
      		     <div class="panel panel-success">
			        <div class="panel-heading">
			        <img src="<%=vo.getPoster() %>" width=100% class="img-rounded img" 
			           data="<%=vo.getNo() %>"></div>
			        
			        <div class="panel-body">
			        <div style="text-align:center">
			          <span style="font-weight:bold;font-size:12pt"><%=vo.getTitle() %></span></div></div>
			        <div class="panel-foot text-right"><%=vo.getSinger() %>&nbsp;&nbsp;			           
			        </div>
			     </div>
    		  </div>
        <%
        	}
        %>
      </div>
      <div class="col-sm-4">
    
      </div>
    </div>
  </div>
</body>
</html>