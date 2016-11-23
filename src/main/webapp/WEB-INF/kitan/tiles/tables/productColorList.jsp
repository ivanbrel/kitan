<%--
  Created by IntelliJ IDEA.
  User: ibrel
  Date: 22/09/16
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Цвета </h2>
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
                            В данной таблице представлены цвета для товара </p>

                        <button style="float: right" type="button" class="btn btn-round btn-info btn-lg" data-toggle="modal" data-target="#myModal">Добавить цвет</button>
                        <table  class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Наименование цвета</th>
                                <th>Описание цвета</th>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${list}" var="list">
                                <tr>
                                    <td>${list.name}</td>
                                    <td>${list.description}</td>
                                    <td>
                                        <a href="<c:url value='/configuration/product-color/edit/${list.id}'/>" title="Изменить" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                        </a>
                                        <a href="<c:url value='/configuration/product-color/delete/${list.id}'/>" title="Удалить" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                            <%--<a href="<c:url value='/price/add/${price.id}'/>" title="Add" class="btn btn-default btn-xs">--%>
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

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/configuration/product-color/add" method="POST">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Форма добавления нового цвета</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameColorProduct">Наименование цвета <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="nameColorProduct" name="nameColorProduct" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="descriptionColorProduct">Описание цвета
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="descriptionColorProduct" name="descriptionColorProduct" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <input type="submit" value="Добавить" class="btn btn-success" />
                            <input type="reset" value="Очистить форму" class="btn btn-default"  />
                            <%--<input type="button" value="Назад" onclick="history.back()" class="btn btn-danger"/>--%>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
