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

                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/user/admin/add-user" method="POST">

                            <div class="form-group">
                                <label for="login" class="control-label col-md-3 col-sm-3 col-xs-12">Логин <span class="required">*</span></label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="login" class="form-control col-md-7 col-xs-12" required="required" type="text" name="login">
                                    <span id="userLoginFree" class="alert alert-success col-sm-12" style="display:none"></span>
                                    <span id="userLoginExist" class="alert alert-danger col-sm-12" style="display:none"></span>
                                </div>
                            </div>

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
                                    <span id="globalError" class="alert alert-danger col-sm-12" style="display:none"></span>
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

<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/resources/js/jquery.pwstrength.min.js"></script>
<script src="${ctx}/resources/js/jquery.base64.js"></script>

<script>
    $(document).ready(function () {
        $('#login').on('blur', function () {

            jQuery.ajax({
                type: "POST",
                url: ctx + "/checkLogin",
                data: {"login": document.getElementById('login').value},
                success: function (data) {
                    //check on empty field "user"
                    if ($("#login").val() != 0) {
                        if (data == false) {
                            //check on exists user
                            $("#userLoginExist").show().html([["Пользователь с таким логином уже существует!"]]);
                            $("#userLoginFree").html("").hide();
                        } else if (data == true) {
                            $("#userLoginFree").show().html([["Логин свободен"]]);
                            $("#userLoginExist").html("").hide();
                        }
                    } else {
                        $("#userLoginExist").html("").hide();
                        $("#userLoginFree").html("").hide();
                    }

                }
            })
        });

        $(":password").keyup(function () {
            if($("#password").val() != $("#matchPassword").val()){
                $("#globalError").show().html([["Пароли не совпадают!"]]);
            }else{
                $("#globalError").html("").hide();
            }
            $("#globalError").html("").hide();
        });

        options = {
            common: {minChar:6},
            ui: {
                showVerdictsInsideProgressBar:true,
                showErrors:true,
                errorMessages:{
                    wordLength: [["Длинна пароля меньше 6-ми символов"]],
                    wordNotEmail: [["Нельзя использовать логин в качестве пароля"]],
                    wordSequences: [["Ваш пароль содержит последовательности"]],
                    wordLowercase: [["Используйте символы нижнего регистра"]],
                    wordUppercase: [["Используйте символы верхнего регистра"]],
                    wordOneNumber: [["Используйте цифры"]],
                    wordOneSpecialChar: [["Используйте спец. символы (пример: _ @ # $ %)"]]
                }
            }
        };
        $('#password').pwstrength(options);
    })
</script>