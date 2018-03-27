<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



</head>
<body>


<form action="personedit" id="personedit">
	 <input type="hidden" name="person.id" id="id" value="${person.id }">
	 <!-- 这个地方一定要注意 因为一对一级联修改 必须要有另一边的关系  所以一定要有另外一边的主键 -->
	 <input type="text" name="person.card.id" id="cardid" value="${person.card.id }">
	
客户名:<input type="text" name="person.name" id="name" value="${person.name} ">
<br><br>

身份证号码:<input type="text" name="person.card.cardnum" id="cardnum" value="${person.card.cardnum}">
<br><br>

省份:<select name="person.proviceid" id="provicename" onchange="selcity()">
		<option value="">请选择</option>
		<c:forEach var="provice" items="${provicelist}">
			<option value="${provice.pid }" ${provice.pid==person.proviceid?'selected':''} }>${provice.pname }</option>
		</c:forEach>
		
	</select>
<br><br>

市/区:<select name="person.cityid" id="cityname" onchange="selcountyname()">
		<option value="">请选择</option>
		<c:forEach var="city" items="${citylist}">
			<option value="${city.cid }" ${city.cid==person.cityid?'selected':''} }>${city.cname }</option>
		</c:forEach>
	</select>
<br><br>

县城:<select name="person.countyid" id="countyname">
		<option value="">请选择</option>
		<c:forEach var="county" items="${countylist}">
			<option value="${county.id }" ${county.id==person.countyid?'selected':''} }>${county.name }</option>
		</c:forEach>
	</select>
<br><br>

<input type="button" onclick="addperson()"value="修改">

</form>


<script type="text/javascript">
	$(function(){
		
		
	});
	
	
	
	//提交
	function addperson(){
		var name=$("#name").val();
		var cardnum=$("#cardnum").val();
		var provicename=$("#provicename").val();
		var cityname=$("#cityname").val();
		var countyname=$("#countyname").val();
		
		if(cardnum==""||cardnum==null){
			alert("客户身份证不能为空");
			return;
		}
		if(provicename==""||provicename==null){
			alert("省份不能为空");
			return;
		}
		if(cityname==""||cityname==null){
			alert("市/区不能为空");
			return;
		}
		if(countyname==""||countyname==null){
			alert("城市不能为空");
			return;
		}
	
		$("#personedit").submit();
		
		
	}
	
	
	//查询省
	function selprovince(){
		
		$("#cityname").html("");
		$("#cityname").append("<option value=''>请选择</option>");
		
		$("#countyname").html("");
		$("#countyname").append("<option value=''>请选择</option>");
		
		
		$.ajax({
			url : 'selprovince',
			type : 'post',
			data : {},
		    dataType:"json",
			success : function(data) {
				for(i in data){
					$("#provicename").append("<option value="+data[i].pid+">"+data[i].pname+"</option>");
				}
				
			}
		});
	}
	
	function selcity(){
		$("#countyname").html("");
		$("#countyname").append("<option value=''>请选择</option>");
		
		//获取省的id
		var id=$("#provicename").val();
		$.ajax({
			url : 'selcity',
			type : 'post',
			data : {"id":id},
		    dataType:"json",
			success : function(data) {
				
				$("#cityname").html("");
				$("#cityname").append("<option value=''>请选择</option>");
				for(i in data){
					
					$("#cityname").append("<option value="+data[i].cid+">"+data[i].cname+"</option>");
				}
				
			}
		});
		
	}
	
	function selcountyname(){
		//获取省的id
		var id=$("#cityname").val();
		$.ajax({
			url : 'selcounty',
			type : 'post',
			data : {"id":id},
		    dataType:"json",
			success : function(data) {
				$("#countyname").html("");

				$("#countyname").append("<option value=''>请选择</option>");
				for(i in data){
					$("#countyname").append("<option value="+data[i].id+">"+data[i].name+"</option>");
				}
			}
		});
		
	}
	
	



</script>


</body>
</html>