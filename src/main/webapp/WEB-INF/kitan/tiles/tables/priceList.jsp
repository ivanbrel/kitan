<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Актуальный курс </h2>
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
                            В данной таблице представлен актуальный курс </p>
                        <button style="float: right" type="button" class="btn btn-round btn-info btn-lg" data-toggle="modal" data-target="#myModal">Добавить</button>
                        <table  class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Доллар США</th>
                                <th>Белоруский рубль</th>
                                <th>Руский рубль</th>
                                <%--<th>Евро</th>--%>
                                <%--<th>Украинская гривня</th>--%>
                                <%--<th>Китайская юань</th>--%>
                                <%--<th>Польский злотый</th>--%>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${list}" var="price">
                                <tr>
                                    <td>${price.dollarUSA}</td>
                                    <td>${price.rubleBY}</td>
                                    <td>${price.rubleRUS}</td>
                                    <%--<td>${price.euro}</td>--%>
                                    <%--<td>${price.grivUA}</td>--%>
                                    <%--<td>${price.chinaUAN}</td>--%>
                                    <%--<td>${price.polandZLOT}</td>--%>
                                    <td>
                                        <a href="<c:url value='/configuration/price/edit/${price.id}'/>" title="Изменить" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                        </a>
                                        <%--<a href="<c:url value='/price/delete/${price.id}'/>" title="Delete" class="btn btn-default btn-xs">--%>
                                            <%--<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>--%>
                                        <%--</a>--%>
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
            <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/configuration/price/add" method="POST">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Форма добавления</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rubleBY">Белоруский рубль</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" step="any" id="rubleBY" name="rubleBY" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rubleRUS">Русский рубль</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" step="any" id="rubleRUS" name="rubleRUS" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="euro">Евро</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<input type="number" step="any" id="euro" name="euro" class="form-control col-md-7 col-xs-12">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="grivUA">Украинская гривня</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<input type="number" step="any" id="grivUA" name="grivUA" class="form-control col-md-7 col-xs-12">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="chinaUAN">Китайская юань</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<input type="number" step="any" id="chinaUAN" name="chinaUAN" class="form-control col-md-7 col-xs-12">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="polandZLOT">Польский злотый</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<input type="number" step="any" id="polandZLOT" name="polandZLOT" class="form-control col-md-7 col-xs-12">--%>
                        <%--</div>--%>
                    <%--</div>--%>
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

