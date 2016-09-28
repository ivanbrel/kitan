<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                        <c:choose>
                            <c:when test="${fail}">
                                <div class="alert alert-danger">
                                    <strong><spring:message code="error"/></strong><spring:message code="exception.message.limitquantity"/>
                                </div>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                        <%--<button type="button" onClick ="$('#mainTable').tableExport({type:'excel',escape:'false'});$('#chilTable').tableExport({type:'excel',escape:'false'});">EXCEL</button>--%>
                    <div class="x_content">
                        <div class="col-xs-6">
                            <p class="lead">Дата заказа - ${cart.date}</p>
                            <div class="table-responsive">
                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <th style="width:50%">Номер заказа:</th>
                                        <td>${cart.numberCart}</td>
                                    </tr>
                                    <tr>
                                        <th>Клиент</th>
                                        <td>${cart.client.lastName}</td>
                                    </tr>
                                    <tr>
                                        <th>Персональная скидка</th>
                                        <td>${cart.client.discountPrice}%</td>
                                    </tr>
                                    <tr>
                                        <th>Итоговое количество</th>
                                        <td>${cart.quantity}</td>
                                    </tr>
                                    <tr>
                                        <th>Итоговая цена</th>
                                        <td>$${cart.priceSummary}</td>
                                    </tr>
                                    <tr>
                                        <th>Статус заказа</th>
                                        <td style="width:50%; color: red">${cart.status}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="col-xs-6" style="padding-top: 10%">
                            <button style="width: 100%" type="button" class="btn btn-round btn-info btn-lg" data-toggle="modal" data-target="#myModal">Оформить заказ</button>
                            <a href="<c:url value='/cart/sell/${cart.id}'/>" style="width: 100%" type="button" class="btn btn-round btn-success btn-lg"> <span class="fa fa-shopping-cart" aria-hidden="true"></span> Добавить товар</a>
                            <%--<a href="<c:url value='/cart/edit/${cart.id}'/>"style="width: 100%" class="btn btn-round btn-info btn-lg"><i class="fa fa-pencil"></i> Edit </a>--%>
                            <%--<a href="<c:url value='/cart/report/${cart.id}'/>" style="width: 100%" class="btn btn-info btn-lg"><i class="fa fa-pencil"></i> report </a>--%>
                            <a href="<c:url value='/cart/delete/${cart.id}'/>" style="width: 100%" class="btn btn-round btn-danger btn-lg"><i class="fa fa-trash-o"></i> Удалить заказ </a>
                        </div>
                        <table id="chilTable" class="table table-striped jambo_table bulk_action">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Дата добавления</th>
                                    <th>Категория</th>
                                    <th>Продукт</th>
                                    <th>Модель</th>
                                    <th>Цвет</th>
                                    <th>Цена(без скидки)</th>
                                    <th>Кол.</th>
                                    <th>Итого</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${history}" var="history">
                                <tr>
                                    <td>
                                        <a href="<c:url value="/resources/img/upload/product/${history.product.image.fileName}"/>" data-toggle="lightbox" data-title="${product.nameProduct}" data-footer="${product.price}">
                                            <img src="<c:url value="/resources/img/upload/product/${history.product.image.fileName}"/>" class="avatar">
                                        </a>
                                    </td>
                                    <td>${history.date}</td>
                                    <td>${history.product.category.name}</td>
                                    <td>${history.product.nameProduct}</td>
                                    <td>${history.product.model}</td>
                                    <td>${history.product.color}</td>
                                    <td>$${history.product.price}</td>
                                    <td>${history.quantity}</td>
                                    <td>$${history.price}</td>
                                    <td>
                                        <a href="<c:url value='/cart/delete/product/${cart.id}/${history.id}/${history.product.id}'/>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Удалить </a>
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

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Подтверждение заказа</h4>
            </div>
            <div class="modal-body">
                <p>После подтверждения, заказ сменит свой статус, а так же будет сформирован отчёт!</p>
            </div>
            <div class="modal-footer">
                <a href="<c:url value='/cart/status/${cart.id}'/>" class="btn btn-success">Подтверрдить</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
            </div>
        </div>

    </div>
</div>