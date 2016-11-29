<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Список клиентов </h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Settings 1</a>
                                    </li>
                                    <li><a href="#">Settings 2</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            В данной таблице представлен список всех клиентов </p>
                        <table id="datatable-buttons" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Логин</th>
                                <th>Имя</th>
                                <th>Фамилия</th>
                                <th>Email</th>
                                <th>Телефон</th>
                                <th>Роль</th>
                                <th width="100">Опции</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${list}" var="user">
                                <tr>
                                    <td>
                                        <a href="<c:url value="/resources/img/upload/avatar/${user.image.fileName}"/>" data-toggle="lightbox" data-title="${product.nameProduct}" data-footer="${product.price}">
                                            <img src="<c:url value='/user/image/${user.id}'/>" class="avatar">
                                        </a>
                                    </td>
                                    <td>${user.login}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td>${user.phone}</td>
                                    <td>
                                        <c:forEach items="${user.roles}" var="roles">
                                            ${roles.name}
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <a href="<c:url value='/user/edit/${user.login}'/>" title="Edit" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                        </a>
                                        <a href="<c:url value='/user/delete/${user.id}'/>" title="Delete" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                        <a href="<c:url value='/user/change-password/${user.login}'/>" title="Change password" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>