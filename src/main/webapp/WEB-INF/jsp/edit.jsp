<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <div style="padding:20px 0;color:#ff0000;font-size:20px;">请选择放入教室</div>
    <c:forEach items="${j}" var="attr">
        <div style="padding:10px">
            <a href="${id}" id="${attr.id}" class="aa">${attr.name}</a>
        </div>
    </c:forEach>
</div>
<script src="/static/js/core/jquery.min.js"></script>
<script>
    $(function(){
        $('.aa').click(function(){
            var comId = $(this).attr("href");
            var roomId = $(this).attr("id");
            $.ajax({
                url:'edit',
                data:{
                    "comId":comId,
                    "roomId":roomId
                },
                success:function(res){
                    alert("更改成功");
                }
            })
            location.reload();
            parent.location.reload();
            return false;
        })
    })
</script>
</body>
</html>
