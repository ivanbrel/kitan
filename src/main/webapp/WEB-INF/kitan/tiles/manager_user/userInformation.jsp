<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--центральная колонка--%>

<div class="center-man">
    <p class="new">Здравствуйте, ${user.firstName}</p>
    <h2 style="text-align:center; margin-bottom:40px">ЛИЧНЫЙ КАБИНЕТ</h2>
    <div class="form-style-1">
        <div class="left-center-left"><img  src="${ctx}/resources/img/man.png" alt="Ваше фото"/></div>
        <div class="center-left-2">

            <fieldset>
                <legend style="color:#0D47A1;">Личные данные</legend>
                <form:form id="main" method="POST" modelAttribute="user">

                    <p><label for="lastName"><span>Фамилия <span class="required">*</span></span>
                    <form:input type="text" path="lastName" id="lastName" class="field-divided" required="required"/></label></p>

                    <p><label for="firstName"><span>Имя <span class="required">*</span></span>
                        <form:input type="text" path="firstName" id="firstName" class="field-divided" required="required"/></label></p>

                    <%--<sec:authorize var="loggedIn" access="hasAuthority('ADMIN_PRIVILEGE')" />--%>
                    <%--<c:choose>--%>
                    <%--<c:when test="${loggedIn}">--%>
                    <%--<p><label for="roles"><span>Роль </span>--%>
                        <%--<form:input type="text" path="roles" id="role" class="field-divided"/></label></p>--%>
                    <%--</c:when>--%>
                        <%--<c:otherwise>--%>
                        <%--</c:otherwise>--%>
                    <%--</c:choose>--%>

                    <div class="isa_success">
                            ${success}
                    </div>

                    <input type="submit" value="Обновить" class="great_btn3"/>
                    <input type="button" value="Отменить" class="great_btn4" onclick="history.back()">

                </form:form>
            </fieldset>

        </div>
        <div class="center-right">
            <fieldset>
                <legend style="color:#0D47A1;">Смена пароля</legend>
                <form:form id="cp" method="post">
                <p><label><input type="password" name="oldPassword" value="" id="oldPass"  class="field-divided" required="required"/><span class="required"> * </span>Старый пароль</label></p>
                <p><label><input type="password" name="password" value="" id="pass"  class="field-divided" required="required"/><span class="required"> * </span>Новый пароль</label></p>
                <p><label><input type="password" name="matchesPassword" value="" id="matchPass"  class="field-divided" required="required"/><span class="required"> * </span>Повторите пароль</label></p>
                <p><span id="passwordError"  class="isa_error" style="display:none"></span></p>
                <input type="submit" value="Сменить" class="great_btn3">
                </form:form>
            </fieldset>
        </div>
    </div>
</div>