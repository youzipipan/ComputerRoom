<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>.
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>机房无人值守系统-警报管理</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/static/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="/static/demo/demo.css" rel="stylesheet" />
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
                <c:if test="${user.userName=='admin'}">
                    <li>
                        <a href="roomManerger">
                            <i class="now-ui-icons business_bank"></i>
                            <p>机房管理</p>
                        </a>
                    </li>
                </c:if>
                <li>
                    <a href="computerManerger">
                        <i class="now-ui-icons education_atom"></i>
                        <p>计算机管理</p>
                    </a>
                </li>
                <li class="active">
                    <a href="warning">
                        <i class="now-ui-icons location_map-big"></i>
                        <p>警报管理</p>
                    </a>
                </li>
                <c:if test="${user.userName=='admin'}">
                    <li>
                        <a href="admin">
                            <i class="now-ui-icons ui-1_bell-53"></i>
                            <p>机房负责人管理</p>
                        </a>
                    </li>
                </c:if>
                <c:if test="${user.userName!='admin'}">
                    <li>
                        <a href="editPass">
                            <i class="now-ui-icons ui-1_bell-53"></i>
                            <p>修改密码</p>
                        </a>
                    </li>
                </c:if>
                <li class="active-pro">
                    <a href="quit">
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
        <!-- <div class="content" style="min-height:0;">
            <div class="row">
                <div class="col-md-2">
                    <button class="btn btn-primary btn-block">一键开机</button>
                </div>
                <div class="col-md-2">
                    <button class="btn btn-primary btn-block"  style="background-color: #ff0000;">一键关机</button>
                </div>
            </div>
        </div> -->
        <div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">待处理警报 <span style="color:#ff0000;">${resCount}</span></h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class=" text-primary">
                                    <th>
                                        编号
                                    </th>
                                    <th>
                                        警报信息
                                    </th>
                                    <th>
                                        处理状态
                                    </th>
                                    <th>
                                        发生警报时间
                                    </th>
                                    <th class="text-right">
                                        操作
                                    </th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${resArr}" var="attr">
                                        <tr>
                                            <td>
                                                    ${attr.id}
                                            </td>
                                            <td>
                                                    ${attr.warnMsg}
                                            </td>
                                            <c:if test="${attr.doState==0}">
                                                <td style="color:#ff0000;">
                                                    未处理
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.doState==1}">
                                                <td style="color:#1beb11;">
                                                    已处理
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.doState==2}">
                                                <td style="color:#f96332;">
                                                    自动处理
                                                </td>
                                            </c:if>
                                            <td>
                                                    ${attr.createTime}
                                            </td>
                                            <td class="text-right">
                                                <c:if test="${user.userName=='admin'}">
                                                    <a href="" class="doSth" id="${attr.id}" data-comId="${attr.computerId}">一键处理</a>
                                                </c:if>
                                                <c:if test="${user.userName!='admin'}">
                                                    无处理权限
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">自动处理警报 <span style="color:#ff9b00;">${resAutoCount}</span></h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class=" text-primary">
                                    <th>
                                        编号
                                    </th>
                                    <th>
                                        警报信息
                                    </th>
                                    <th>
                                        处理状态
                                    </th>
                                    <th>
                                        发生警报时间
                                    </th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${resAutoArr}" var="attr">
                                        <tr>
                                            <td>
                                                    ${attr.id}
                                            </td>
                                            <td>
                                                    ${attr.warnMsg}
                                            </td>
                                            <c:if test="${attr.doState==0}">
                                                <td style="color:#ff0000;">
                                                    未处理
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.doState==1}">
                                                <td style="color:#1beb11;">
                                                    已处理
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.doState==2}">
                                                <td style="color:#f96332;">
                                                    自动处理
                                                </td>
                                            </c:if>
                                            <td>
                                                    ${attr.createTime}
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">已处理警报 <span style="color:green;">${resAlreadyCount}</span></h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class=" text-primary">
                                    <th>
                                        编号
                                    </th>
                                    <th>
                                        警报信息
                                    </th>
                                    <th>
                                        处理状态
                                    </th>
                                    <th>
                                        发生警报时间
                                    </th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${resAlreadyArr}" var="attr">
                                        <tr>
                                            <td>
                                                    ${attr.id}
                                            </td>
                                            <td>
                                                    ${attr.warnMsg}
                                            </td>
                                            <c:if test="${attr.doState==0}">
                                                <td style="color:#ff0000;">
                                                    未处理
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.doState==1}">
                                                <td style="color:#1beb11;">
                                                    已处理
                                                </td>
                                            </c:if>
                                            <c:if test="${attr.doState==2}">
                                                <td style="color:#f96332;">
                                                    自动处理
                                                </td>
                                            </c:if>
                                            <td>
                                                    ${attr.createTime}
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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
    $('.doSth').click(function(){
        var id = $(this).attr("id");
        var computerId = $(this).attr("data-comId");
        $.ajax({
            url:'doWarn',
            data:{
                id:id,
                computerId:computerId
            },
            success:function(res){
                if(res.state=="0"){
                    alert(res.msg);
                }else{
                    alert(res.msg)
                }
                console.log(res);
                location.reload();
            }
        })

    })
</script>
</html>
