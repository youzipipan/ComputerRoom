<%--
  Created by IntelliJ IDEA.
  User: Yanjinzhu
  Date: 2018/12/3
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <meta charset="utf-8" />
    <style>
        body{
            background: #f96332;
        }
        .login-nav{
            height:450px;
            width:600px;
            background: #fff;
            border-radius: 20px;
            box-shadow: 1px 0px 20px 0 rgba(0, 0, 0, 0.6);
            position: absolute;
            margin:auto;
            top:0;
            bottom:0;
            left:0;
            right:0;
        }
        .title{
            color:#f96332;
            height:100px;
            width:100%;
            text-align: center;
            line-height: 100px;
            font-weight: bold;
            font-size: 28px;
        }
        .inp{
            border-radius: 8px;
            border: 1px solid #bfbfbf;
            height: 54px;
            width: 80%;
            font-size: 20px;
            outline:none;
            padding:0 10px;
        }
        .input-nav{
            text-align: center;
            margin-top: 10px;
        }
        label{
            font-size: 17px;
            color: #f96332;
            margin-left: 62px;
            margin-top:10px;
        }
        .sub{
            background: #f96332;
            font-size: 20px;
            color: #fff;
            width: 80%;
            border-radius: 8px;
            height: 54px;
            border:none;
            outline:none;
            transition: .2s;
        }
        .sub:hover{
            background: #ff7e54;
            font-size: 20px;
            color: #fff;
            width: 80%;
            border-radius: 8px;
            height: 54px;
            border:none;
            outline:none;
            transition: .2s;
        }
        .sub:active{
             background: #ce5730;
             font-size: 20px;
             color: #fff;
             width: 80%;
             border-radius: 8px;
             height: 54px;
             border:none;
             outline:none;
             transition: .2s;
         }

    </style>
</head>
<body>
    <div class="login-nav">
        <form action="enter" method="post" id="myform">
            <div class="title">管理员登录</div>
            <label>教师/管理员账号：</label>
            <div class="input-nav">
                <input class="inp" type="text" name="userName" id="userName">
            </div>
            <label>密码：</label>
            <div class="input-nav">
                <input class="inp" type="password" name="passWord" id="passWord">
            </div>
            <div style="text-align: center;margin-top:20px;">
                <input type="submit" value="登录" class="sub" >
            </div>
        </form>
    </div>
<script src="/static/js/core/jquery.min.js"></script>
<script>
    $(function (){
        $('.inp').blur(function (){
            var i = $(this).val();
            if (i.trim() == ''){
                $(this).css("border","1px solid red");
                return false;
            }else{
                $(this).css("border","1px solid #bfbfbf");
            }

        })

        $('#myform').submit(function () {
            var i = $('#userName').val();
            var k = $('#passWord').val();
            if (i.trim() == ''){
                $('.inp').css("border","1px solid red");
                return false;
            }else{
                $('.inp').css("border","1px solid #bfbfbf");
            }
            if (k.trim() == ''){
                $('.inp').css("border","1px solid red");
                return false;
            }else{
                $('.inp').css("border","1px solid #bfbfbf");
            }
        })
    })
</script>
</body>
</html>
