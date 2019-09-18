<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="soho.com.InsertSave"%>
<%@page import="soho.com.FileControl"%>
<%@page import="soho.com.UserControl"%>
<%@page import="soho.com.User"%>
<%
String idStr = request.getParameter("id");
int id = Integer.parseInt(idStr);

User user = new User();
user.setId(id);

UserControl userControl = new UserControl();
FileControl fileControl = new FileControl();

user = userControl.getUser(fileControl.readFile(InsertSave.FILENAME), id);
%>
<form action="/insert/save" method="POST">
<table border="1">
	<colgroup>
		<col width="20%">
		<col width="80%">
	</colgroup>
	<tbody>
		<tr>
			<td>login</td>
			<td>
				<input type="text" name="login"
				value="<%=user.getLogin() %>"/>
			</td>
		</tr>
		<tr>
			<td>username</td>
			<td>
				<input type="text" name="username"
				value="<%=user.getUsername() %>"/>
			</td>
		</tr>
		<tr>
			<td>phone</td>
			<td>
				<input type="text" name="phone"
				value="<%=user.getPhone() %>"/>
			</td>
		</tr>
		<tr>
			<td>email</td>
			<td>
				<input type="text" name="email"
				value="<%=user.getEmail() %>"/>
			</td>
		</tr>
		<tr>
			<td>address</td>
			<td>
				<input type="text" name="address"
				value="<%=user.getAddress() %>"/>
			</td>
		</tr>
	</tbody>
</table>
<input type="submit" value="저장">
<input type="hidden" value="<%=user.getPassword() %>" name="password"/>
</form>