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
                        <h2>Изменение клиента </h2>
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

                        <form:form modelAttribute="entity" id="form" class="form-horizontal form-label-left" method="post">

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">ФИО/Наименование организации <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="name" type="text" id="name" name="name" required="required" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameSiteOrShop">Название (сайт или магазин)</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="nameSiteOrShop" type="text" id="nameSiteOrShop" name="nameSiteOrShop" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email" class="control-label col-md-3 col-sm-3 col-xs-12">Email </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="email" id="email" class="form-control col-md-7 col-xs-12" type="email" name="email"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="phone" class="control-label col-md-3 col-sm-3 col-xs-12">Контакты </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="phone" id="phone" name="phone" class="date-picker form-control col-md-7 col-xs-12" type="number"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="workMode" class="control-label col-md-3 col-sm-3 col-xs-12">Режим работы </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="workMode" id="workMode" name="workMode" class="date-picker form-control col-md-7 col-xs-12"  type="text"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="discountPrice" class="control-label col-md-3 col-sm-3 col-xs-12">Персональная скидка</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="discountPrice" id="discountPrice" name="discountPrice" class="date-picker form-control col-md-7 col-xs-12" type="number"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="note" class="control-label col-md-3 col-sm-3 col-xs-12">Примечание</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="note" id="note" name="note" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>

                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Обновить" class="btn btn-success" />
                                    <input type="button" value="Отменить" class="btn btn-default"  onclick="history.back()"/>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

