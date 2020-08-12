<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function() {
	$('#delete').click(function() {
		var param="";
		var phoneArr = $('input[name=phone]:checked');
		phoneArr.each(function(i){
			param = param + "&phone=" + $(this).val();
		});
		$.ajax({
			type:'post',
			url:'delPhone.do',
			data:param,
			
			success:function(result) {
				location.reload();
			}
		});
		
	});
});

</script>
</head>
<body>
<jsp:include page = "header.jsp" />
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 리스트</b></td>
		  </tr>
	  </table>  
	  <br>
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델이름</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">가격</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">제조사명</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">삭제</td>
		  </tr>
		  <c:forEach items="${list}" var="phone">
			<tr style="text-align: center;">
				<td width=490 bgcolor="ffffff" style="padding-left:10"><a href="showPhone.do?num=${phone.num}">${phone.num}</a></td>
				<td width=490 bgcolor="ffffff" style="padding-left:10">${phone.model}</td>
				<td width=490 bgcolor="ffffff" style="padding-left:10">${phone.price}</td>
				<td width=490 bgcolor="ffffff" style="padding-left:10">${phone.company.vendor}</td>
				<td width=490 bgcolor="ffffff" style="padding-left:10"><input type="checkbox" name="phone" value="${phone.num}"></td>
			</tr>
		  </c:forEach>
	  </table>
	  </td>
	</tr>
</table>  

<div style="margin-top: 15px;margin-left: 200px;">
	<a href="regPhone.do">추가 등록</a>
	<a href="#" id="delete">선택항목 삭제</a>
</div>

</body>
</html>