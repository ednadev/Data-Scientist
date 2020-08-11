<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#id').keyup(function() {
			var id = $(this).val();
			if(id.length<4 || id.length>8) {
				$('#check').html('4자 이상 8자 이하로 입력해주세요.').css('color', 'red');
				$('#submit_button').attr('disabled', true);
			} else {
				$.ajax({
					type:'post',
					url:'idExist.do',
					data:'id='+id,
					
					success:function(result) {
						var jsonData = JSON.parse(result);
						console.log(jsonData.check);
						if(jsonData.check==true) {
							$('#check').html('이미 사용중인 아이디입니다.').css('color', 'red');
							$('#submit_button').attr('disabled', true);
						} else {
							$('#check').html('사용 가능한 아이디입니다.').css('color', 'blue');
							$('#submit_button').attr('disabled', false);
						}
					}
				});
			}
		});
	});
</script>
</head>
<body>
<h3>회원가입</h3>
<!-- register_action에서 하고있는 기능이  RegisterServletd으로 이동
	 register_result.jsp로 결과를 보낸다.
-->
<form action="register.do" name="registerForm" >
ID : <input type="text" name="id" id="id" required="required"><span id="check" style="margin-left:10px;"></span><br><br>
PASSWORD : <input type="password" name="password" required="required"><br><br>
NAME : <input type="text" name="name" required="required"><br><br>
ADDRESS : <input type="text" name="address" required="required"><br><br>

<input type="submit" value="member register" id="submit_button">
</form>
</body>
</html>



















