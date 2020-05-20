<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="300" height="300" align="center">
		<br>
		<br>
		<div style="text-align: center;">
			<tr>
				<td>
					<form action="auth.do" method="post">
						<div>
							이메일 : <input type="email" name="e_mail"
								placeholder="이메일주소를 입력하세요"> <br>
							<br>
							<button type="submit" name="submit">이메일 인증받기(이메일 보내기)</button>
						</div>
					</form>
				</td>
			</tr>
		</div>
	</table>
</body>
</html>