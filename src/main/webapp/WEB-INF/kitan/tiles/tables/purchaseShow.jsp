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
                                <th>Продукты</th>
                                <th>Клиент</th>
                                <th>Итоговая цена</th>
                                <th>Итоговое количество</th>
                                <th>Опции</th>
                            </tr>
                            </thead>
                            <tbody>

                                <tr>
                                    <td>${purchases.numberPurchase}</td>
                                    <td>${purchases.date}</td>
                                    <td>${purchases.products}</td>
                                    <td>${purchases.client.lastName}</td>
                                    <td>${purchases.priceSummary}</td>
                                    <td>${purchases.countSummary}</td>
                                    <td>
                                        <small>

                                            <a href="<c:url value='/purchase/sell/${purchases.id}'/>" class="btn btn-default btn-xs">
                                                <span class="fa fa-shopping-cart" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/purchase/edit/${purchases.id}'/>"  class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/purchase/delete/${purchases.id}'/>"  class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </a>
                                        </small>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- /page content -->