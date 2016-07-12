<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<h2>404 - страница не найдена</h2>--%>
<%--<br/>--%>
<%--<p><b>Код:</b> ${pageContext.errorData.statusCode}</p>--%>
<%--<p><b>Запрашиваемый URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%--<html>--%>
<%--<head>--%>
<%--<title><spring:message code="errors.error"/></title>--%>
<%--</head>--%>
<%--<body>--%>
<button class="btn btn-default" onclick="history.back()">Вернуться на предыдущую страницу</button><br/>
<p class="text-danger">Для просмотра данной страницы Вам необходимо авторизоваться, либо у Вас недостаточный уровень доступа!</p>
<p class="text-info">Если у Вас возникли вопросы, пожалуйста, обратитесь к техническому персоналу, контакты внизу страницы.</p>
<br/>
<%--<jsp:include page="/WEB-INF/views/cms/blocks/authblock2.jsp" />--%>
<%--<c:import url="/WEB-INF/views/cms/templates/first/block_sc.jsp">--%>
<%--<c:param name="blockUrl" value="authblock2.jsp"/>--%>
<%--<c:param name="blockName" value="Авторизация"/>--%>
<%--</c:import>--%>
<p class="text-info"><b>Код:</b> ${pageContext.errorData.statusCode}</p>
<p class="text-info"><b>Запрашиваемый URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>

<%--<div align="center">--%>
<%--<span><img src="/resources/images/error404.jpg"></span>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>


