<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="/static/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/static/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>机房无人值守系统-机房管理</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/static/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="/static/demo/demo.css" rel="stylesheet" />
    <style>
        .back-nav{
            background:rgba(0,0,0,.25);
            position: fixed;
            width:100%;
            height:100%;
            z-index:999;
            top:0;
            display: none;
        }
        .add-nav{
            width: 50rem;
            height: 45rem;
            top: 0;
            margin: auto;
            position: fixed;
            bottom: 0;
            right: 0;
            left: 0;
        }
        .add-body{
            text-align: center;
        }

    </style>
</head>

<body class="">
<div class="wrapper ">
    <div class="sidebar" data-color="orange">
        <!--
    Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
-->
        <div class="logo">
            <a href="#" class="simple-text logo-mini">
                CT
            </a>
            <a href="#" class="simple-text logo-normal">
                无人值守机房管理系统
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li>
                    <a href="index">
                        <i class="now-ui-icons design_app"></i>
                        <p>首页</p>
                    </a>
                </li>
                <li class="active">
                    <a href="computerManerger.html">
                        <i class="now-ui-icons education_atom"></i>
                        <p>机房管理</p>
                    </a>
                </li>
                <li>
                    <a href="warning">
                        <i class="now-ui-icons location_map-big"></i>
                        <p>警报管理</p>
                    </a>
                </li>
                <li>
                    <a href="admin">
                        <i class="now-ui-icons ui-1_bell-53"></i>
                        <p>机房负责人管理</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="#">
                        <i class="now-ui-icons arrows-1_cloud-download-93"></i>
                        <p>管理员退出</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-transparent  navbar-absolute bg-primary fixed-top">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-toggle">
                        <button type="button" class="navbar-toggler">
                            <span class="navbar-toggler-bar bar1"></span>
                            <span class="navbar-toggler-bar bar2"></span>
                            <span class="navbar-toggler-bar bar3"></span>
                        </button>
                    </div>
                    <a class="navbar-brand" href="#">Table List</a>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <form>
                        <div class="input-group no-border">
                            <input type="text" value="" class="form-control" placeholder="Search...">
                            <span class="input-group-addon">
                                    <i class="now-ui-icons ui-1_zoom-bold"></i>
                                </span>
                        </div>
                    </form>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#pablo">
                                <i class="now-ui-icons media-2_sound-wave"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Stats</span>
                                </p>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="now-ui-icons location_world"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Some Actions</span>
                                </p>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#pablo">
                                <i class="now-ui-icons users_single-02"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Account</span>
                                </p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="panel-header panel-header-sm">
        </div>
        <div class="content" style="min-height:0;">
            <div class="row">
                <div class="col-md-2">
                    <button class="btn btn-primary btn-block" id="allkaiji">一键开机</button>
                </div>
                <div class="col-md-2">
                    <button class="btn btn-primary btn-block" style="background-color: #ff0000;" id="allguanji">一键关机</button>
                </div>
            </div>
        </div>
        <div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">计算机列表</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class=" text-primary">
                                    <th>
                                        编号
                                    </th>
                                    <th>
                                        位置
                                    </th>
                                    <th>
                                        温度(80%以上为故障)
                                    </th>
                                    <th>
                                        Cpu使用率(90%以上为故障)
                                    </th>
                                    <th>
                                        使用状态
                                    </th>
                                    <th>
                                        锁定状态
                                    </th>
                                    <th>
                                        最后一次使用时间
                                    </th>
                                    <th class="text-right">
                                        操作
                                    </th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${json}" var="attr">
                                        <tr>
                                            <td>
                                                    ${attr.computerId}
                                            </td>
                                            <td>
                                                    ${attr.room}
                                            </td>
                                            <td>
                                                    ${attr.temperature}%
                                            </td>
                                            <td>
                                                    ${attr.cpu}%
                                            </td>
                                            <c:if test="${attr.useState==1}">
                                                <td style="color:#ff0000">
                                                    正在使用
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.useState==0}">
                                                <td style="color:#1beb11">
                                                    未使用
                                                </td>
                                            </c:if>

                                            <c:if test="${attr.lockState==1}">
                                                <td style="color:#ff0000">
                                                    锁定中
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.lockState==0}">
                                                <td style="color:#1beb11">
                                                    未锁定
                                                </td>
                                            </c:if>
                                            <td>
                                                    ${attr.lastUseState}
                                            </td>
                                            <td class="text-right">
                                                <a href="#" id="${attr.id}" class="kaiji">开/关机</a>
                                                <a href="" class="lock" id="${attr.id}">强制锁机</a>
                                                <a href="#" class="unlock" id="${attr.id}">解锁</a>
                                                <a href="#" class="edit" id="${attr.id}">修改</a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <footer class="footer">
                    <div class="container-fluid">
                        <nav>
                            <ul>
                                <li>
                                    <a href="#">
                                        Creative Tim
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        About Us
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        Blog
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        <div class="copyright">
                            &copy;
                            <script>
                                document.write(new Date().getFullYear())
                            </script>, Designed by
                            Invision. Coded by
                            Creative Tim.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <!-- 新增窗口 -->
        <div class="back-nav">
            <div class="add-nav card">
                <div class="add-body">

                </div>
            </div>
        </div>
</body>

<!--   Core JS Files   -->
<script src="/static/js/core/jquery.min.js"></script>
<script src="/static/js/core/popper.min.js"></script>
<script src="/static/js/core/bootstrap.min.js"></script>
<script src="/static/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->

<!-- Chart JS -->
<script src="/static/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="/static/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="/static/js/now-ui-dashboard.js?v=1.0.1"></script>
<!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
<script src="/static/demo/demo.js"></script>
<script>
    $('.kaiji').click(function(){
        var id = $(this).attr("id");
        $.ajax({
            url:'switchs',
            data:{computerId:id},
            success:function(res){
                if(res.state=="0"){
                    if(res.msg=="开机成功"){
                        alert("开机成功")
                    }else if(res.msg=="关机成功"){
                        alert("关机成功")
                    }
                    location.reload();
                }else{
                    alert(res.msg)
                }
                console.log(res);
                return false;
            }
        })
    })

    $('#allkaiji').click(function(){
        $.ajax({
            url:'allswitchs',
            success:function(res){
                if(res.state=="0"){
                    if(res.msg=="一键开机成功"){
                        alert("一键开机成功")
                        location.reload();
                    }
                }else{
                    alert(res.msg)
                }
                console.log(res);
                return false;
            }
        })
    })

    $('#allguanji').click(function(){
        $.ajax({
            url:'allguanji',
            success:function(res){
                if(res.state=="0"){
                    if(res.msg=="一键关机成功"){
                        alert("一键关机成功")
                        location.reload();
                    }
                }else{
                    alert(res.msg)
                }
                console.log(res);
                return false;
            }
        })
    })

    $('.lock').click(function(){
        var id = $(this).attr("id");
        $.ajax({
            url:'lock',
            data:{id:id},
            success:function(res){
                if(res.state=="0"){
                    alert("下机/锁机成功")
                    location.reload();
                }else{
                    alert(res.msg)
                }
                console.log(res);
                return false;
            }
        })
    })

    $('.unlock').click(function(){
        var id = $(this).attr("id");
        $.ajax({
            url:'unlock',
            data:{id:id},
            success:function(res){
                if(res.state=="0"){
                    alert("解锁成功")
                    location.reload();
                }else{
                    alert(res.msg)
                }
                console.log(res);
                return false;
            }
        })
    })

    $('.edit').click(function(){
        var id = $(this).attr("id");
        $.ajax({
            url:'toEdit',
            data:{id:id},
            success:function(res){
                $('.add-body').html(res);
            },
            error:function(){
                $('.add-body').html("加载失败");
            }

        })

        $('.back-nav').show();


    })

    $(function(){
        $('.back-nav').bind("click", function (e) {
            if($(e.target).closest(".add-nav").length>0){
                $(".back-nav").show();
            }else{
                $(".back-nav").hide();
            }
        });
    });


</script>
</html>
