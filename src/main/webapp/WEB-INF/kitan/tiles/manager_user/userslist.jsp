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
                        <h2>Список пользователей </h2>
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
                            В данной таблице представлен список всех пользователей </p>
                        <button style="float: right" type="button" class="btn btn-round btn-info btn-lg" data-toggle="modal" data-target="#myModal">Создать пользователя</button>

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
                            <c:forEach items="${users}" var="user">
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
                                        <a href="<c:url value='/admin/user/edit/${user.id}'/>" title="Edit" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                        </a>
                                        <a href="<c:url value='/admin/user/delete/${user.id}'/>" title="Delete" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                        <a href="<c:url value='/admin/user/reset-password/${user.id}'/>" title="Change password" class="btn btn-default btn-xs">
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

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/admin/user/add" method="POST">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Форма добавления новой категории</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="login" class="control-label col-md-3 col-sm-3 col-xs-12">Логин <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="login" class="form-control col-md-7 col-xs-12" required="required" type="text" name="login">
                            <span id="userLoginFree" class="alert alert-success col-sm-12" style="display:none"></span>
                            <span id="userLoginExist" class="alert alert-danger col-sm-12" style="display:none"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Фамилия <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="lastName" name="lastName" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">Имя <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="firstName" name="firstName" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label col-md-3 col-sm-3 col-xs-12">Пароль <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="password" name="password" class="date-picker form-control col-md-7 col-xs-12" required="required" type="password">
                            <span id="globalError" class="alert alert-danger col-sm-12" style="display:none"></span>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                </div>
                <div class="modal-footer">
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <input type="submit" value="Добавить" class="btn btn-success" />
                            <input type="reset" value="Очистить форму" class="btn btn-default"  />
                            <%--<input type="button" value="Назад" onclick="history.back()" class="btn btn-danger"/>--%>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>