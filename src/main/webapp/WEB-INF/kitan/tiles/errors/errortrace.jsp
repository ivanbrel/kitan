<%@ page import="org.apache.commons.lang.exception.ExceptionUtils" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <tr>
        <td><b>Error:</b></td>
        <td>${pageContext.exception}</td>
    </tr>
    <tr>
        <td><b>Cause:</b></td>
        <td>
            <%
                Throwable throwable = exception.getCause();
                String rootCauseMessage = ExceptionUtils.getRootCauseMessage(throwable);
            %>
            <%= rootCauseMessage %>
        </td>
    </tr>
    <c:if test="${not empty datetime}">
        <tr>
            <td><b>datetime:</b></td>
            <td>${datetime}</td>
        </tr>
    </c:if>
    <tr>
        <td><b>URI:</b></td>
        <td>${pageContext.errorData.requestURI}</td>
    </tr>
    <tr>
        <td><b>Status code:</b></td>
        <td>${pageContext.errorData.statusCode}</td>
    </tr>
</table>
<script>
    $('.loading').hide();
</script>