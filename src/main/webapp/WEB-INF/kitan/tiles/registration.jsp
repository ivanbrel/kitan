<%--
  Created by IntelliJ IDEA.
  User: ibrel
  Date: 21.04.2016
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Login/Logout animation concept</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/resources/js/registr.js"></script>
</head>

<body>

<div class="cont">
    <div class="demo">
        <div class="login">
            <div class="registr__form">
                <form id="regform" method="POST" action="/">
                    <div class="login__row">
                        <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                        </svg>
                        <input type="text" class="login__input name" name="firstName" placeholder="first name"/>
                    </div>
                    <div class="login__row">
                        <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                        </svg>
                        <input type="text" class="login__input pass" name="lastName" placeholder="last name"/>
                    </div>
                    <div class="login__row">
                        <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                        </svg>
                        <input id="login" type="text" class="login__input pass" name="login" placeholder="login"/>
                    </div>
                    <div class="login__row">
                        <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                        </svg>
                        <input id="password" type="password" class="login__input pass" name="password" placeholder="password"/>
                    </div>
                    <div class="login__row">
                        <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                        </svg>
                        <input id="matchPassword" type="password" class="login__input pass" name="matchingPassword" placeholder="confirm password"/>
                    </div>
                    <button type="submit" class="login__submit">Sign up</button>
                </form>
            </div>
            <div class="app__logout">
                <svg class="app__logout-icon svg-icon" viewBox="0 0 20 20">
                    <path d="M6,3 a8,8 0 1,0 8,0 M10,0 10,12"/>
                </svg>
            </div>
        </div>
    </div>
</div>

</body>
</html>
