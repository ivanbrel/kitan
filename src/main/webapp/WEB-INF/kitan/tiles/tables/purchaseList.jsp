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
                        <h2>Список заказов </h2>
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
                            В данной таблице представлен список всех заказов  </p>
                        <table id="datatable-buttons" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Номер заказа</th>
                                <th>Дата заказа</th>
                                <th>Продукты</th>
                                <th>Клиент</th>
                                <th>Итоговая цена</th>
                                <th>Итоговое количество</th>
                                <th>Опции</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${purchases}" var="purchases">
                                <tr>
                                    <td>${purchases.numberPurchase}</td>
                                    <td>${purchases.date}</td>
                                    <td>${purchases.products}</td>
                                    <td>${purchases.client.lastName}</td>
                                    <td>${purchases.priceSummary}</td>
                                    <td>${purchases.countSummary}</td>
                                    <td>
                                        <small>
                                        <%--<a href="<c:url value='/client/edit/${product.id}'/>" title="Edit" class="icon-1 info-tooltip"></a>--%>
                                            <a href="<c:url value='/purchase/sell/${purchases.id}'/>" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/purchase/delete/${purchases.id}'/>"  class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </a>
                                        </small>
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
<!-- /page content -->