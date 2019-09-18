<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="soho.com.InsertSave"%>
<%@page import="soho.com.FileControl"%>
<%@page import="soho.com.UserControl"%>
<%@page import="soho.com.User"%>
<%
String idStr = request.getParameter("id");
int id = Integer.parseInt(idStr);

UserControl userControl = new UserControl();
FileControl fileControl = new FileControl();

User user = userControl.getUser(fileControl.readFile(InsertSave.FILENAME), id);
%>
<table border="1">
	<colgroup>
		<col width="20%">
		<col width="80%">
	</colgroup>
	<tbody>
		<tr>
			<td>login</td>
			<td><%=user.getLogin() %></td>
		</tr>
		<tr>
			<td>username</td>
			<td><%=user.getUsername() %></td>
		</tr>
		<tr>
			<td>phone</td>
			<td><%=user.getPhone() %></td>
		</tr>
		<tr>
			<td>email</td>
			<td><%=user.getEmail() %></td>
		</tr>
		<tr>
			<td>address</td>
			<td><%=user.getAddress() %></td>
		</tr>
	</tbody>
</table>
<form action="/delete/user" method="POST">
	<input type="button" value="수정" onclick="location.href='/edit.jsp?id=<%=user.getId() %>'"/>
	<input type="hidden" name="id" value="<%=user.getId() %>">
	<input type="submit" value="삭제" />
</form>
