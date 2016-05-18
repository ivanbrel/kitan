<%--
  Created by IntelliJ IDEA.
  User: ibrel
  Date: 29.04.2016
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <script type="text/javascript" src="${ctx}/webjars/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/jquery.quicksearch.js"></script>
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
<div class="container" id="content">
    <h2>Список ролей</h2>
    <div class="well">
        <form action="${ctx}/add-new-role" method="post">
            <div class="col-xs-4">
                <input type="text" class="form-control" name="name" value="" required="required"/>
            </div>
            <input type="submit" class="btn btn-success custom-width" value="Добавить новую роль">
        </form>
    </div>
    <form>
        <div class="col-xs-3">
            <input type="text" class="form-control" id="search" placeholder="Поиск...">
        </div>
    </form>
    <table class="table table-hover">
        <thead>
        <tr>
            <th><small>Роль</small></th>
            <th width="1000"><small>Привилегии</small></th>
            <th width="5"><small></small></th>
            <th width="5"><small></small></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td><small>${role.name}</small></td>
                <td><small>${role.privileges}</small></td>
                <td><a href="<c:url value='/edit-role-${role.name}' />" class="btn btn-success custom-width" data-toggle="tooltip" data-placement="bottom" title="Редактировать роль"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                <td><a href="<c:url value='/delete-role-${role.id}' />" class="btn btn-danger custom-width" data-toggle="tooltip" data-placement="bottom" title="Удалить роль"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $('input#search').quicksearch('table tbody tr');
</script>
</body>
</html>