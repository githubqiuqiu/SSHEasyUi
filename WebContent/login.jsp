<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="tologin" method="post">
账号:<input type="text" name="user.name" id="name"><br/>
密码:<input type="password" name="user.pwd" id="pwd"><br/>
<input type="submit" value="登入">
</form>
	
	<font color="red">
		<s:actionerror/>
	</font>

</body>
</html>