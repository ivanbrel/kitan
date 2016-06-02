<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="clear"></div>

<!-- start content-outer ........................................................................................................................START -->
<div id="content-outer">
    <!-- start content -->
    <div id="content">

        <!--  start page-heading -->
        <div id="page-heading">
            <h1>Заказы</h1>
        </div>
        <!-- end page-heading -->

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
                    <!--  start content-table-inner ...................................................................... START -->
                    <div id="content-table-inner">

                        <!--  start table-content  -->
                        <div id="table-content">

                            <!--  start message-yellow -->
                            <div id="message-yellow" hidden>
                                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="yellow-left">You have a new message. <a href="">Go to Inbox.</a></td>
                                        <td class="yellow-right"><a class="close-yellow"><img src="${ctx}/resources/img/table/icon_close_yellow.gif"   alt="" /></a></td>
                                    </tr>
                                </table>
                            </div>
                            <!--  end message-yellow -->

                            <!--  start message-red -->
                            <div id="message-red" hidden>
                                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="red-left">Error. <a href="">Please try again.</a></td>
                                        <td class="red-right"><a class="close-red"><img src="${ctx}/resources/img/table/icon_close_red.gif"   alt="" /></a></td>
                                    </tr>
                                </table>
                            </div>
                            <!--  end message-red -->

                            <!--  start message-blue -->
                            <div id="message-blue" hidden>
                                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="blue-left">Welcome back. <a href="">View my account.</a> </td>
                                        <td class="blue-right"><a class="close-blue"><img src="${ctx}/resources/img/table/icon_close_blue.gif"   alt="" /></a></td>
                                    </tr>
                                </table>
                            </div>
                            <!--  end message-blue -->

                            <!--  start message-green -->
                            <div id="message-green" hidden>
                                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="green-left">Product added sucessfully. <a href="">Add new one.</a></td>
                                        <td class="green-right"><a class="close-green"><img src="${ctx}/resources/img/table/icon_close_green.gif"   alt="" /></a></td>
                                    </tr>
                                </table>
                            </div>
                            <!--  end message-green -->

                            <!--  start product-table ..................................................................................... -->


                            <form>
                                <div class="col-sm-3">
                                    <input type="text" id="search" class="form-control" placeholder="Поиск...">
                                </div>
                            </form>

                            <br><br><br>
                            <table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
                                <tr>
                                    <th class="table-header-check"><a id="toggle-all" ></a> </th>
                                    <th class="table-header-repeat line-left minwidth-1"><a href="">Номер заказа</a>	</th>
                                    <th class="table-header-repeat line-left minwidth-1"><a href="">Дата заказа</a></th>
                                    <th class="table-header-repeat line-left"><a href="">Продукты</a></th>
                                    <th class="table-header-repeat line-left"><a href="">Клиент</a></th>
                                    <%--<th class="table-header-repeat line-left"><a href="">Цена</a></th>--%>
                                    <th class="table-header-options line-left"><a href="">Действия</a></th>
                                </tr>
                                <c:forEach items="${purchases}" var="purchases">
                                    <tr>
                                        <td><input  type="checkbox"/></td>
                                        <td>${purchases.numberPurchase}</td>
                                        <td>${purchases.date}</td>
                                        <td>${purchases.product}</td>
                                        <td>${purchases.client.lastName}</td>
                                        <%--<td>${purchases.price}</td>--%>
                                        <td class="options-width">
                                            <%--<a href="<c:url value='/client/edit/${product.id}'/>" title="Edit" class="icon-1 info-tooltip"></a>--%>
                                            <a href="<c:url value='/purchase/delete/${purchases.id}'/>" title="Delete" class="icon-2 info-tooltip"></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <!--  end product-table................................... -->
                        </div>
                        <!--  end content-table  -->

                        <!--  start actions-box ............................................... -->
                        <div id="actions-box">
                            <a href="" class="action-slider"></a>
                            <div id="actions-box-slider">
                                <a href="">see</a>
                                <%--<a href="<c:url value='/client/edit/${clients.lastName}'/>" class="action-edit">Edit</a>--%>
                                <%--<a href="<c:url value='/client/delete/${clients.id}'/>" class="action-delete">Delete</a>--%>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <!-- end actions-box........... -->

                        <!--  start paging..................................................... -->
                        <table border="0" cellpadding="0" cellspacing="0" id="paging-table">
                            <tr>
                                <td>
                                    <a href="" class="page-far-left"></a>
                                    <a href="" class="page-left"></a>
                                    <div id="page-info">Page <strong>1</strong> / 15</div>
                                    <a href="" class="page-right"></a>
                                    <a href="" class="page-far-right"></a>
                                </td>
                                <td>
                                    <select  class="styledselect_pages">
                                        <option value="">Number of rows</option>
                                        <option value="">1</option>
                                        <option value="">2</option>
                                        <option value="">3</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <!--  end paging................ -->

                        <div class="clear"></div>

                    </div>
                    <!--  end content-table-inner ............................................END  -->
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

    </div>
    <!--  end content -->
    <div class="clear">&nbsp;</div>
</div>
<!--  end content-outer........................................................END -->

<div class="clear">&nbsp;</div>

<script type="text/javascript">
    $('input#search').quicksearch('table tbody tr');
</script>
