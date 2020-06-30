<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath }/statics/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${userInfo.username}</h2>
            <p>欢迎使用智能排班系统!</p>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/views/common/foot.jsp" %>
