<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="saveeditrole" method="post">

	<input type="hidden" name="role.id" id="id" value="${role.id}">
	角色名称:<input type="text" name="role.rname" id="rname" value="${role.rname} "><br><br>
	角色标识:<input type="text" name="role.code" id="code" value="${role.code}"><br><br>
	角色介绍:<input type="text" name="role.introduce" id="introduce" value="${role.introduce}"><br><br>
	<input type="submit" value="添加">
</form>


</body>
</html>