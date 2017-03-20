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
<html>
<head>
    <style type="text/css">
        .item {
            display: inline;
            width: 100px;
        }
    </style>
    <%--这块要写绝对路径，如果写../js/jquery的话，springMVC返回的时候会找不到文件--%>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script>
        function insertAccount() {
            var account = JSON.stringify({name: $("#name").val(), money: $("#money").val()});
            //传递数据的时候必须要所有的值都写全了，不然会报404错误
            //如果想要返回插入对象并且操作dom,需要再进行select，之后返回json就可以了
            $.ajax({
                type: 'POST',
                url: '/insert',
                contentType: 'application/json; charset=utf-8',
                data: account,
              //  dataType: 'json',
                success: function (data) {
                    //返回插入数据的主键
                    alert(1);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                },
            });
        }

        function updateAccount(id, name, money) {
            //html方法中传入的是字符串需要用''包裹起来
            var account = JSON.stringify({
                id: $("#" + id).val(),
                name: $("#" + id + "_name").val(),
                money: $("#" + id + "_money").val()
            });
            $.ajax({
                type: 'post',
                url: '/update',
                contentType: 'application/json; charset=utf-8',
                data: account,
                dataType: 'json',
                success: function (data) {
                    //  alert("success");
                },
                error: function (err) {
                    // alert(err);
                }

            });
        }

        function findAccounts() {
            var beginId = $("#beginId").val();
            var endId = $("#endId").val();
            if (beginId == "") {
                beginId = 0;
            }
            if (endId == "") {
                endId = 9999;
            }
            location.href = "/findAccounts/" + beginId + "/" + endId;
        }

        function deleteAccount(id) {
            location.href = "/delete/" + id;
        }


    </script>
</head>
<body>
<div>
    根据id区间查询账户（闭区间） 起始-截止:
    前台验证目前省略
    <input type="text" id="beginId"> - <input type="text" id="endId">
    <button id="findIds" onclick="findAccounts()">查询</button>

    <div>
        <div class="item">Id</div>
        <div class="item">Name</div>
        <div class="item">Money</div>
        <div class="item">提交</div>
    </div>

    <c:forEach items="${allAccount}" var="allAccount">
        <div>
            <div class="item"><input id="${allAccount.id}" value="${allAccount.id}" disabled="true"></div>
            <div class="item"><input id="${allAccount.id}_name" value="${allAccount.name}"></div>
            <div class="item"><input id="${allAccount.id}_money" value="${allAccount.money}"></div>
            <div class="item">
                <button id="update" onclick="updateAccount(${allAccount.id},'${allAccount.name}',${allAccount.money})">
                    更新
                </button>
            </div>
            <div class="item">
                <button id="delete" onclick="deleteAccount(${allAccount.id})">删除</button>
            </div>
        </div>
    </c:forEach>
</div>
<div>
    名字：<input type="text" id="name">
    金额：<input type="text" id="money">
    <button id="btn" onclick="insertAccount()">插入</button>
</div>
</body>
</html>