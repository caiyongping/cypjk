<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>首页</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/goRegist" method="post" enctype="multipart/form-data">
    <tr>
        <td><input type="submit" value="注册"></td>
    </tr>
</form>
<form action="${pageContext.request.contextPath }/user/goUserLogin" method="post" enctype="multipart/form-data">
    <tr>
        <td><input type="submit" value="登录"></td>
    </tr>
</form>

</body>
</html>