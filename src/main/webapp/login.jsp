<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <link rel="stylesheet"type="text/css" href="css/mycss.css">
  </head>
  
  <body background="img/background.jpg">
  	<div  style="font-size: 40px;color: white;margin-top: 80px">用户登录</div>
    <div class="frame" >

            <%--<form action="${pageContext.request.contextPath}/customer/customerLogin" class="form-horizontal" method="post">--%>

                 <div class="form-group">
                    <label class="col-sm-3 control-label">用户名:</label>
                    <div class="col-sm-6">
                    <input id="text1" name="firstName" class="form-control text-center" type="text" placeholder="输入用户名">
                    </div>
                </div>


                <div class="form-group col-sm-10">

                <span style="color: red">${msg}</span>
                <input id="login" type="button" class="form-control" value="登录">
                </div>
            <%--</form>--%>



    </div>
  </body>
  <script type="text/javascript">

      $("#login").bind("click",function () {
          var $name = $("#text1").val()
          $.ajax({
              url:"${pageContext.request.contextPath}/customer/customerLogin",
              type: "POST",
              data: {"firstName":$name},
              success: function (result) {
                  if(result.login){

                      window.location.href="${pageContext.request.contextPath}/main.jsp";
                  }else {

                      window.location.href="${pageContext.request.contextPath}/login.jsp";
                  }


              }

          })

      })
  </script>
</html>
