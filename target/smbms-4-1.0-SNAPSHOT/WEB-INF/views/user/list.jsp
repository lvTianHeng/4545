<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>

<div class="right">
<div class="location">
    <strong>你现在所在的位置是:</strong>
    <span>用户管理页面</span>
</div>
<div class="search">
    <form method="get" action="${pageContext.request.contextPath }/user/findAll">
        <span>用户名：</span>
        <input name="queryname" class="input-text"	type="text" value="${param.queryname}">

        <span>电话号码：</span>
        <input name="tel" class="input-text" type="text" value="${param.tel}">

        <input type="hidden" name="pageIndex" value="1"/>
        <input	value="查 询" type="submit" id="searchbutton">
        <a href="${pageContext.request.contextPath}/user/add">添加用户</a>
        <%--<a href="${pageContext.request.contextPath}/user/deleteBatch">删除用户</a>--%>
    </form>
</div>
<!--用户-->
<table class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
        <th width="10%"><input type="checkbox" name="checkAll" ></th>
        <th width="10%">序号</th>
        <th width="20%">用户名</th>
        <th width="20%">电话</th>
        <th width="20%">职务</th>
        <th width="20%">操作</th>
    </tr>
    <c:forEach var="user" items="${page.list}" varStatus="status">
        <tr>
            <td>
                <input type="checkbox" id="checkItem" name="checkItem" value="${user.id}">
            </td>
            <td>
                <span>${status.index +1}</span>
            </td>
            <td>
                <span>${user.loginname }</span>
            </td>
            <td>
                <span>${user.tel}</span>
            </td>
            <td>
                <span>${user.job}</span>
            </td>

            <td>
                <span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.username }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
                <span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.username }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
            </td>
        </tr>
    </c:forEach>
</table>
<input type="hidden" id="totalPageCount" value="${page.pages}"/>
<c:import url="../rollpage.jsp">
    <c:param name="totalCount" value="${page.total}"/>
    <c:param name="currentPageNo" value="${page.pageNum}"/>
    <c:param name="totalPageCount" value="${page.pages}"/>
</c:import>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
