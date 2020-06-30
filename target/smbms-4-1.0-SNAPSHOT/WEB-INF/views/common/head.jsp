<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>智能排班系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>智能排班系统</h1>
        <div class="publicHeaderR">
            <p><span>您好！</span><span style="color: #fff21b"> ${userInfo.username }</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/logout">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
    </section>
 <!--主体内容-->
 <section class="publicMian">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                <c:if test="${userInfo.username == 'admin'}">
                  <li><a href="${pageContext.request.contextPath }/user/findAll">用户管理</a></li>
                  <li><a href="${pageContext.request.contextPath }/duty/findAll">排班管理</a></li>
                </c:if>
              <li><a href="${pageContext.request.contextPath}/duty/find">排班查询</a></li>

              <li ><a href="${pageContext.request.contextPath }/logout">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>

