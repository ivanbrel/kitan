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
                        <h2>Список товара </h2>
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
                            В данной таблице представлен список всего товара </p>
                        <table id="datatable-buttons" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Наименование</th>
                                <th>Модель</th>
                                <th>Цвет</th>
                                <th>Страна</th>
                                <th>Цена</th>
                                <th>Штрихкод</th>
                                <th>Категория</th>
                                <th>Статус</th>
                                <th>Продано</th>
                                <th>Количество</th>
                                <th width="100">Опции</th>
                            </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${product}" var="product">
                                    <tr>
                                        <td>${product.nameProduct}</td>
                                        <td>${product.model}</td>
                                        <td>${product.color}</td>
                                        <td>${product.countryProduct}</td>
                                        <td>${product.price.byRuble}</td>
                                        <td>${product.barcode}</td>
                                        <td>${product.category}</td>
                                        <td>${product.state}</td>
                                        <td>${product.sales}</td>
                                        <td>${product.count}</td>
                                        <td>
                                            <a href="<c:url value='/product/edit/${product.id}'/>" title="Edit" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/product/delete/${product.id}'/>" title="Delete" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/product/add/column/${product.id}'/>" title="Add Column" class="btn btn-default btn-xs">
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