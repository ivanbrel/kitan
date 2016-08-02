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
                        <h2>Формирование заказа</h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <div class="alert alert-info alert-dismissible fade in" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
                            </button>
                            Добавте товар к заказу нажав на кнопку  <span class="fa fa-shopping-cart" aria-hidden="true"></span> в опциях к заказу
                        </div>
                        <table class="table table-striped jambo_table bulk_action">
                            <thead>
                            <tr>
                                <th>Номер заказа</th>
                                <th>Дата заказа</th>
                                <th>Клиент</th>
                                <th>Скидка</th>
                                <th>Итоговая цена</th>
                                <th>Итоговое количество</th>
                                <th>Статус</th>
                                <th>Опции</th>
                            </tr>
                            </thead>
                            <tbody>

                                <tr>
                                    <td>${cart.numberCart}</td>
                                    <td>${cart.date}</td>
                                    <td>${cart.client.lastName}</td>
                                    <td>${cart.client.discountPrice}%</td>
                                    <td>${cart.priceSummary}</td>
                                    <td>${cart.quantity}</td>
                                    <td>${cart.status}</td>
                                    <td>
                                        <small>

                                            <a href="<c:url value='/cart/sell/${cart.id}'/>" class="btn btn-default btn-xs">
                                                <span class="fa fa-shopping-cart" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/cart/edit/${cart.id}'/>"  class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/cart/delete/${cart.id}'/>"  class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </a>
                                        </small>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <a href="<c:url value='/cart/status/${cart.id}'/>" class="btn btn-success" style="float: right">Оформить заказ</a>
                        <br>
                        <table id="datatable-buttons" class="table">
                                <thead>
                                <tr>
                                    <th>Дата</th>
                                    <th>Продукт</th>
                                    <th>Цена за ед.</th>
                                    <th>Количество</th>
                                    <th>Цена</th>
                                    <th>Клиент</th>
                                    <th>Скидка</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${history}" var="history">
                                <tr>
                                    <td>${history.date}</td>
                                    <td>${history.product.nameProduct}</td>
                                    <td>${history.product.price}</td>
                                    <td>${history.quantity}</td>
                                    <td>${history.price}</td>
                                    <td>${history.client.lastName}</td>
                                    <td>${history.client.discountPrice}%</td>
                                    <td>
                                        <a href="<c:url value='/cart/delete/product/${cart.id}/${history.id}/${history.product.id}'/>"  class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
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
<!-- /page content -->