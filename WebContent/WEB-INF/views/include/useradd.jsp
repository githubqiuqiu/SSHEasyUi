<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path %>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript" src="resource/jquery-easyui-1.5.2/jquery.min.js"></script>
</head>
<body>

<form action="useradd" method="post">
	用户名称:<input type="text" name="user.name" id="name"><br><br>
	用户性别:<select id="sex" name="user.sex">
			<option value="">请选择</option>
			<option value="男">男</option>
			<option value="女">女</option>
		  </select>
		  <br><br>
	用户年龄:<input type="text" name="user.age" id="age"><br><br>
	用户密码:<input type="text" name="user.pwd" id="pwd"><br><br>
	选择角色:<select id="rid" name="user.rid">
		
	</select>
	<br><br>
	<input type="submit" value="添加">
</form>


<script type="text/javascript">
	$(function(){
		selectrole();
	});
	
	function selectrole(){
		 $.ajax({
			 async:true,
		 	 cache:true,
		 	 url:'selectrole',
		 	 type:'post',
		 	 dataType:'json',
		 	 success:function(result){
		 		$("#rid").append("<option value=''>"+"请选择"+"</option>");
		 		for( i in result){
	             $("#rid").append("<option value='"+result[i].id+"'>"+result[i].rname+"</option>");
		 		}
		 		 
		 	 },
		 	 error:function(XMLHttpRequest,textStatus){
		 		 alert("错误");
		 	 }
		 });
	}
	

</script>
</body>
</html>