<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/30
  Time: 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>排班管理页面</span>
    </div>

    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/duty/findAll">

            <span>月份:</span>
            <input name="dutyMonth"  id="dutyMonth" class="input-text"	type="text" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM'})">

            <span>姓名</span>
            <input name="username" class="input-text"	type="text" value="${param.queryname}">
            <input type="hidden" name="pageIndex" value="1"/>
            <input	value="查 询" type="submit" id="searchbutton">
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="20%">序号</th>
            <th width="30%">排班日期</th>
            <th width="20%">值班人</th>
            <th width="20%">手机号码</th>
            <th width="30%">职务</th>

        </tr>
        <c:forEach var="duty" items="${page.list}" varStatus="status">
            <tr>
                <td>
                    <span>${status.index + 1}</span>
                </td>
                <td>
                    <span></span>
                </td>
                <td>
                    <span></span>
                </td>
                <td>
                    <span></span>
                </td>
                <td>
                    <span></span>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</section>
<%@include file="/WEB-INF/views/common/foot.jsp" %>