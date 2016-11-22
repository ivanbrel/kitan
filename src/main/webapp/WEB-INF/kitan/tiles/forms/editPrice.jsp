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

                        <form:form modelAttribute="entity" id="form2" class="form-horizontal form-label-left" method="POST">

                            <div class="form-group" style="display: none">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="dollarUSA">Доллар США </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="dollarUSA" type="number" id="dollarUSA" name="dollarUSA" class="form-control col-md-7 col-xs-12" step="any"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rubleBY">BY рубли </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="rubleBY" type="number" id="rubleBY" name="rubleBY" class="form-control col-md-7 col-xs-12" step="any"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rubleRUS">RUS рубли </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="rubleRUS" id="rubleRUS" class="form-control col-md-7 col-xs-12" type="number" name="rubleRUS" step="any"/>
                                </div>
                            </div>
                            <%--<div class="form-group">--%>
                                <%--<label for="euro" class="control-label col-md-3 col-sm-3 col-xs-12">EURO </label>--%>
                                <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                    <%--<form:input path="euro" id="euro" name="euro" class="date-picker form-control col-md-7 col-xs-12" type="number" step="any"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="grivUA" class="control-label col-md-3 col-sm-3 col-xs-12">Гривня </label>--%>
                                <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                    <%--<form:input path="grivUA" id="grivUA" name="grivUA" class="date-picker form-control col-md-7 col-xs-12" type="number" step="any"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="chinaUAN" class="control-label col-md-3 col-sm-3 col-xs-12">CHINA </label>--%>
                                <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                    <%--<form:input path="chinaUAN" id="chinaUAN" name="chinaUAN" class="date-picker form-control col-md-7 col-xs-12" type="number" step="any"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="polandZLOT" class="control-label col-md-3 col-sm-3 col-xs-12">Poland </label>--%>
                                <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                    <%--<form:input path="polandZLOT" id="polandZLOT" name="polandZLOT" class="date-picker form-control col-md-7 col-xs-12" type="number" step="any"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
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

