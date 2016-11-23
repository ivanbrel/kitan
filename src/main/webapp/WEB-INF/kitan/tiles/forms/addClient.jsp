<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <c:choose>
                            <c:when test="${fail}">
                                <div class="alert alert-danger">
                                    <strong><spring:message code="error"/></strong><spring:message code="error.client.account"/>
                                </div>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                        <br>
                        <h2>Зарегистрировать нового клиента </h2>
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
                            Заполните форму для добавление нового клиента
                        </p>

                        <!-- start id-form -->

                            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/client/add" method="POST">

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">ФИО/Наименование организаци <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="name" name="name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameSiteOrShop">Название (сайт или магазин)</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="nameSiteOrShop" name="nameSiteOrShop" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="email" class="control-label col-md-3 col-sm-3 col-xs-12 ">Email </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="email" class="form-control col-md-7 col-xs-12" type="email" name="email">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="phone" class="control-label col-md-3 col-sm-3 col-xs-12">Телефон</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="phone" name="phone" class="date-picker form-control col-md-7 col-xs-12" type="number">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="workMode" class="control-label col-md-3 col-sm-3 col-xs-12">Режим работы</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="workMode" name="workMode" class="date-picker form-control col-md-7 col-xs-12" type="text">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="discount" class="control-label col-md-3 col-sm-3 col-xs-12">Персональная скидка</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="discount" name="discount" class="date-picker form-control col-md-7 col-xs-12"  type="number">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="note" class="control-label col-md-3 col-sm-3 col-xs-12"></label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <%--<input id="note" name="note" class="date-picker form-control col-md-7 col-xs-12"  type="text">--%>
                                        <textarea id="note" name="note" class="form-control" rows="3" placeholder="дополнительная информация" style="margin: 0px -0.625px 0px 0px; width: 460px; height: 74px;"></textarea>
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
