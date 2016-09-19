<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Список товаров </h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            В данной таблице представлен список всех товаров, выберите товар для добавления его к покупке  </p>
                        <table id="datatable-buttons" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Наименование</th>
                                <th>Модель</th>
                                <th>Цвет</th>
                                <th>Страна</th>
                                <th>Категория</th>
                                <th>Цена</th>
                                <th>Количество</th>
                            </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${productsList}" var="elements">
                                    <tr>
                                        <form:form method="POST" modelAttribute="cart">
                                            <td id="idProduct" style="display: none"><form:input value="${elements.id}" path="products"/></td>
                                            <td>
                                                <a href="<c:url value="/resources/img/upload/product/${elements.image.fileName}"/>" data-toggle="lightbox" data-title="${elements.nameProduct}" data-footer="${elements.price}">
                                                    <img src="<c:url value="/resources/img/upload/product/${elements.image.fileName}"/>" class="avatar">
                                                </a>
                                            </td>
                                            <td><c:out value="${elements.nameProduct}"/></td>
                                            <td><c:out value="${elements.model}"/></td>
                                            <td><c:out value="${elements.color}"/></td>
                                            <td><c:out value="${elements.countryProduct}"/></td>
                                            <td><c:out value="${elements.category}"/></td>
                                            <td><c:out value="${elements.price}"/></td>
                                            <%--<td><c:out value="${elements.state}"/></td>--%>
                                            <td>
                                                <p>
                                                    <label><input type="number" id="count" class="form-control col-md-7 col-xs-12" name="count" value="" required="required" placeholder="осталось - <c:out value="${elements.quantity}"/>"/></label>
                                                </p>
                                            </td>
                                            <td width="10" style=" border-collapse: collapse; border: 2px solid white" >
                                                <input type="submit" value="Добавить в корзину" class="btn btn-success custom-width btn-xs"/>
                                            </td>
                                        </form:form>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <span id="errCount" class="btn btn-success custom-width btn-xs" style="display:none"></span>
                        <div style="float: right">
                            <a href="${ctx}/cart/${cart.id}" class="btn btn-default">Назад</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->

<script>
    $(document).ready(function () {
        $('#product_count').on('blur', function () {
            jQuery.ajax({
                type: "POST",
                url: ctx + "/checkCount",
                data: {
                    "count": document.getElementById('product_count').value},
                success: function (data) {
                    if (data == true) {
                        $("#errCount").show().html([["превышено допустимое количество!"]]);
                    } else if (data == false) {
                        $("#errCount").show().html([["превышено допустимое количество!!!!"]]);
                    }

                }
            })
        });
    });
</script>

