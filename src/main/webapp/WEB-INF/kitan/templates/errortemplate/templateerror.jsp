<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <tiles:insertAttribute name="inHeader"/>
    <title>ERROR</title>
    <link href="${ctx}/resources/img/logo.png" rel="shortcut icon">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- page content -->
        <tiles:insertAttribute name="content"/>
        <!-- /page content -->
    </div>
</div>
<!-- jQuery -->
<script src="${ctx}/resources/bootstrap/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${ctx}/resources/bootstrap/vendors/bootstrap/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="${ctx}/resources/bootstrap/fastclick.js"></script>
<!-- NProgress -->
<script src="${ctx}/resources/bootstrap/nprogress.js"></script>

<!-- Custom Theme Scripts -->
<script src="${ctx}/resources/bootstrap/js/custom.min.js"></script>
</body>
</html>