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
    <h2>Список пользователей</h2>
    <div class="well">
        <a href="<c:url value='/registrationpage'/>">Добавить нового пользователя</a>
    </div>
        <form>
            <div class="col-sm-3">
                <input type="text" id="search" class="form-control" placeholder="Поиск...">
            </div>
        </form>
        <table class="table table-hover">

            <thead>
            <tr>
                <th><small>Имя</small></th>
                <th><small>Фамилия</small></th>
                <th><small>Отчество</small></th>
                <th><small>Предпри.</small></th>
                <%--<th><small>Индекс</small></th>--%>
                <th><small>Рабочий тел.</small></th>
                <th><small>Личный тел.</small></th>
                <th><small>Email</small></th>
                <th><small>Логин</small></th>
                <th><small>Роль</small></th>
                <th width="1"></th>
                <th width="1"></th>
                <th width="1"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><small>${user.firstName}</small></td>
                    <td><small>${user.lastName}</small></td>
                    <td><small>${user.patronymicName}</small></td>
                    <td><small>${user.company}</small></td>
                    <%--<td><small>${user.index}</small></td>--%>
                    <td><small>${user.workPhone}</small></td>
                    <td><small>${user.privatePhone}</small></td>
                    <td><small>${user.email}</small></td>
                    <td><small>${user.user}</small></td>
                    <td><small>${user.roles}</small></td>
                    <td><a href="<c:url value='/edit-user-${user.user}' />" class="btn btn-success custom-width" data-toggle="tooltip" data-placement="bottom" title="Редактировать пользователя"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td><a href="<c:url value='/change-password-${user.user}'/>" class="btn btn-info custom-width" data-toggle="tooltip" data-placement="bottom" title="Сбросить пароль"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></a></td>
                    <td><a href="<c:url value='/delete-user-${user.id}' />" class="btn btn-danger custom-width" data-toggle="tooltip" data-placement="bottom" title="Удалить пользователя"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
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