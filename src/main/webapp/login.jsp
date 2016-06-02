<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">


    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans'>

    <link rel="stylesheet" href="${ctx}/resources/css/style.css">

    <script src="${ctx}/resources/js/jquery-2.2.2.min.js"></script>

    <%--<script src="/resources/js/index.js"></script>--%>




</head>

<body>

<div class="cont">
    <div class="demo">
        <div class="login">
            <div class="login__check"></div>
            <div class="login__form">
                <form method="POST" action="login">
                    <div class="login__row">
                        <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                        </svg>
                        <input type="text" name="username" class="login__input name" placeholder="Логин"/>
                    </div>
                    <div class="login__row">
                        <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                        </svg>
                        <input type="password" name="password" class="login__input pass" placeholder="Пароль"/>
                    </div>
                    <c:if test="${not empty param.error}">
                        <font color="red"> Введён неправильный логин или пароль !</font>
                    </c:if>
                    <button type="submit" class="login__submit">Войти</button>
                </form>
                <p class="login__signup"><a href="${ctx}/registrationpage">Регистрация</a></p>
            </div>
        </div>
        <div class="app__logout">
            <svg class="app__logout-icon svg-icon" viewBox="0 0 20 20">
                <path d="M6,3 a8,8 0 1,0 8,0 M10,0 10,12"/>
            </svg>
        </div>
    </div>
</div>

</body>
</html>

