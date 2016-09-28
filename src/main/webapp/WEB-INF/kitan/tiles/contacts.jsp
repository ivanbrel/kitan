<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3><spring:message code="info.word.contacts"/> </h3>
            </div>

        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12">
                <div class="x_panel">
                    <div class="x_content">
                        <div class="row">

                            <div class="clearfix"></div>

                            <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                                <div class="well profile_view">
                                    <div class="col-sm-12">
                                        <h4 class="brief"><i><spring:message code="info.word.developer"/></i></h4>
                                        <div class="left col-xs-7">
                                            <h2><spring:message code="info.developer"/></h2>
                                            <%--<p><strong>About: </strong> Web Designer / UX / Graphic Artist / Coffee Lover </p>--%>
                                            <ul class="list-unstyled">
                                                <li><i class="fa fa-building"></i> <spring:message code="info.word.address"/> : <spring:message code="info.developer.address"/> </li>
                                                <li><i class="fa fa-phone"></i> <spring:message code="info.word.phone"/> #: <spring:message code="info.developer.phone"/> </li>
                                                <li><i class="fa fa-male"></i> <spring:message code="info.word.email"/> : <spring:message code="info.developer.email"/> </li>
                                            </ul>
                                        </div>
                                        <div class="right col-xs-5 text-center">
                                            <img src="<c:url value="/resources/img/avatarForContacts/ibrelContact.jpg"/>" alt="" class="img-circle img-responsive">
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
