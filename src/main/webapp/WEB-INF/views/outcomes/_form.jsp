<%--
  Created by IntelliJ IDEA.
  User: Sinner
  Date: 2017/5/2
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/outcomes/createOutcome" method="POST">
    <div class="form-body">
        <div class="field">
            <label for="taxId">发票号</label>
            <input type="text" id="taxId" name="taxId" placeholder="请输入发票号">
        </div>
        <div class="field">
            <label for="outType">品种</label>
            <input type="text" id="outType" name="outType" placeholder="请输入品种">
        </div>
        <div class="field">
            <label for="money">销项额</label>
            <input type="text" id="money" name="money" placeholder="请输入销项额">
        </div>
        <div class="field">
            <label for="money">时间</label>
            <input type="text" id="created_at" name="created_at" placeholder="请输入时间">
        </div>
    </div>
    <div class="form-footer">
        <input type="submit" value="提交">
    </div>
</form>


