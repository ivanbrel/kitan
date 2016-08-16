<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <c:choose>
                        <c:when test="${fail}">
                            <div class="alert alert-danger">
                                <strong><spring:message code="error"/></strong><spring:message code="error.product.notEmpty"/>
                            </div>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                    <div class="x_title">
                        <h2>Список товара </h2>
                        <div class="clearfix"></div>
                    </div>
                    <div style="float: right">
                        <a class="btn btn-success" href="${ctx}/product/add-page" >
                            <span class="fa fa-plus-square" aria-hidden="true"></span>  Добавить товар
                        </a>
                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            В данной таблице представлен список всего товара </p>
                        <table id="datatable-buttons" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Наименование</th>
                                <th>Модель</th>
                                <th>Цвет</th>
                                <th>Страна</th>
                                <th>Цена</th>
                                <th>Категория</th>
                                <th>Количество</th>
                                <th width="100">Опции</th>
                            </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${product}" var="product">
                                    <tr>
                                        <td>
                                            <a href="<c:url value="/resources/img/upload/${product.image.fileName}"/>" data-toggle="lightbox" data-title="${product.nameProduct}" data-footer="${product.price}">
                                                <img src="<c:url value="/resources/img/upload/${product.image.fileName}"/>" class="avatar">
                                            </a>
                                        </td>
                                        <td>${product.nameProduct}</td>
                                        <td>${product.model}</td>
                                        <td>${product.color}</td>
                                        <td>${product.countryProduct}</td>
                                        <td data-toggle="tooltip" data-placement="right"
                                            title="
                                            <c:forEach items="${price}" var="price">
                                            BY: ${price.rubleBY*product.price}
                                            RUS: ${price.rubleRUS*product.price}
                                            Euro: ${price.euro*product.price}
                                            </c:forEach>">${product.price}</td>
                                        <td>${product.category}</td>
                                        <td>${product.quantity}</td>
                                        <td>
                                            <a href="<c:url value='/product/edit/${product.id}'/>" title="Edit" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                            </a>
                                            <a href="<c:url value='/product/delete/${product.id}'/>" title="Delete" class="btn btn-default btn-xs">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </a>
                                            <%--<a href="<c:url value='/product/add/column/${product.id}'/>" title="Add Column" class="btn btn-default btn-xs">--%>
                                                <%--<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>--%>
                                            <%--</a>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>



