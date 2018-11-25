<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>模拟场景</title>
    <meta charset=utf-8>
    <meta name=description content="">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <style>
        .room{
            width:5rem;
            height:5rem;
            background: #ffb2b2;
            float:left;
            margin:0.5em 0.5rem;
            border-radius:10px;
            line-height:5rem;
            color:#fff;
            box-shadow: 3px 2px 2px rgba(119, 114, 114, 0.25);
            transition:.2s;
        }
        .room:active{
            background: #eca6a6;
            transition:.2s;
        }
        .content{
            padding-top:1rem;
            padding-left:1rem;
        }


    </style>
</head>
<body>
<div class="nav">
    <div class="title">
        <img src="/static/img/back.png" alt="" class="back" onclick="javascript:history.back(-1);">
        模拟场景
    </div>
    <div class="content">
        <c:forEach items="${roomList}" var="attr">
            <div class="room" id="${attr.id}">
                ${attr.name}
            </div>
        </c:forEach>
    </div>
</div>
</body>
<script src="/static/js/core/jquery.min.js"></script>
<script>
    $('.room').click(function(){
        var id = $(this).attr("id");
        location.href="computerByRoomId?id="+id+"";
    })
</script>
</html>