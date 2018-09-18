<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>json数据的处理</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#putAndGetJson').click(function(){
			$.ajax({
				url:"json/test1.action",
				data:'{"userName":"jack","userPass":"123456"}',
				contentType:"application/json",
				type:"post",
				success:function(data){
					alert(JSON.stringify(data));
				},
				dataType:"json"
			});
			
		});
	});
</script>
</head>
<body>

	<input type="button" id="putAndGetJson" value="传输和获取Json数据">

</body>
</html>