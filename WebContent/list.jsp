<%@page import="soho.com.User"%>
<%@page import="soho.com.InsertSave"%>
<%@page import="soho.com.FileControl"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%
FileControl control = new FileControl();
String json = control.readFile(InsertSave.FILENAME);
List<User> list = control.getUsersFromString(json);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.12.1.min.js"/>"></script>
<title>입력폼</title>
<script type="text/javascript">

</script>
</head>
<body>
	<table border="1">
		<colgroup>
			<col width="10%">
			<col width="20%">
			<col width="70%">
		</colgroup>
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>아이디</td>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0; i<list.size(); i++){
				User user = list.get(i);
			%>
				<tr>	
					<td><%=i+1 %></td>
					<td><%=user.getLogin() %></td>
					<td><%=user.getUsername() %></td>
				</tr>
			 <%}%>
		</tbody>
	</table>
	
	<a href="/insert.jsp">새글작성</a>
</body>
</html>