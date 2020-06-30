<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户添加页面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user/save">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="loginname">用户名：</label>
                <input type="text" name="loginname" id="loginname" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="userName">姓名：</label>
                <input type="text" name="username" id="userName" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="tel">手机号码：</label>
                <input type="text" name="tel" id="tel" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="job">职务：</label>
                <input type="text" name="job" id="job" value="">
            </div>
            <div>
                <label for="pwd">密码：</label>
                <input type="password" name="pwd" id="pwd" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="ruserPassword">确认密码：</label>
                <input type="password" name="ruserPassword" id="ruserPassword" value="">
                <font color="red"></font>
            </div>

            <%--<div>--%>
                <%--<label for="birthday">出生日期：</label>--%>
                <%--<input type="text" Class="Wdate" id="birthday" name="birthday"--%>
                       <%--readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM'});">--%>
                <%--<font color="red"></font>--%>
            <%--</div>--%>


            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存" >
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/views/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
