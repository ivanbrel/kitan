<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" scope="request" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- start content-outer -->
<div id="content-outer">
    <!-- start content -->
    <div id="content">


        <div id="page-heading"><h1>Оформить заказ</h1></div>

<form method="POST" action="${ctx}/purchase/add">
        <table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
            <tr>
                <th rowspan="3" class="sized"><img src="${ctx}/resources/img/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
                <th class="topleft"></th>
                <td id="tbl-border-top">&nbsp;</td>
                <th class="topright"></th>
                <th rowspan="3" class="sized"><img src="${ctx}/resources/img/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
            </tr>
            <tr>
                <td id="tbl-border-left"></td>
                <td>
                    <!--  start content-table-inner -->
                    <div id="content-table-inner">

                        <table border="0" width="100%" cellpadding="0" cellspacing="0">
                            <tr valign="top">
                                <td>
                                    <!-- start id-form -->
                                    <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                        <tr>
                                            <th valign="top">Покупатель:</th>
                                            <td><input type="text" class="form-control" name="clientId"/></td>
                                            <td><button type="button" class="btn btn-primary">Выбор покупателя</button></td>
                                            <td>
                                                <%--error--%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th valign="top">Продукт: </th>
                                            <td><input type="text" class="form-control" name="productId"/></td>
                                            <td><button type="button" class="btn btn-primary">Выбор продукта</button></td>
                                            <td>
                                               <%----%>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th valign="top">Цена:</th>
                                            <td><input type="text" class="form-control" /></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <jsp:useBean id="now" class="java.util.Date" scope="page"/>
                                            <th valign="top">Дата покупки:</th>
                                            <td><input type="text" class="form-control" name="date" value="<fmt:formatDate type="time" value="${now}" pattern="dd.MM.yyyy HH:mm:ss"/>"/></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th valign="top">Примечание к покупке:</th>
                                            <td><textarea class="form-control" rows="3"></textarea></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>&nbsp;</th>
                                            <td valign="top">
                                                <input type="submit" class="btn btn-success" value="Выполнить заказ"/>
                                                <input type="button" class="btn btn-danger" value="Очистить форму" />
                                            </td>
                                            <td></td>
                                        </tr>
                                    </table>
                                    <!-- end id-form  -->

                                </td>
                                <td>

                                    <!--  start related-activities -->
                                    <div id="related-activities">

                                        <!--  start related-act-top -->
                                        <div id="related-act-top">
                                            <img src="${ctx}/resources/img/forms/header_related_act.gif" width="271" height="43" alt="" />
                                        </div>
                                        <!-- end related-act-top -->

                                        <!--  start related-act-bottom -->
                                        <div id="related-act-bottom">

                                            <!--  start related-act-inner -->
                                            <div id="related-act-inner">

                                                <div class="left"><a href=""><img src="${ctx}/resources/img/forms/icon_plus.gif" width="21" height="21" alt="" /></a></div>
                                                <div class="right">
                                                    <h5>Клиенты</h5>

                                                    <ul class="greyarrow">
                                                        <li><a href="${ctx}/client/add-page">Создать нового клиента</a></li>
                                                        <li><a href="${ctx}/client/list">Все клиенты</a></li>
                                                    </ul>
                                                </div>

                                                <div class="clear"></div>
                                                <div class="lines-dotted-short"></div>

                                                <div class="left"><a href=""><img src="${ctx}/resources/img/forms/icon_edit.gif" width="21" height="21" alt="" /></a></div>
                                                <div class="right">
                                                    <h5>Товар</h5>

                                                    <ul class="greyarrow">
                                                        <li><a href="${ctx}/product/list">Посмотреть весь товар</a></li>
                                                        <li><a href="">Что то ещё с товаром</a> </li>
                                                    </ul>
                                                </div>
                                                <div class="clear"></div>

                                            </div>
                                            <!-- end related-act-inner -->
                                            <div class="clear"></div>

                                        </div>
                                        <!-- end related-act-bottom -->

                                    </div>
                                    <!-- end related-activities -->

                                </td>
                            </tr>
                            <tr>
                                <td><img src="${ctx}/resources/img/shared/blank.gif" width="695" height="1" alt="blank" /></td>
                                <td></td>
                            </tr>
                        </table>

                        <div class="clear"></div>
                    </div>
                    <!--  end content-table-inner  -->
                </td>
                <td id="tbl-border-right"></td>
            </tr>
            <tr>
                <th class="sized bottomleft"></th>
                <td id="tbl-border-bottom">&nbsp;</td>
                <th class="sized bottomright"></th>
            </tr>
        </table>

        <div class="clear">&nbsp;</div>
</form>
    </div>

    <!--  end content -->
    <div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->