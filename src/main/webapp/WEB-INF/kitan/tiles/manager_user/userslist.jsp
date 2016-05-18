<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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