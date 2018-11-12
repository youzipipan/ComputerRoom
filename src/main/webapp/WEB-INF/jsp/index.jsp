<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="/static/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/static/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>机房管理-总览</title>
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
        .four-grids {
            margin: 2em 0;
        }
        *, :active, :focus, :hover {
            outline: 0!important;
            -webkit-tap-highlight-color: transparent!important;
        }
        .four-grid:nth-child(1) {
            padding-left: 0;
        }
        @media (min-width: 992px)
        .col-md-3 {
            width: 25%;
        }
        .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-md-10, .col-md-11, .col-md-12 {
            float: left;
        }
        .col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2, .col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3, .col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5, .col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6, .col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8, .col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9, .col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11, .col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12 {
            position: relative;
            min-height: 1px;
            padding-right: 15px;
            padding-left: 15px;
        }
        *, a, button, i, input {
            -webkit-font-smoothing: antialiased;
        }
        .four-agileits {
            background: #ff4a43;
            text-align: center;
            padding: 2em 0;
        }
        .four-grid i.glyphicon {
            color: #fff;
            font-size: 32px;
        }
        .four-grid h3 {
            font-size: 20px;
            color: #fff;
            margin: 14px 0;
        }
        .four-grids h4 {
            font-size: 30px;
            color: #fff;
            margin: 0;
        }
        .four-agileinfo {
            background: #22beef;
            padding: 2em 0;
            text-align: center;
        }
        .four-w3ls {
            background: #a2d200;
            padding: 2em 0;
            text-align: center;
        }
        .four-wthree {
            background: #8e44ad;
            padding: 2em 0;
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
                    <li class="active">
                        <a href="">
                            <i class="now-ui-icons design_app"></i>
                            <p>首页</p>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <i class="now-ui-icons education_atom"></i>
                            <p>机房管理</p>
                        </a>
                    </li>
                    <li>
                        <a href="../examples/warn.html">
                            <i class="now-ui-icons location_map-big"></i>
                            <p>警报管理</p>
                        </a>
                    </li>
                    <li>
                        <a href="admin.jsp">
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
            <div class="four-grids">
                <div class="col-md-3 four-grid">
                    <div class="four-agileits">
                        <div class="icon">
                            <i class="now-ui-icons tech_laptop glyphicon"></i>
                        </div>
                        <div class="four-text">
                            <h3>计算机总数/使用数</h3>
                            <h4> 24,420  </h4>

                        </div>

                    </div>
                </div>
                <div class="col-md-3 four-grid">
                    <div class="four-wthree">
                        <div class="icon">
                            <i class="now-ui-icons tech_tv glyphicon"></i>
                        </div>
                        <div class="four-text">
                            <h3>已使用计算机数</h3>
                            <h4>14,430</h4>

                        </div>

                    </div>
                </div>
                <div class="col-md-3 four-grid">
                    <div class="four-agileinfo">
                        <div class="icon">
                            <i class="now-ui-icons business_bulb-63 glyphicon"></i>
                        </div>
                        <div class="four-text">
                            <h3>当天警报数</h3>
                            <h4>15,520</h4>

                        </div>

                    </div>
                </div>
                <div class="col-md-3 four-grid">
                    <div class="four-w3ls">
                        <div class="icon">
                            <i class="now-ui-icons health_ambulance glyphicon"></i>
                        </div>
                        <div class="four-text">
                            <h3>故障计算机数</h3>
                            <h4>12,430</h4>

                        </div>

                    </div>
                </div>

                <div class="clearfix"></div>
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
    $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js
        demo.initDashboardPageCharts();
    });
</script>

</html>
