
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>排班管理页面</span>
    </div>
    <form action="/addDuty" method="post" id="addDuty">

        <div>
            <label for="dutyMonth">排班日期：</label>
            <input type="text" Class="Wdate" id="dutyMonth" name="dutyMonth"
            readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM'});">
        </div>
        <br>
        <br>
        需值班天数：<input id="dutyDaynum" type="text" readonly = "true">
        <br>
        参与值班人员：<select multiple="multiple"id=" downList" name="user_ids" style="width: 200px">
        <c:forEach items="" var="">
            <option value="">
            </option>
        </c:forEach>
    </select>
        <br>
        <br>

        <!--点击添加人员跳转到添加人员界面-->
        <input  type="button" id="addPerson" value="添加人员" ></input>

        已选：已选人数/排班天数

        <br><br>
        <input type="submit" id="submit" value="提交">
    </form>
</div>
</section>
<%@include file="/WEB-INF/views/common/foot.jsp" %>
