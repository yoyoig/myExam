<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/add.css">

    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
      <script type="text/javascript" src="js/handlebars-v4.0.10.js"></script>
    <script type="text/javascript" src="js/myjs.js"></script>
      <script type="text/javascript" src="js/add.js"></script>
    <script type="text/x-handlebars-template" id="add-template">
        {{#each this}}
            <option value="{{languageId}}">
                {{name}}
            </option>
        {{/each}}
    </script>


  </head>
  
  <body background="img/background.jpg">
    <div class="frame">
        <form action="${pageContext.request.contextPath}/film/addFilm" method="post">
            <table class="table">
                <tbody>
                    <tr>
                        <td>电影名</td>
                        <td><input id="nameKey" type="text" name="title"></td>
                        <td colspan="2"><span id="titleIsEx">${err_title}</span></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td >描述</td>
                        <td><textarea id="description" rows="4" style="width: 400px" name="description"></textarea></td>
                        <td colspan="2"><span id="descriptionIsEx">${err_description}</span></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>语言</td>
                        <td>
                            <select  name="languageId" id="languageId">


                            </select>
                        </td>
                        <td colspan="2"><span id="languageIdInfo"></span></td>
                        <td></td>
                    </tr>

                    <tr>

                        <td></td>
                        <td style="color: red">${msg}</td>
                        <td><div style="width: 50px;height: 28px;background: #E8E8E8;text-align: center" ><a href="/film/queryAll">返回</a></div></td>
                        <td><input id="btn" style="width: 50px" type="submit" value="确定"></td>
                    </tr>
                </tbody>

            </table>
        </form>
    </div>
</body>
</html>
