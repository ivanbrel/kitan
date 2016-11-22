<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>Пользователь ${entity.login}</h3>

            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
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
                        <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                            <div class="profile_img">
                                <div id="crop-avatar">
                                    <!-- Current avatar -->
                                    <img class="img-responsive avatar-view" src="${ctx}/resources/img/upload/avatar/${entity.image.fileName}" alt="Avatar" title="Change the avatar">
                                </div>
                            </div>

                            <%--<ul class="list-unstyled user_data">--%>
                                <%--<li class="m-top-xs">--%>
                                    <%--<i class="fa fa-external-link user-profile-icon"></i>--%>
                                    <%--<a href="" target="_blank"><sec:authentication property="principal.user.email"/></a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>

                            <br />
                        </div>
                        <div class="col-md-9 col-sm-9 col-xs-12">

                            <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                    <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Информация о пользователе</a>
                                    </li>
                                    <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Изменить информацию</a>
                                    </li>
                                    <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Сменить пароль</a>
                                    </li>
                                </ul>
                                <div id="myTabContent" class="tab-content">
                                    <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">

                                        <!-- /.col -->
                                        <div class="col-xs-6">
                                            <p class="lead">${entity.firstName} ${entity.lastName}</p>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <th style="width:50%">Логин:</th>
                                                        <td>${entity.login}</td>
                                                    </tr>
                                                    <tr>
                                                        <th style="width:50%">Фамилия:</th>
                                                        <td>${entity.lastName}</td>
                                                    </tr>
                                                    <tr>
                                                        <th style="width:50%">Имя:</th>
                                                        <td>${entity.firstName}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Email</th>
                                                        <td>${entity.email}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Телефон:</th>
                                                        <td>${entity.phone}</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <!-- /.col -->

                                    </div>
                                    <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">

                                        <!-- start user edit -->
                                        <div class="x_content">

                                            <!-- start id-form -->
                                            <form:form modelAttribute="entity" id="form" class="form-horizontal form-label-left" method="post" enctype="multipart/form-data">
                                                <div class="form-group" style="display: none">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="login">login <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <form:input path="login" type="text" id="login" name="login" required="required" class="form-control col-md-7 col-xs-12"/>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Фамилия <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <form:input path="lastName" type="text" id="lastName" name="lastName" required="required" class="form-control col-md-7 col-xs-12"/>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">Имя <span class="required">*</span></label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <form:input path="firstName" type="text" id="firstName" name="firstName" required="required" class="form-control col-md-7 col-xs-12"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Email
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <form:input path="email" type="email" id="email" name="email" class="form-control col-md-7 col-xs-12"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">Телефон
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <form:input path="phone" type="phone" id="phone" name="phone" class="form-control col-md-7 col-xs-12"/>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Изображение </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input id="file-3" name="fileUpload" type="file" multiple=false required="required">
                                                    </div>
                                                </div>
                                                <div class="ln_solid"></div>
                                                <div class="form-group">
                                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                        <input type="submit" value="Обнавить" class="btn btn-success">
                                                        <input type="button" value="Отменить" class="btn btn-default"  onclick="history.back()"/>
                                                    </div>
                                                </div>
                                            </form:form>

                                        </div>
                                        <!-- end user edit -->

                                    </div>
                                    <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">

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
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->


<script src="${pageContext.request.contextPath}/resources/bootstrap/vendors/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/resources/js/updateAndCheckPassword.js"></script>