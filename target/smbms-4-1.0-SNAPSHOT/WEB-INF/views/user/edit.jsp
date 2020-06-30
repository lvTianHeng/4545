<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户修改页面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user/update">
            <input type="hidden" name="uid" value="${user.id }"/>
            <div>
                <label for="loginname">用户名：</label>
                <input type="text" name="loginname" id="loginname" value="${user.loginname }">
                <font color="red"></font>
            </div>
            <div>
                <label for="userName">姓名：</label>
                <input type="text" name="username" id="userName" value="${user.username }">
                <font color="red"></font>
            </div>

            <div>
                <label for="tel">用户电话：</label>
                <input type="text" name="tel" id="tel" value="${user.tel }">
                <font color="red"></font>
            </div>

            <div>
                <label for="job">职务：</label>
                <input type="text" name="job" id="job" value="${user.job}">
            </div>
            <div class="providerAddBtn">
                <input type="button" name="save" id="save" value="保存" />
                <input type="button" id="back" name="back" value="返回"/>
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/views/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>
