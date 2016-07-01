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
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Settings 1</a>
                                    </li>
                                    <li><a href="#">Settings 2</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            В данной таблице представлен список всех товаров, выберите товар для добавления его к покупке  </p>
                        <table id="datatable-buttons" class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Наименование</th>
                                <th>Модель</th>
                                <th>Цвет</th>
                                <th>Страна</th>
                                <th>Категория</th>
                                <th>Статус</th>
                                <th>Опции</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${productsList}" var="elements" varStatus="">
                                <tr>
                                    <form:form method="POST" modelAttribute="price">
                                        <td style="display: none"><form:input value="${elements}" path="product.id"/></td>
                                        <td><c:out value="${elements.nameProduct}"/></td>
                                        <td><c:out value="${elements.model}"/></td>
                                        <td><c:out value="${elements.color}"/></td>
                                        <td><c:out value="${elements.countryProduct}"/></td>
                                        <td><c:out value="${elements.category}"/></td>
                                        <td><c:out value="${elements.state}"/></td>
                                        <td width="10"><input type="submit" value="Добавить к продукту" class="btn btn-success custom-width btn-xs"/></td>
                                    </form:form>
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
<!-- /page content -->