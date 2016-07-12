<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Изменение цены  </h2>
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

                        <!-- start id-form -->

                        <form:form modelAttribute="price" id="form2" class="form-horizontal form-label-left" method="POST">

                            <%--<div class="form-group">--%>
                                <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="product">Продукт </label>--%>
                                <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                    <%--<form:input path="product.nameProduct" type="text" id="product" name="product" class="form-control col-md-7 col-xs-12"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="byRuble">BY рубли </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="byRuble" type="text" id="byRuble" name="byRuble" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rusRuble">RUS рубли </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="rusRuble" id="rusRuble" class="form-control col-md-7 col-xs-12" type="text" name="rusRuble"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="usaDollar" class="control-label col-md-3 col-sm-3 col-xs-12">USA долл.</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="usaDollar" id="usaDollar" name="usaDollar" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="priceForProduct" class="control-label col-md-3 col-sm-3 col-xs-12">Информация </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:textarea path="priceForProduct" id="priceForProduct" name="priceForProduct" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Обновить" class="btn btn-success"/>
                                    <input type="reset" value="Назад" class="btn btn-default" onclick="history.back()"/>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

