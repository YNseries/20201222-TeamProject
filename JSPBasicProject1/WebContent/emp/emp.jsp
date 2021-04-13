<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%-- html 시작 전, 데이터를 오라클로부터 가지고 온다 --%>
<%
	// 사용자가 보낸 데이터를 받는다 => request.getParameter() 먼저 해야하지만 지금은 받을게 없기 때문에 생략
	EmpDAO dao=new EmpDAO();
	ArrayList<EmpVO> list=dao.empListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
   width:800px;
   margin:0px auto;
}
h1{
   text-align: center;
}
</style>
<!-- 자바스크립트 라이브러리 import -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!-- 화면에 출력된 내용(라이브러리) 제어 -->
<script type="text/javascript">
// window.onload=function(){}
/*
 *   자바 연결 => Ajax
 */
 $(function(){
		$('#keyword').keyup(function(){
			let k=$(this).val();
			$('#user-table > tbody > tr').hide();    //        ====== 8개 중 2번째 칸 가져와서
			let temp=$('#user-table > tbody > tr > td:nth-child(8n+2):contains("'+k+'")');
			$(temp).parent().show();                     // 그 단어가 포함된 것을 출력 ======
	});
});
</script>
</head>
<body>
  <div class="container">
    <h1>사원 목록</h1>
    <div class="row">
      <table class="table">
        <tr>
          <td>
            Search:<input type=text id=keyword class="input-sm">
          </td>
        </tr>
      </table>
      <table class="table table-striped" id="user-table">
        <tr class="info">
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">사수</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          <th class="text-center">성과급</th>
          <th class="text-center">부서번호</th>
        </tr>
        <tbody>
        <%
        	for(EmpVO vo:list){
        %>
        		<tr>
        			<td class="text-center"><%=vo.getEmpno() %></td>
        			<td class="text-center"><%=vo.getEname() %></td>
        			<td class="text-center"><%=vo.getJob() %></td>
        			<td class="text-center"><%=vo.getMgr() %></td>
        			<td class="text-center"><%=vo.getHiredate().toString() %></td>
        			<td class="text-center"><%=vo.getSal() %></td>
        			<td class="text-center"><%=vo.getComm() %></td>
        			<td class="text-center"><%=vo.getDeptno() %></td>
        		</tr>
        <%
        	}
        %>
      </tbody>
      </table>
    </div>
  </div>
</body>
</html>