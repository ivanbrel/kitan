<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/product/add" method="POST">

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
                                    <input id="color" class="form-control col-md-7 col-xs-12" type="text" name="color">
                                </div>
                            </div>
                            <%--<div class="form-group">--%>
                            <%--<label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>--%>
                            <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<div id="gender" class="btn-group" data-toggle="buttons">--%>
                            <%--<label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">--%>
                            <%--<input type="radio" name="gender" value="male"> &nbsp; Male &nbsp;--%>
                            <%--</label>--%>
                            <%--<label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">--%>
                            <%--<input type="radio" name="gender" value="female"> Female--%>
                            <%--</label>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <div class="form-group">
                                <label for="countryProduct" class="control-label col-md-3 col-sm-3 col-xs-12">Страна производитель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="countryProduct" name="countryProduct" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="price" class="control-label col-md-3 col-sm-3 col-xs-12">Цена </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="price" name="price" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="control-label col-md-3 col-sm-3 col-xs-12">Категория </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="category" name="category" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                </div>
                            </div>
                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Добавить" class="btn btn-success" />
                                    <input type="reset" value="Отменить" class="btn btn-default"  />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>