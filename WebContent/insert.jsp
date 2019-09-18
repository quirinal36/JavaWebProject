<%@page contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>입력폼</title>
<script type="text/javascript">

</script>
</head>
<body>
<form action="/insert/save" method="POST">
	<table>
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tbody>
			<tr>
				<td>login</td>
				<td><input type="text" name="login" placeholder="아이디를 입력하세요."/></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" placeholder="비밀번호를 입력하세요."/></td>
			</tr>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" placeholder="성명을 입력하세요."/></td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone" placeholder="전화번호를 입력하세요."/></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" placeholder="이메일주소를 입력하세요."/></td>
			</tr>
			<tr>
				<td>address</td>
				<td><input type="text" name="address" placeholder="집주소를 입력하세요."/></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" value="저장">
	</form>
</body>
</html>