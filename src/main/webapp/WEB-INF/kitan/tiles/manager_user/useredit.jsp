<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Изменение данных клиента </h2>
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

                        <form:form modelAttribute="user" id="form" class="form-horizontal form-label-left" method="post">

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Фамилия <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="lastName" type="text" id="lastName" name="lastName" required="required" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">Имя <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="firstName" type="text" id="firstName" name="firstName" required="required" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>

                            <%--<sec:authorize var="loggedIn" access="hasAuthority('ADMIN_PRIVILEGE')" />--%>
                            <%--<c:choose>--%>
                            <%--<c:when test="${loggedIn}">--%>
                            <%--<div class="form-group">--%>
                                <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="roles">Роль--%>
                                <%--</label>--%>
                                <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                    <%--<form:input path="roles" type="text" id="roles" name="roles" required="required" class="form-control col-md-7 col-xs-12"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--</c:when>--%>
                                <%--<c:otherwise>--%>
                                <%--</c:otherwise>--%>
                            <%--</c:choose>--%>

                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Обновить" class="btn btn-success" />
                                    <input type="button" value="Отменить" class="btn btn-default"  onclick="history.back()"/>
                                </div>
                            </div>
                        </form:form>
                    </div>

                    <div class="x_content">
                        <h2>Смена пароля</h2>
                        <form id="cp" class="form-horizontal form-label-left" method="post">
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="oldPassword">Старый пароль</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="password" id="oldPassword" name="oldPassword" required="required" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="passwordId">Новый пароль</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="password" id="passwordId" name="password" required="required" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="matchesPassword">Повторите пароль</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="password" id="matchesPassword" name="matchesPassword" required="required" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <p><span id="passwordError"  class="alert alert-danger col-sm-12" style="display:none"></span></p>
                            <p><span id="passwordSucc"  class="alert alert-success col-sm-12" style="display:none"></span></p>
                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Обновить" class="btn btn-success"/>
                                    <input type="reset" value="Отменить" class="btn btn-default"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/bootstrap/vendors/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/resources/js/updateAndCheckPassword.js"></script>