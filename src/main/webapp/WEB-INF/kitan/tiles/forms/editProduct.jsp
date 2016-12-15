<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Изменение продукта  </h2>
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
                    <%--pic product--%>
                    <div style="margin: auto; width: 200px; padding-bottom: 20px" >
                        <div class="profile_img">
                            <div id="crop-avatar">
                                <!-- Current avatar -->
                                <img class="img-responsive avatar-view" src="<c:url value='/product/image/${entity.id}'/>" alt="Avatar" title="${entity.nameProduct} ${entity.model}">
                            </div>
                        </div>
                    </div>
                    <div class="x_content">

                        <!-- start id-form -->

                        <form:form modelAttribute="entity" id="form3" class="form-horizontal form-label-left" method="POST" enctype="multipart/form-data">


                            <div class="form-group" style="display: none">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="id">id </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="id" type="text" id="id" name="id" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameProduct">Наименование продукта </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="nameProduct" type="text" id="nameProduct" name="nameProduct" class="form-control col-md-7 col-xs-12"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="model">Модель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="model" id="model" class="form-control col-md-7 col-xs-12" type="text" name="model"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="color" class="control-label col-md-3 col-sm-3 col-xs-12">Цвет </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">

                                    <form:select path="color" cssClass="js-example form-control select2-hidden-accessible">
                                        <form:options items="${listColor}" />
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="countryProduct" class="control-label col-md-3 col-sm-3 col-xs-12">Страна производитель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="countryProduct" id="countryProduct" name="countryProduct" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="brand" class="control-label col-md-3 col-sm-3 col-xs-12">Бренд (Торговая марка) </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="brand" id="brand" name="brand" class="date-picker form-control col-md-7 col-xs-12" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="control-label col-md-3 col-sm-3 col-xs-12">Категория </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:select path="category" cssClass="js-example form-control select2-hidden-accessible">
                                        <form:options items="${lists}" />
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="price" class="control-label col-md-3 col-sm-3 col-xs-12">Цена </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="price" id="price" name="price" class="date-picker form-control col-md-7 col-xs-12" type="number"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="quantity" class="control-label col-md-3 col-sm-3 col-xs-12">Количество </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <form:input path="quantity" id="quantity" name="quantity" class="date-picker form-control col-md-7 col-xs-12" type="number"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Изображение </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="file-3" name="fileUpload" type="file" multiple=false>
                                        <%--<input name="fileUpload" type="file" class="file" multiple>--%>
                                </div>
                            </div>

                            <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Обновить" class="btn btn-success"/>
                                    <input type="reset" value="Назад" class="btn btn-default" onclick="history.back()"/>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


