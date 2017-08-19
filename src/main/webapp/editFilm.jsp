<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>用户修改</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/add.css">

    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/myjs.js"></script>

</head>

<body background="img/background.jpg">
<div class="frame">
    <form action="${pageContext.request.contextPath}/film/editFilm" method="post">
        <table class="table">
            <tbody>

            <tr>
                <td>电影名</td>
                <td><input id="nameKey" type="text" name="title" value="${film.title}"></td>
                <td colspan="2"><span id="titleIsEx"></span></td>
                <td></td>
            </tr>
            <tr>
                <td >描述</td>
                <td><textarea id="description" rows="4" style="width: 400px"  name="description" >${film.description}</textarea></td>
                <td colspan="2"><span id="descriptionIsEx"></span></td>
                <td></td>
            </tr>

            <tr>
                <td>语言</td>
                <td>
                    <select name="languageId" id="languageId">
                        <c:choose>
                            <c:when test="${film.language == 'English'}">
                                <option value="1" selected="selected">
                                    English
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="1">
                                    English
                                </option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${film.language == 'Italian'}">
                                <option value="2" selected="selected">
                                    Italian
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="2">
                                    Italian
                                </option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${film.language == 'Japanese'}" >
                                <option value="3" selected="selected">
                                    Japanese
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="3">
                                    Japanese
                                </option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${film.language == 'Mandarin'}">
                                <option value="4" selected="selected">
                                    Mandarin
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="4">
                                    Mandarin
                                </option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${film.language == 'French'}">
                                <option value="5" selected="selected">
                                    French
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="5">
                                    French
                                </option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${film.language == 'German'}">
                                <option value="6" selected="selected">
                                    German
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="6">
                                    German
                                </option>
                            </c:otherwise>
                        </c:choose>




                    </select>
                </td>
                <td colspan="2"><span id="languageIdInfo"></span></td>
                <td></td>
            </tr>
            <tr>

                <td><input type="hidden" name="filmId" value="${film.filmId}"></td>
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
