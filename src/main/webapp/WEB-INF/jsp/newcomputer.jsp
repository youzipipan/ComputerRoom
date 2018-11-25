<%--
  Created by IntelliJ IDEA.
  User: Yanjinzhu
  Date: 2018/11/21
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>新建模拟计算机</title>
    <meta charset=utf-8>
    <meta name=description content="">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <style type="text/css">
        .inp{
            height:3rem;
            background:#fff;
            border:1px solid #d2d2d2;
            border-radius:10px;
            margin:1rem;
            width: 70%;
            font-size:1.2rem;
            outline:none;
        }
        .position{
            font-size:1rem;
            margin-top:1rem;
        }
        .btn{
            background:#ffa172;
            height:3.3rem;
            width:70%;
            border:1px solid #d2d2d2;
            border-radius:10px;
            outline:none;
            transition:.2s;
            color:#fff;
        }
        .btn:active{
            background: #de8b62;
            transition:.2s;
        }

    </style>
</head>
<body>
<div class="nav">
    <div class="title">
        <img src="/static/img/back.png" alt="" class="back" onclick="javascript:history.back(-1);">
        新建模拟计算机
    </div>
    <form action="newComputer" method="post" id="myform">
        <div class="content">
            <div class="position">
                选择创建位置
            </div>

            <select name="roomId" class="inp" >
                <option value="">选择教室</option>
                <c:forEach items="${strroomList}" var="attr">
                    <option value="${attr.id}">${attr.name}</option>
                </c:forEach>
            </select>

            <input type="button" name="" class="btn" value="模拟一个计算机">
        </div>
    </form>
</div>

</body>
<script src="/static/js/core/jquery.min.js"></script>
<script>
    $('.btn').click(function(){
        var action = $("#myform").attr("action");
        var datas = $("#myform").serialize();
        $.ajax({
            url:action,
            data:datas,
            success:function(res){
                if(res.state==0){
                    alert("模拟计算机创建成功");
                }else{
                    alert(res.msg);
                }
                console.log(res)
                return false;
            }
        })
    })
</script>
</html>