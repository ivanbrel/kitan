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
                        <h2>Изменение продукта  </h2>
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

                        <form:form modelAttribute="product" id="form3" class="form-horizontal form-label-left" method="POST">

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameProduct">Наименование продукта </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="nameProduct" type="text" id="nameProduct" name="nameProduct" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="model">Модель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="model" id="model" class="form-control col-md-7 col-xs-12" type="text" name="model"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="color" class="control-label col-md-3 col-sm-3 col-xs-12">color</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="color" id="color" name="color" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="countryProduct" class="control-label col-md-3 col-sm-3 col-xs-12">countryProduct </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="countryProduct" id="countryProduct" name="countryProduct" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="barcode" class="control-label col-md-3 col-sm-3 col-xs-12">barcode </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="barcode" id="barcode" name="barcode" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="control-label col-md-3 col-sm-3 col-xs-12">category </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="category" id="category" name="category" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="count" class="control-label col-md-3 col-sm-3 col-xs-12">count </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="count" id="count" name="count" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
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


