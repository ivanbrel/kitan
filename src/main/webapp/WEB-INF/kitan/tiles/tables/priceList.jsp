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
                        <table  class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Доллар США</th>
                                <th>Белоруский рубль</th>
                                <th>Руский рубль</th>
                                <th>ЕвроL</th>
                                <th>Украинская гривня</th>
                                <th>Китайская юань</th>
                                <th>Польский злотый</th>
                                <th width="100">Опции</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${price}" var="price">
                                <tr>
                                    <td>${price.dollarUSA}</td>
                                    <td>${price.rubleBY}</td>
                                    <td>${price.rubleRUS}</td>
                                    <td>${price.euro}</td>
                                    <td>${price.grivUA}</td>
                                    <td>${price.chinaUAN}</td>
                                    <td>${price.polandZLOT}</td>
                                    <td>
                                        <a href="<c:url value='/price/edit/${price.id}'/>" title="Edit" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                        </a>
                                        <a href="<c:url value='/price/delete/${price.id}'/>" title="Delete" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>
                                        <a href="<c:url value='/price/add/${price.id}'/>" title="Add" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        </a>
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

