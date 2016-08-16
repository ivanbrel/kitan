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
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Фамилия <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="lastName" name="lastName" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">Имя <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="firstName" name="firstName" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="control-label col-md-3 col-sm-3 col-xs-12">Email </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="email" class="form-control col-md-7 col-xs-12" type="email" name="email">
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
                                    <label for="phone" class="control-label col-md-3 col-sm-3 col-xs-12">Телефон <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="phone" name="phone" class="date-picker form-control col-md-7 col-xs-12" required="required" type="number">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="account" class="control-label col-md-3 col-sm-3 col-xs-12">Счёт клиента <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="account" name="account" class="date-picker form-control col-md-7 col-xs-12" required="required" type="number">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="discount" class="control-label col-md-3 col-sm-3 col-xs-12">Персональная скидка</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="discount" name="discount" class="date-picker form-control col-md-7 col-xs-12"  type="number">
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
