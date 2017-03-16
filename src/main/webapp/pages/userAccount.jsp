<%--
  Created by IntelliJ IDEA.
  User: xugenli
  Date: 2017/3/9
  Time: 上午8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${ctx}"/>
<html>
<head>
    <style type="text/css">
        .item {
            display: inline;
            width: 100px;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
    <script>
        function insertAccount() {
            var basePath = "${basePath}";
            var account = JSON.stringify({name: $("#name").val(), money: $("#money").val()});
            //传递数据的时候必须要所有的值都写全了，不然会报404错误
            //如果想要返回插入对象并且操作dom,需要再进行select，之后返回json就可以了
            $.ajax({
                type: "POST",
                url: "/insert",
                contentType: "application/json; charset=utf-8",
                data: account,
                dataType: "json",
                success: function (data) {
                    alert(data);
                    //location.href = basePath+"/";
                },
                error: function (err) {
                    // alert(err);
                }
            });
        }

        function findAccountByIdRange() {
            var ids = JSON.stringify({beginId: $("#beginId").val(), endId: $("#endId").val()});
           // alert(ids);
            $.ajax({
                type: "POST",
                url: "/findAccounts",
                contentType: "application/json;charset=utf-8",
                data:{beginId:"12",endId:"22"},
                dataType: "json",
                success:function () {
                    alert("ok");
                },
                error: function (err) {
                     alert(err);
                }
            });
        }

    </script>
</head>
<body>
<div >
    <div>
        <div class="item">Id</div>
        <div class="item">Name</div>
        <div class="item">Money</div>
    </div>
    <c:forEach items="${allAccount}" var="allAccount">
        <div >
            <div class="item">${allAccount.id}</div>
            <div class="item">${allAccount.name}</div>
            <div class="item">${allAccount.money}</div>
        </div>
    </c:forEach>
</div>
<div>
    名字：<input type="text" id="name">
    金额：<input type="text" id="money">

    <button id="btn" onclick="insertAccount()">插入</button>
</div>
<div>
    根据id区间查询账户（闭区间） 起始-截止:
    前台验证目前省略
    <input type="text" id="beginId"> - <input type="text" id="endId">

    <button id="findAccountsByIdRange" onclick="findAccountByIdRange()">查询</button>

</div>



</body>
</html>