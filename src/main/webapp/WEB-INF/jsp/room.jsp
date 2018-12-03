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
        .boxshadow{
            position: absolute;
            height:100%;
            width:100%;
            background: rgba(0,0,0,.5);
            top:0;
            display: none;
        }
        .box{
            border-radius: 20px;
            background: #fff;
            position: absolute;
            height:215px;
            width:200px;
            margin:auto;
            top:0;
            bottom:0;
            left:0;
            right:0;
        }
        .box-title{
            text-align: center;
            padding:40px 0;

        }
        .choose{
            border-radius: 0 0 20px 20px;
            height:50px;
            width:100%;
        }
        .ee{
            float: left;
            width:50%;
            text-align: center;
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
                    <img class="roomimg" src="/static/img/down.png" data="0">
                </c:if>
                <c:if test="${attr.useState=='1' && attr.lockState=='0'}" >
                    <img class="roomimg" src="/static/img/up.png" data="1">
                </c:if>
                <c:if test="${attr.useState=='1' && attr.lockState=='1'}">
                    <img class="roomimg" src="/static/img/lock.png" data="2">
                </c:if>
                <div class="room-title">${attr.computerId}</div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="boxshadow">
    <div class="box">
        <div class="box-title">
            <div>负责人账号：<input type="text" name="userName" id="userName"></div>
            <div>负责人密码：<input type="password" name="passWord" id="passWord"></div>
        </div>
        <div class="choose">
            <div class="choose-close ee" data="">关机</div>
            <div class="choose-unlock ee" data="">解锁</div>
        </div>
    </div>
</div>
</body>
<script src="/static/js/core/jquery.min.js"></script>
<script>
    $('.choose-close').click(function () {
        var id = $(this).attr("data");
        $.ajax({
            url:'switchs',
            data:{computerId:id},
            success:function(res){
                if(res.state=="0"){
                    if(res.msg=="开机成功"){
                        $('#'+id).children('.roomimg').attr("src","/static/img/up.png");
                        $('#'+id).children('.roomimg').attr("data","0");
                    }else if(res.msg=="关机成功"){
                        $('#'+id).children('.roomimg').attr("src","/static/img/down.png")
                        $('#'+id).children('.roomimg').attr("data","1");
                    }
                    alert(res.msg)
                }else if (res.state=="2"){
                    $('#'+id).children('.roomimg').attr("src","/static/img/lock.png");
                    $('#'+id).children('.roomimg').attr("data","2");
                    alert(res.msg+"，已被锁机");
                } else{
                    alert(res.msg)
                }
                console.log(res);

                $('.boxshadow').hide();
            }
        })

    })

    $('.choose-unlock').click(function () {

        var id = $(this).attr("data");
        var userName = $('#userName').val();
        var passWord = $('#passWord').val();
        $.ajax({
            url:'unlock',
            data:{
                computerId:id,
                userName:userName,
                passWord:passWord
            },
            success:function(res){
                if(res.state=="0"){
                    if(res.msg=="解锁成功"){
                        $('#'+id).children('.roomimg').attr("src","/static/img/up.png");
                        $('#'+id).children('.roomimg').attr("data","0");
                    }
                    alert(res.msg)
                }else{
                    alert(res.msg)
                }
                console.log(res);
                $('.boxshadow').hide();
            }
        })

    })

    $('.room').click(function(){
        var data = $(this).children('.roomimg').attr("data");
        var id = $(this).attr("id");
        if (data == '2'){
            $('.ee').attr("data",id);
            $('.boxshadow').show();
            return false;
        }
        $.ajax({
            url:'switchs',
            data:{computerId:id},
            success:function(res){
                if(res.state=="0"){
                    if(res.msg=="开机成功"){
                        $('#'+id).children('.roomimg').attr("src","/static/img/up.png");
                        $('#'+id).children('.roomimg').attr("data","0");
                    }else if(res.msg=="关机成功"){
                        $('#'+id).children('.roomimg').attr("src","/static/img/down.png")
                        $('#'+id).children('.roomimg').attr("data","1");
                    }
                    alert(res.msg)
                }else if (res.state=="2"){
                    $('#'+id).children('.roomimg').attr("src","/static/img/lock.png");
                    $('#'+id).children('.roomimg').attr("data","2");
                    alert(res.msg+"，已被锁机");
                } else{
                    alert(res.msg)
                }
                console.log(res);
            }
        })
    })
</script>
</html>