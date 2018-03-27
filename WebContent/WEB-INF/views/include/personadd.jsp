<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



</head>
<body>


<form action="personadd" id="personadd">

客户名:<input type="text" name="person.name" id="name">
<br><br>

身份证号码:<input type="text" name="person.card.cardnum" id="cardnum">
<br><br>

省份:<select name="person.proviceid" id="proviceid" onchange="selcity()">
		<option value="">请选择</option>
	</select>
<br><br>

市/区:<select name="person.cityid" id="cityid" onchange="selcountyname()">
		<option value="">请选择</option>
	</select>
<br><br>

县城:<select name="person.countyid" id="countyid">
		<option value="">请选择</option>
	</select>
<br><br>

<input type="button" onclick="addperson()"value="添加">

</form>


<script type="text/javascript">
	$(function(){
		selprovince();
		
	});
	
	
	//提交
	function addperson(){
		var name=$("#name").val();
		var cardnum=$("#cardnum").val();
		var provicename=$("#proviceid").val();
		var cityname=$("#cityid").val();
		var countyname=$("#countyid").val();
		
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
	
		$("#personadd").submit();
		
		
	}
	
	
	//查询省
	function selprovince(){
		
		$("#cityid").html("");
		$("#cityid").append("<option value=''>请选择</option>");
		
		$("#countyid").html("");
		$("#countyid").append("<option value=''>请选择</option>");
		
		
		$.ajax({
			url : 'selprovince',
			type : 'post',
			data : {},
		    dataType:"json",
			success : function(data) {
				for(i in data){
					$("#proviceid").append("<option value="+data[i].pid+">"+data[i].pname+"</option>");
				}
				
			}
		});
	}
	
	function selcity(){
		$("#countyid").html("");
		$("#countyid").append("<option value=''>请选择</option>");
		
		//获取省的id
		var id=$("#proviceid").val();
		$.ajax({
			url : 'selcity',
			type : 'post',
			data : {"id":id},
		    dataType:"json",
			success : function(data) {
				
				$("#cityid").html("");
				$("#cityid").append("<option value=''>请选择</option>");
				for(i in data){
					
					$("#cityid").append("<option value="+data[i].cid+">"+data[i].cname+"</option>");
				}
				
			}
		});
		
	}
	
	function selcountyname(){
		//获取省的id
		var id=$("#cityid").val();
		$.ajax({
			url : 'selcounty',
			type : 'post',
			data : {"id":id},
		    dataType:"json",
			success : function(data) {
				$("#countyid").html("");

				$("#countyid").append("<option value=''>请选择</option>");
				for(i in data){
					$("#countyid").append("<option value="+data[i].id+">"+data[i].name+"</option>");
				}
			}
		});
		
	}
	
	



</script>


</body>
</html>