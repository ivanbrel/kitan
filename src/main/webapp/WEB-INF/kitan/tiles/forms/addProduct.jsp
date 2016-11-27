<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>var ctx = "${ctx}";</script>
<!-- jQuery -->
<script src="${ctx}/resources/bootstrap/vendors/jquery/dist/jquery.js"></script>
<script src="${ctx}/resources/js/select2.full.js"></script>
<script src="${ctx}/resources/js/calc.js"></script>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Добавить товар </h2>
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
                            Заполните форму для добавление нового товара
                        </p>

                        <!-- start id-form -->

                            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/product/add" method="POST" enctype="multipart/form-data">

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameProduct">Наименование продукта </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="nameProduct" name="nameProduct" required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="model">Модель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="model" name="model" required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="color" class="control-label col-md-3 col-sm-3 col-xs-12">Цвет </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select id="color" name="color" class="js-example form-control select2-hidden-accessible" tabindex="-1" aria-hidden="true">
                                        <option value="${null}">Выберите цвет</option>
                                        <c:forEach items="${listColor}" var="list">
                                            <option value="${list.name}">${list.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="countryProduct" class="control-label col-md-3 col-sm-3 col-xs-12">Страна производитель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <%--<input id="countryProduct" name="countryProduct" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">--%>
                                        <select id="countryProduct" name="countryProduct" class="js-example form-control select2-hidden-accessible" tabindex="-1" aria-hidden="true">
                                            <option value="Польша">Польша</option>
                                            <option value="Италия">Италия</option>
                                            <option value="Китай">Китай</option>
                                            <option value="Россия">Россия</option>
                                        </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="brand">Бренд (Торговая марка)</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="brand" name="brand" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="control-label col-md-3 col-sm-3 col-xs-12">Категория </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select id="category" name="category" class="js-example form-control select2-hidden-accessible" tabindex="-1" aria-hidden="true">
                                            <option value="${null}">Выберите категорию товара</option>
                                            <c:forEach items="${listCategory}" var="list">
                                                <option value="${list.name}">${list.name}</option>
                                            </c:forEach>
                                        </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="pricebyn" class="control-label col-md-3 col-sm-3 col-xs-12">Цена BYN</label>
                                <div class="col-md-3 col-sm-6 col-xs-6">
                                    <input id="pricebyn" name="byr" class="date-picker form-control col-md-3 col-xs-6" type="number" onkeyup="calcItLocal('byr')">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="pricerus" class="control-label col-md-3 col-sm-3 col-xs-12">Цена RUB</label>
                                <div class="col-md-3 col-sm-6 col-xs-6">
                                    <input id="pricerus" name="rur" class="date-picker form-control col-md-7 col-xs-12" type="number" onkeyup="calcItLocal('rur')">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="priceusd" class="control-label col-md-3 col-sm-3 col-xs-12">Цена USD</label>
                                <div class="col-md-3 col-sm-6 col-xs-6">
                                    <input id="priceusd" name="usd" class="date-picker form-control col-md-7 col-xs-12" type="number" onkeyup="calcItLocal('usd')" value="1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="quantity" class="control-label col-md-3 col-sm-3 col-xs-12">Количество </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="quantity" name="quantity" class="date-picker form-control col-md-7 col-xs-12" type="number">
                                </div>
                            </div>

                            <%--<div id="list">--%>

                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<a class="btn btn-default" id="add">Добавить</a>--%>
                            <%--</div>--%>

                            <%--<br><br><br>--%>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Изображение </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="file-3" name="fileUpload" type="file" multiple=false >
                                    <%--<input name="fileUpload" type="file" class="file" multiple>--%>
                                </div>
                            </div>

                           <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Добавить" class="btn btn-success" />
                                    <input type="reset" value="Очистить форму" class="btn btn-default"  />
                                    <input type="button" value="Назад" onclick="history.back()" class="btn btn-danger"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript">
    var data = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];

    $(".js-example-data-array").select2({
        data: data
    })

</script>

<%--<script type="text/javascript">--%>
    <%--function getRate(from, to) {--%>
        <%--var script = document.createElement('script');--%>
        <%--script.setAttribute('src', "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDBYN%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");--%>
        <%--document.body.appendChild(script);--%>
    <%--}--%>
    <%--function parseExchangeRate(data) {--%>
        <%--var name = data.query.results.row.name;--%>
        <%--var rate = parseFloat(data.query.results.row.rate, 10);--%>
        <%--alert("Exchange rate " + name + " is " + rate);--%>
    <%--}--%>

    <%--getRate("BYN", "USD");--%>
    <%--getRate("USD", "BYN");--%>

<%--</script>--%>