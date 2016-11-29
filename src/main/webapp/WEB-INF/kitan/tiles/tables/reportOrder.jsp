<%--
  Created by IntelliJ IDEA.
  User: ibrel
  Date: 16.09.2016
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="row">
            <div class="col-md-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Формирование отчёта</h2>
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

                        <section class="content invoice">
                            <!-- title row -->
                            <div class="row">
                                <div class="col-xs-12 invoice-header">
                                    <h1>
                                        <i class="fa fa-globe"></i> Детали заказа
                                        <small class="pull-right">Дата заказа: ${cart.date}</small>
                                    </h1>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- info row -->
                            <div class="row invoice-info">
                                <div class="col-sm-4 invoice-col">
                                    Продавец
                                    <address>
                                        <strong>Kitan Company</strong>
                                        <br>ул. Чонгарской дивизии 6
                                        <br>Гомель, Беларусь, 246007
                                        <br>Телефон: 1 (804) 123-9876
                                        <br>Email: kitam@mail.com
                                        <br>${cart.user.firstName} ${cart.user.lastName}
                                    </address>
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-4 invoice-col">
                                    Покупатель
                                    <address>
                                        <strong>${cart.client.name}</strong>
                                        <br>Телефон: ${cart.client.phone}
                                        <br>Email: ${cart.client.email}
                                    </address>
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-4 invoice-col">
                                    <b>Номер заказа ${cart.numberCart}</b>
                                    <br>
                                    <br>
                                    <b>Дата заказа:</b> ${cart.date}
                                    <br>
                                    <b>Статус:</b> ${cart.status}
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->

                            <!-- Table row -->
                            <div class="row">
                                <div class="col-xs-12 table">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th></th>
                                            <th>Кол.</th>
                                            <th>Продукт</th>
                                            <th>Тип</th>
                                            <th style="width: 59%">Цена без скидки/со скидкой
                                            </th>
                                            <th>Итого</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${history}" var="history">
                                            <tr>
                                                <td>
                                                    <a href="<c:url value="/resources/img/upload/product/${history.product.image.fileName}"/>" data-toggle="lightbox" data-title="${product.nameProduct}" data-footer="${product.price}">
                                                        <img src="<c:url value='/product/image/${history.product.id}'/>" class="avatar">
                                                    </a>
                                                </td>
                                                <td>${history.quantity}</td>
                                                <td>${history.product.nameProduct}</td>
                                                <td>${history.product.model}</td>
                                                <td>${history.product.price}</td>
                                                <td>$${history.price}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->

                            <div class="row">
                                <!-- accepted payments column -->
                                <div class="col-xs-6">
                                    <%--<p class="lead">Payment Methods:</p>--%>
                                    <%--<img src="images/visa.png" alt="Visa">--%>
                                    <%--<img src="images/mastercard.png" alt="Mastercard">--%>
                                    <%--<img src="images/american-express.png" alt="American Express">--%>
                                    <%--<img src="images/paypal.png" alt="Paypal">--%>
                                    <%--<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">--%>
                                        <%--Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles, weebly ning heekya handango imeem plugg dopplr jibjab, movity jajah plickers sifteo edmodo ifttt zimbra.--%>
                                    <%--</p>--%>
                                </div>
                                <!-- /.col -->
                                <div class="col-xs-6">
                                    <p class="lead">Итого на -  ${cart.date}</p>
                                    <div class="table-responsive">
                                        <table class="table">
                                            <tbody>
                                            <tr>
                                                <th style="width:50%">Итоговая цена</th>
                                                <td>$${cart.priceSummary}</td>
                                            </tr>
                                            <tr>
                                                <th>Цена без скинки</th>
                                                <td>$</td>
                                            </tr>
                                            <tr>
                                                <th>Сумма скидки:</th>
                                                <td>$</td>
                                            </tr>
                                            <tr>
                                                <th>Итоговое количество:</th>
                                                <td>${cart.quantity}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->

                            <!-- this row will not appear when printing -->
                            <div class="row no-print">
                                <div class="col-xs-12">
                                    <button class="btn btn-default" onclick="window.print();"><i class="fa fa-print"></i> Печать</button>
                                    <button class="btn btn-success pull-right"><i class="fa fa-credit-card"></i> ГОТОВО</button>
                                    <button class="btn btn-primary pull-right" onclick="window.pdfMake();" style="margin-right: 5px;"><i class="fa fa-download"></i>PDF</button>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->

