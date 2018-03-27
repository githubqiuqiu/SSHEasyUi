<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path %>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>




<body>

<form action="edituser" method="post">
	<input type="hidden" name="user.id" id="id" value=${user.id }>
	<input type="hidden" name="userrid" id="userrid" value="${user.rid }">
	用户名称:<input type="text" name="user.name" id="name" value="${user.name}"><br><br>
	用户性别:<select id="sex" name="user.sex">
			<option value="" >请选择</option>
			<option value="男" ${user.sex=='男'?'selected':'' }>男</option>
			<option value="女" ${user.sex=='女'?'selected':'' }>女</option>
		  </select>
		  <br><br>
	用户年龄:<input type="text" name="user.age" id="age" value="${user.age }"><br><br>
	用户密码:<input type="text" name="user.pwd" id="pwd" value="${user.pwd }"><br><br>
	选择角色:<select id="rid" name="user.rid">
	
	</select>
	<br><br>
	<input type="submit" value="修改">
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
		 		 var rid=$("#userrid").val();
		 		 
		 		
		 		for( i in result){
		 			if(result[i].id==rid){
			             $("#rid").append("<option value='"+result[i].id+"'  selected >"+result[i].rname+"</option>");

		 			}
		 			else{
			             $("#rid").append("<option value='"+result[i].id+"'   >"+result[i].rname+"</option>");

		 			}
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