<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    
    <title>电影信息查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/myjs.js"></script>
    <script type="text/javascript" src="js/handlebars-v4.0.10.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
      <script type="text/x-handlebars-template" id="main-template">
          {{#each list}}
              <tr>
                  <td style="width: 50px;">{{filmId}}</td>
                  <td style="width: 80px;">{{title}}</td>
                  <td style="width: 350px;">{{description}}</td>
                  <td>{{language}}</td>
                  <td><a href="/film/toEditFilm?filmId={{filmId}}">编辑</a></td>
                  <td><a href="/film/deleFilm?filmId={{filmId}}">删除</a></td>
              </tr>
          {{/each}}
          <tr>
              <td style="width: 50px;"><input type="text" name="currentPage" id="skipPage" ></td>
              <td style="width: 80px;"><input type="button" value="跳转" id="skip" ></td>
              <td style="width: 350px;">当前/总页：{{currentPage}}/{{totalPage}}
                  <a class="prePage"><input type="hidden" value="{{prePage}}">上一页</a>
                  <a class="nextPage"><input type="hidden" value="{{nextPage}}">下一页</a>
              </td>
              <td><a class="firstPage">首页</a></td>
              <td><a class="endPage"><input type="hidden" value="{{totalPage}}">末页</a></td>
              <td></td>
          </tr>
       </script>




  </head>
  
  <body background="img/background.jpg">


    <div class="left">

        <ul>
            <li>
                <div id="items" >电影列表</div>
            </li>
            <li>
                <div id="info" >个人信息维护</div>
            </li>
        </ul>
    </div>
    <div id="itemsDiv" class="right"  >
        <form id="itemsForm" method="post">
            <div class="head">
                <input id="addItem" type="button" value="新增">
                <div style="float: right;width: 50px;height: 28px;background: #E8E8E8;text-align: center" ><a href="/customer/customerLogout">注销</a></div>
                <label style="float: right;margin-right: 20px">欢迎您,${customerLogin.firstName}&nbsp;${customerLogin.lastName}</label>

            </div>

            <table class="table" id="main">
                <tr>
                    <td>id</td>
                    <td>电影名</td>
                    <td>描述</td>
                    <td>语言</td>
                    <td>编辑</td>
                    <td>删除</td>
                </tr>
                <tbody id="main_template">

               </tbody>
            </table>
        </form>
    </div>

    <div id="personDiv" class="right person" style="display: none">
        <form action="${pageContext.request.contextPath }/customer/customerUpdate" method="post">
            <table class="table" style="margin-left: 30px">
                <tbody id="info_update">
                    <tr>
                        <td colspan="4"  style="border-bottom: 1px solid black">基本信息</td>
                        <td><input type="hidden" name="customerId" value="${customerLogin.customerId}"></td>
                    </tr>
                    <tr>
                        <td>用户名：</td>
                        <td>${customerLogin.firstName}&nbsp;${customerLogin.lastName}</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>邮件</td>
                        <td><input id="email" name="email" type="text" value="${customerLogin.email}"></td>
                        <td>地址</td>
                        <td>${customerLogin.address}</td>
                    </tr>
                    <tr>
                        <td colspan="2" ><span style="color: red" id="emailInfo"></span></td>
                        <td></td>
                        <td colspan="2"><span id="addressInfo"></span></td>
                        <td></td>
                    </tr>
                    <tr>
                    	<td>创建日期</td>
                        <td><fmt:formatDate value='${customerLogin.createDate}' pattern='yyyy-MM-dd hh:mm:ss'/></td>
                        <td>更新日期</td>
                        <td><fmt:formatDate value='${customerLogin.lastUpdate}' pattern='yyyy-MM-dd hh:mm:ss'/></td>
                    </tr>
                    <tr>
                        <td></td><td colspan="2"><span id="createDateInfo"></span></td>
                        <td></td>
                        <td></td><td colspan="2"><span id="lastUpdateInfo"></span></td>
                        <td></td>
                    </tr>
                    <tr>
                    	
                        <td style="color: red">${msg}</td>
                        
                        <td><input id="btn" type="submit" value="修改"></td>

                    </tr>
                    
                </tbody>
            </table>
        </form>



    </div>

    <div></div>
</body>
</html>
