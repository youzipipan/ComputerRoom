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
            font-size: 15px;
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
            font-size:20px;
            color:#fff;
        }
    </style>
</head>
<body>
    <div class="login-nav">
        <div class="title">管理员登录</div>
        <label>教师/管理员账号：</label>
        <div class="input-nav">
            <input class="inp">
        </div>
        <label>密码：</label>
        <div class="input-nav">
            <input class="inp">
        </div>
        <div>
            <input type="submit" value="登录" class="sub">
        </div>
    </div>
</body>
</html>
