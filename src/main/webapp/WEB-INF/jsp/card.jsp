<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="apple-touch-icon" sizes="76x76" href="/static/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/static/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>机房无人值守系统-机房负责人管理</title>
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
        margin-left: 220px;
        margin-top: 50px;
    }
</style>
<form action="editAdmin" method="post" id="myform">
        <div class="col-md-6 pr-1">
            <div class="form-group">
                <label>负责人姓名</label>
                <input type="text" class="form-control" placeholder="负责人姓名" value="${dataJson.name}" name="name">
            </div>
        </div>
        <div class="col-md-6 pr-1">
            <div class="form-group">
                <label>负责人电话</label>
                <input type="text" class="form-control" placeholder="负责人电话" value="${dataJson.phone}" name="phone">
            </div>
        </div>
        <div class="col-md-6 pr-1">
            <div class="form-group">
                <label>负责机房</label>
                <select style="width: 100%;
    border-color: #e3e3e3;color:#9c9c9c;" name="roomId">
                    <option value="">请选择机房</option>
                    <c:forEach items="${dataJsonss}" var="attr">
                        <option value="${attr.id}">${attr.name}</option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div class="col-md-6 pr-1">
            <div class="form-group">
                <label>账号</label>
                <input type="text" class="form-control" placeholder="账号" value="${dataJson.userName}" name="userName">
            </div>
        </div>
        <div class="col-md-6 pr-1">
            <div class="form-group">
                <label>密码</label>
                <input type="text" class="form-control" placeholder="密码" value="${dataJson.passWord}" name="passWord">
            </div>
        </div>
        <input type="hidden" name="teacherId" value="${dataJson.id}">
    <div class="row">
        <div class="col-md-7">
            <button class="btn btn-primary btn-block" id="add">提交</button>
        </div>
    </div>

</form>
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
    $('#add').click(function(){
        var datas = $('#myform').serialize();
        $.ajax({
            url:'editAdmin',
            data:datas,
            success:function (res) {
                if (res.state =='0') {
                    alert(res.msg);
                }else{
                    alert(res.msg);
                }

                // parent.location.reload();
                return false;
            }

        })
        return false;
    })

</script>
</html>
