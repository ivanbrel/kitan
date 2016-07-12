<%--
  Created by IntelliJ IDEA.
  User: ibrel
  Date: 02.05.2016
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- use it for correct load static resourses -->
    <c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
    <%--for client side , ex. ajax in javaScript--%>
    <script>var ctx = "${ctx}";</script>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Список пользователей АС "УСОГДП"</title>
    <link href="${ctx}/resources/img/favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" type="text/css" href="${ctx}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/bootstrap-select.min.css"/>
    <script type="text/javascript" src="${ctx}/webjars/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/jquery.quicksearch.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/bootstrap-select.min.js"></script>
</head>
<body>
<br>
<div class="container">
    <ul class="nav nav-pills">
        <li role="presentation"><li><a href="${ctx}/login">На главную</a></li>
        <li role="presentation"><a href="${ctx}/userslist">Список пользователей</a></li>
        <li role="presentation"><a href="${ctx}/nsi">nsi</a></li>
        <li role="presentation"><a href="${ctx}/roleslist">Управление ролями</a></li>
    </ul>
</div>
<br>
<br>
<div class="container">
    <form:form method="POST" modelAttribute="user">

    <p>
        <label><span>Имя пользователя - </span><span>${user.user}</span></label>
    </p>
    <div>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th></th>
                <th><small>Привилегии</small></th>
                <th width="1000"><small>Описание</small></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${roles}" var="elements" varStatus="loop">
                <tr>
                    <td ><form:checkbox path="roles" class="person_data" value="${elements}"/></td>
                    <td><small><c:out value='${elements.name}' /></small></td>
                    <td><small><c:out value='${elements.privileges}' /></small></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <br>
        <input type="submit" value="Обновить" class="btn btn-success custom-width"/>
        <input type="button" value="Отменить" class="btn" onclick="history.back()">

        <div class="isa_success">
                ${success}
        </div>
        </form:form>

    </div>
</body>
</html>
