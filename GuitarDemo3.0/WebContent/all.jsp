<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ page import="dao.*,entity.Guitar,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>吉他之家</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
        <ul class="breadcrumb">
            <li><a href="index.html">首页</a> <span class="divider">/</span></li>
            <li class="active">全部吉他</li>
        </ul>
         
       <table class="table table-bordered table-hover">
                <tr>
                    <td>系列号</td>
	                <td>厂商</td>
	                <td>型号</td>
	                <td>类型</td>
	                <td>材质</td>
	                <td>价格</td>
	                <td>处理</td>
                </tr>
                <c:forEach items="${list}" var="p">
	            <tr>
                	<td>${p.ID}</td>
                	<td>${p.getSpec().getBuilder()}</td>
                	<td>${p.getSpec().getModel()}</td>	
                	<td>${p.getSpec().getType()}</td>
                	<td>${p.getSpec().getWood()}</td>
                	<td>${p.price}</td>	
                	<td><a href="DeleteGuitar?ID=${p.ID}">删除</a>
                </tr>
                </c:forEach>
        </table>
</body>
</html>