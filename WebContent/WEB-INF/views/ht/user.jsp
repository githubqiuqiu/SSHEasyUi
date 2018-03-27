<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=path%>/">
<link rel="stylesheet" type="text/css"
	href="easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="css/wu.css" />
<link rel="stylesheet" type="text/css" href="css/icon.css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

	<!-- End of easyui-dialog -->
	<script type="text/javascript">
	
		$(function(){
			//预加载数据到数据网格
			showdata();	
		});
		
		//打开添加页面
		function openAdd(){
			$('#winadd').window('open');
			$('#winadd').window('refresh','touseradd');
		}
		
		//打开编辑窗口
		function openEdit(){
			//获得选中的id
			var item = $('#wu-datagrid-2').datagrid('getSelected'); // json对象
			var id = item.id;
			
			$('#winedit').window('open');
			$('#winedit').window('refresh','seluserbyid?id='+id);
		}
	
		/**
		 * Name 刷新页面
		 */
		function reload() {
			$('#wu-datagrid-2').datagrid('load');
		}

		/**
		 * Name 删除单个记录
		 */
		function remove(id) {
			$.messager.confirm('信息提示', '确定要删除该记录？', function(result) {
				if (result) {
// 					var item = $('#wu-datagrid-2').datagrid('getSelected'); // json对象
// 					var id = item.id;
					$.ajax({
						url : 'deluser',
						data : {
							'id' : id
						},
						success : function(data) {
							if (data=="success") {
								$.messager.alert('信息提示', '删除成功！', 'info');
								showdata();
							} else {
								$.messager.alert('信息提示', '删除失败！', 'info');
								showdata();
							}
						}
					});
				}
			});
		}

		/**
		 * Name 删除多个记录
		 */
		function removeAll() {
			var items = $('#wu-datagrid-2').datagrid('getSelections');
			if(items==0){
				$.messager.alert("温馨提示","请至少勾选一项删除");
				return;
			}else{
				$.messager.confirm('信息提示', '确定要删除该记录？', function(result) {
					if (result) {
						
						var ids = [];
						$(items).each(function() {
							ids.push(this.id);
						});
						//alert(ids);return;
						$.ajax({
							url : 'deluser',
							type : 'post',
							traditional : true,//传数组进后台需要设置该属性
							data : {
								'ids' : ids
							},
							success : function(data) {
								if (data) {
									$.messager.alert('信息提示', '删除成功！', 'info');
									showdata();
								} else {
									$.messager.alert('信息提示', '删除失败！', 'info');
									showdata();
								}
							}
						});
					}
				});
			}
			
		}

		/**
		 * Name 分页过滤器
		 */
		function pagerFilter(data) {
			if (typeof data.length == 'number'
					&& typeof data.splice == 'function') {// is array                
				data = {
					total : data.length,
					rows : data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage : function(pageNum, pageSize) {
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh', {
						pageNumber : pageNum,
						pageSize : pageSize
					});
					dg.datagrid('loadData', data);
				}
			});
			if (!data.originalRows) {
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}

		/**
		 * Name 导出数据
		 */
		function exports() {
			$.messager.confirm('信息提示', '确定导出吗？', function(result) {
				if (result) {
					$.ajax({
						url : 'exports',
						type : 'post',
						success : function(data) {
							//下载模板
							window.location.href="downloadexport";
						}
					});
				}
			});
		}
		
		//上传模板
		function uploadmoban(){
			$('#uploadmoban').window('open');
		}
	
		
		//导入数据
		function imports(){
			$('#import').window('open');
		}
		
		//上传ecxel表格
		function importexcels(){
			
			var files=$("#importexcel").val();
			
			var index=files.lastIndexOf(".");
			//后缀
			var hz=files.substring(index);
			alert(hz);
			//判断后缀的格式正不正确
			if(hz==".xls"){
				$("#importform").submit();
			}
			else{
				alert("请选择xls格式的文件");
				return;
			}
		}
		

		/**
		 * Name 载入数据
		 */
		 
		 function showdata(){
			 $('#wu-datagrid-2').datagrid({
					url : 'seluser',
					loadFilter : pagerFilter,
					rownumbers : true,
					singleSelect : false,
					pageSize : 10,
					pagination : true,
					multiSort : true,
					fitColumns : true,
					fit : true,
					columns : [ [
							{
								checkbox : true
							},
							{
								field : 'id',
								title : '用户编号',
								width : 100,
								sortable : true
							},
							{
								field : 'name',
								title : '用户名',
								width : 100,
								sortable : true
							},
							{
								field : 'sex',
								title : '性别',
								width : 200
							},
							{
								field : 'age',
								title : '年龄',
								width : 100
							},
							{
								field : 'pwd',
								title : '密码',
								width : 100
							},
							{
								field : 'rname',
								title : '用户角色',
								width : 100
							},
							{
								field : 'operate',
								title : '操作',
								width : 100,
								align : 'center',
								formatter : function(value, rows, index) {
									var str = '';
									str += '<a href="javascript:void(0)" class="user-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="openEdit();" >编辑</a>';
									str += '<a href="javascript:void(0)" class="user-easyui-linkbutton-remove" data-options="plain:true,iconCls:\'icon-remove\'"  onclick="remove('+rows.id+');">删除</a>';
									return str;
								}
							} ] ],
					onLoadSuccess : function(data) {
						$('.user-easyui-linkbutton-edit').linkbutton({
							text : '编辑'
						});
						$('.user-easyui-linkbutton-remove').linkbutton(
								{
									text : '删除'
								});
					},
				});
		}
		
	</script>

</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<!-- Begin of toolbar -->
		<div id="wu-toolbar-2">
			<div class="wu-toolbar-button">
				<a href="javascript:;" download="a.jpg" id="a_dc"><span id="spanAutoClick"></span></a>
				<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
				<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-remove" onclick="removeAll()" plain="true">批量删除</a> 
				<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a> 
				<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-print" onclick="uploadmoban()" plain="true">上传模板</a>
				<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-print" onclick="downloadmoban()" plain="true">下载模板</a>
				<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-print" onclick="exports()" plain="true">导出数据</a>
				<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-print" onclick="imports()" plain="true">导入数据</a>
			</div>
			<div class="wu-toolbar-search">
				<form id="wu-form-1" method="post">
					<label>用户名：</label><input id="uuname" class="wu-text"
						style="width: 100px"> <label>来自：</label><input
						id="uuplace" class="wu-text" style="width: 100px"> <label>出生年月：</label><input
						id="uubirthday" class="easyui-datebox" style="width: 100px">
					<label>性别：</label> <select id="uusex" class="easyui-combobox"
						panelHeight="auto" style="width: 100px">
						<option value="">选择性别</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select> <a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-search" onclick="searchUser();">开始检索</a>
				</form>
			</div>
		</div>
		<!-- End of toolbar -->
		<table id="wu-datagrid-2" 
			toolbar="#wu-toolbar-2"></table>
	</div>

	<!--修改页面  Begin of easyui-dialog -->
	<div id="wu-dialog-2" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 400px; padding: 10px;">
		<form id="wu-form-2" method="post">
			<input type="hidden" name="user.id" id="uid" />
			<table>
				<tr>
					<td width="60" align="right">姓 名：</td>
					<td><input type="text" name="user.username" id="uname"
						class="wu-text" /></td>
				</tr>
				<tr>
					<td align="right">密 码：</td>
					<td><input type="text" name="user.password" id="upassword"
						class="wu-text" /></td>
				</tr>
				<tr>
					<td align="right">生 日：</td>
					<td><input type="text" name="user.birthday" id="ubirthday"
						class="wu-text" /></td>
				</tr>
				<tr>
					<td align="right">性 别：</td>
					<td><input type="text" name="user.sex" id="usex"
						class="wu-text" /></td>
				</tr>
				<tr>
					<td align="right">电 话：</td>
					<td><input type="text" name="user.tel" id="utel"
						class="wu-text" /></td>
				</tr>
				<tr>
					<td valign="top" align="right">来 自：</td>
					<td><input type="text" name="user.place" id="uplace"
						class="wu-text" /></td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 添加窗口 -->
	<div id="winadd" class="easyui-window" 
		title="添加" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:500px;height:300px;padding:5px;">
		
	</div>
	
	
	<!-- 编辑窗口 -->
	<div id="winedit" class="easyui-window" 
		title="编辑" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:500px;height:300px;padding:5px;">
		<input type="text">
	</div>
	
		<!-- 上传模板 -->
		<div id="uploadmoban" class="easyui-window" 
		title="上传模板" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:300px;height:150px;padding:5px;">
		<form action="uploadmoban" method="post" enctype="multipart/form-data">
		<input type="file" id="uploadexcel" name="myfile">
		<br>
		<input type="submit" value="上传">
		</form>
		</div>
		
		<!-- 导入数据-->
		<div id="import" class="easyui-window" 
		title="导人数据" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:300px;height:150px;padding:5px;">
		<form action="importexcel" id="importform" method="post" enctype="multipart/form-data">
		<input type="file" id="importexcel" name="myfile">
		<br>
		<input type="button" onclick="importexcels()" value="上传">
		</form>
		</div>
	

</body>
</html>