<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Список клиентов </h2>

                        <div class="clearfix"></div>

                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            В данной таблице представлен список всех клиентов </p>

                        <div class="clearfix"></div>

                        <div class="alert alert-info alert-dismissible fade in" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                            </button>
                            Выберите клиента нажатием кнопки <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> в опциях к клиенту
                        </div>
                        <table id="datatable-buttons" class="table table-striped jambo_table bulk_action">
                            <thead>
                            <tr>
                                <th>Фамилия</th>
                                <th>Имя</th>
                                <th>EMAIL</th>
                                <th>Телефон</th>
                                <th>Счёт</th>
                                <th width="120">Опции</th>
                            </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${clients}" var="clients">
                                    <tr>
                                        <td>${clients.lastName}</td>
                                        <td>${clients.firstName}</td>
                                        <td>${clients.email}</td>
                                        <td>${clients.phone}</td>
                                        <td>${clients.account}</td>
                                        <td>
                                            <a href="<c:url value='/client/edit/${clients.id}'/>" title="Edit" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/client/delete/${clients.id}'/>" title="Delete" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/purchase/add/${clients.id}'/>" title="Buy" class="btn btn-default btn-xs">
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

