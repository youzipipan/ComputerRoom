<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>5教301</title>
    <meta charset=utf-8>
    <meta name=description content="">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <style>
        .room{
            width:5rem;
            height:6.5rem;
            float:left;
            margin:0.5em 0.5rem;
            border-radius:10px;
            line-height:5rem;
            color:#fff;
            box-shadow: 3px 2px 2px rgba(119, 114, 114, 0.25);
            transition:.2s;
            position: relative;
        }
        .roomimg{
            width:5rem;
            height:5.5rem;
        }
        .room:active{
            background: #eca6a6;
            transition:.2s;
        }
        .content{
            padding-top:1rem;
            padding-left:1rem;
        }
        .room-title{
            position: absolute;
            bottom:0;
            left:0;
            right:0;
            margin:0 auto;
            color: #8c8c8c;
            height: 3.5rem;
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
        <c:forEach items="${computerList}" var="attr">
            <div class="room" id="${attr.id}">
                <c:if test="${attr.useState=='0'}">
                    <img class="roomimg" src="/static/img/down.png">
                </c:if>
                <c:if test="${attr.useState=='1'}">
                    <img class="roomimg" src="/static/img/up.png">
                </c:if>
                <div class="room-title">${attr.computerId}</div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
<script src="/static/js/core/jquery.min.js"></script>
<script>
    $('.room').click(function(){
        var id = $(this).attr("id");
        $.ajax({
            url:'switchs',
            data:{computerId:id},
            success:function(res){
                if(res.state=="0"){
                    if(res.msg=="开机成功"){
                        $('#'+id).children('.roomimg').attr("src","/static/img/up.png");
                    }else if(res.msg=="关机成功"){
                        $('#'+id).children('.roomimg').attr("src","/static/img/down.png")
                    }
                    alert(res.msg)
                }else{
                    alert(res.msg)
                }
                console.log(res);
            }
        })
    })
</script>
</html>