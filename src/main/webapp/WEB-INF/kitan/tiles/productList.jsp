<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="clear"></div>

<!-- start content-outer ........................................................................................................................START -->
<div id="content-outer">
    <!-- start content -->
    <div id="content">

        <table id="example" class="display nowrap dataTable" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
            <thead>
            <tr role="row">
                <th class="sorting_asc" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-sort="ascending" style="width: auto;">Наименование</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Модель</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Цвет</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Страна</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Цена</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Штрихкод</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Категория</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Статус</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Продано</th>
                <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" style="width: auto;">Действия</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th rowspan="1" colspan="1">Наименование</th>
                <th rowspan="1" colspan="1">Модель</th>
                <th rowspan="1" colspan="1">Цвет</th>
                <th rowspan="1" colspan="1">Страна</th>
                <th rowspan="1" colspan="1">Цена</th>
                <th rowspan="1" colspan="1">Штрихкод</th>
                <th rowspan="1" colspan="1">Категория</th>
                <th rowspan="1" colspan="1">Статус</th>
                <th rowspan="1" colspan="1">Продано</th>
                <th rowspan="1" colspan="1">Действия</th>
            </tr>
            </tfoot>
            <tbody>
            <c:forEach items="${product}" var="product">
                <tr role="row" class="odd">
                    <td class="sorting_1">${product.nameProduct}</td>
                    <td>${product.model}</td>
                    <td>${product.color}</td>
                    <td>${product.countryProduct}</td>
                    <td>${product.price}</td>
                    <td>${product.barcode}</td>
                    <td>${product.category}</td>
                    <td>${product.state}</td>
                    <td>${product.sales}</td>
                    <td class="options-width">
                        <a href="<c:url value='/client/edit/${product.id}'/>" title="Edit" class="icon-1 info-tooltip"></a>
                        <a href="<c:url value='/client/delete/${product.id}'/>" title="Delete" class="icon-2 info-tooltip"></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <%--<div class="dataTables_info" id="example_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>--%>
        <%--&lt;%&ndash;<div class="dataTables_paginate paging_simple_numbers" id="example_paginate">&ndash;%&gt;--%>
        <%--<a class="paginate_button previous disabled" aria-controls="example" data-dt-idx="0" tabindex="0" id="example_previous">Previous</a>--%>
        <%--<span>--%>
        <%--<a class="paginate_button current" aria-controls="example" data-dt-idx="1" tabindex="0">1</a>--%>
        <%--<a class="paginate_button " aria-controls="example" data-dt-idx="2" tabindex="0">2</a>--%>
        <%--<a class="paginate_button " aria-controls="example" data-dt-idx="3" tabindex="0">3</a>--%>
        <%--<a class="paginate_button " aria-controls="example" data-dt-idx="4" tabindex="0">4</a>--%>
        <%--<a class="paginate_button " aria-controls="example" data-dt-idx="5" tabindex="0">5</a>--%>
        <%--<a class="paginate_button " aria-controls="example" data-dt-idx="6" tabindex="0">6</a>--%>
        <%--</span><a class="paginate_button next" aria-controls="example" data-dt-idx="7" tabindex="0" id="example_next">Next</a>--%>
        <%--</div>--%>

        <script type="text/javascript">
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-365466-5']);
            _gaq.push(['_trackPageview']);

            (function() {
                var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
            })();
        </script>

        <div id="lbOverlay" style="display: none;">

        </div>
        <div id="lbCenter" style="display: none;">
            <div id="lbImage">
                <div style="position: relative;">
                    <a id="lbPrevLink" href="https://datatables.net/extensions/buttons/examples/initialisation/export.html#"></a>
                    <a id="lbNextLink" href="https://datatables.net/extensions/buttons/examples/initialisation/export.html#"></a>
                </div>
            </div>
        </div>
        <div id="lbBottomContainer" style="display: none;">
            <div id="lbBottom">
                <a id="lbCloseLink" href="https://datatables.net/extensions/buttons/examples/initialisation/export.html#"></a>
                <div id="lbCaption">

                </div>
                <div id="lbNumber">

                </div>
                <div style="clear: both;">
                </div>
            </div>
        </div>
        <!--  end content-table-inner ............................................END  -->
    </div>
</div>
<!--  end content-outer........................................................END -->

<div class="clear">&nbsp;</div>

