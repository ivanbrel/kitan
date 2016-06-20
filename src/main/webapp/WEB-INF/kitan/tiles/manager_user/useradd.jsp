<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Зарегистрировать нового пользователя </h2>
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
                            Заполните форму для добавление нового пользователя
                        </p>

                        <!-- start id-form -->

                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/user/add" method="POST">

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
                                <label for="login" class="control-label col-md-3 col-sm-3 col-xs-12">Логин <span class="required">*</span></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="login" class="form-control col-md-7 col-xs-12" required="required" type="text" name="login">
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
                                <label for="password" class="control-label col-md-3 col-sm-3 col-xs-12">Пароль <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="password" name="password" class="date-picker form-control col-md-7 col-xs-12" required="required" type="password">
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

