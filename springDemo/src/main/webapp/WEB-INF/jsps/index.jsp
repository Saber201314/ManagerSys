<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<script type="text/javascript" src="https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/static/protocol/https/jquery/jquery-1.10.2.min_65682a2.js"></script>
<body>
	<h2>Hello World!</h2>
	<table>
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${users }">
				<tr>
					<td>${item.id }</td>
					<td>${item.name }</td>
					<td>${item.pwd }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${users2 }">
				<tr>
					<td>${item.id }</td>
					<td>${item.name }</td>
					<td>${item.pwd }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<span>下面是异步请求的数据</span>
	<table id="ajaxtable">
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
<script type="text/javascript">
$(function(){
	$.ajax({
		url : '/cls/getbody',
		dataType : 'json',
		cache : false,
		success : function(data){
			
			var html=[];
			for(var i=0 ; i<data.length;i++){
				html.push('<tr>');
				html.push('<td>'+data[i].id+'</td>');
				html.push('<td>'+data[i].name+'</td>');
				html.push('<td>'+data[i].pwd+'</td>');
				html.push('</tr>');
			}
			$("#ajaxtable tbody").append(html.join(''));
		}
	})
})




</script>


</html>
