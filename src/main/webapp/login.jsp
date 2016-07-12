<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<script>var ctx = "${ctx}";</script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Вход</title>

    <!-- Bootstrap -->
    <link href="${ctx}/resources/bootstrap/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${ctx}/resources/bootstrap/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${ctx}/resources/bootstrap/css/custom.min.css" rel="stylesheet">

</head>

<body class="login">

<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form method="POST" action="login">
                    <h1>Войти</h1>
                    <c:if test="${not empty param.error}">
                        <font color="red"> Введён неправильный логин или пароль !</font>
                    </c:if>
                    <div>
                        <input name="username" type="text" class="form-control" placeholder="Логин" required="" />
                    </div>
                    <div>
                        <input name="password" type="password" class="form-control" placeholder="Пароль" required="" />
                    </div>

                    <button class="btn btn-default submit" type="submit">Войти</button>


                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">
                            <a href="#signup" class="to_register"> Регистрация </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1>KITAN company</h1>
                            <p>©2016 All Rights Reserved. By <a href="">ibrel</a> </p>
                        </div>
                    </div>
                </form>
            </section>
        </div>

        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form id="form" method="POST" action="/">
                    <h1>Регистрация</h1>
                    <div>
                        <input id="login" name="login" type="text" class="form-control" placeholder="Логин" required="" />
                        <span id="userLoginFree" class="alert alert-success col-sm-12" style="display:none"></span>
                        <span id="userLoginExist" class="alert alert-danger col-sm-12" style="display:none"></span>
                    </div>
                    <div>
                        <input id="firstName" name="firstName" type="text" class="form-control" placeholder="Имя" required="" />
                        <span id="firstNameError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </div>
                    <div>
                        <input id="lastName" name="lastName" type="text" class="form-control" placeholder="Фамилия" required="" />
                        <span id="lastNameError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </div>
                    <%--<div>--%>
                        <%--<input type="email" class="form-control" placeholder="Email" required="" />--%>
                    <%--</div>--%>
                    <div>
                        <input id="password" name="password" type="password" class="form-control" placeholder="Пароль" required="" />
                        <span id="passwordError" class="alert alert-danger col-sm-12" style="display:none"></span>
                    </div>
                    <div>
                        <input id="matchPassword" name="matchPassword" type="password" class="form-control" placeholder="Повторите пароль" required="" />
                        <span id="globalError" class="alert alert-danger col-sm-12" style="display:none"></span>
                    </div>
                    <div>
                        <button class="btn btn-default submit" type="submit">Регистрация</button>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Уже зарегистрированы ?
                            <a href="#signin" class="to_register"> Войти </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1>KITAN company</h1>
                            <p>©2016 All Rights Reserved. By <a href="">ibrel</a> </p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/bootstrap/vendors/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/resources/js/registr.js"></script>
</body>
</html>