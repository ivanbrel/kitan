<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="clear"></div>

<!-- start content-outer -->
<div id="content-outer">
    <!-- start content -->
    <div id="content">


        <div id="page-heading"><h1>Добавить продутк</h1></div>

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
                                    <form action="${ctx}/product/add" method="POST">
                                        <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                            <tr>
                                                <th valign="top">Наименование:</th>
                                                <td><input type="text" class="inp-form" name="nameProduct"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Модель:</th>
                                                <td><input type="text" class="inp-form" name="model"/></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Цвет:</th>
                                                <td><input type="text" class="inp-form" name="color"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Страна производитель:</th>
                                                <td><input type="text" class="inp-form" name="countryProduct"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Цена:</th>
                                                <td><input type="text" class="inp-form" name="price"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Штрихкод:</th>
                                                <td><input type="text" class="inp-form" name="barcode"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Категория:</th>
                                                <td><input type="text" class="inp-form" name="category"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Заметки:</th>
                                                <td><textarea rows="" cols="" class="form-textarea"></textarea></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th>&nbsp;</th>
                                                <td valign="top">
                                                    <input type="submit" value="" class="form-submit" />
                                                    <input type="reset" value="" class="form-reset"  />
                                                </td>
                                                <td></td>
                                            </tr>
                                        </table>
                                    </form>
                                    <!-- end id-form  -->

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

    </div>
    <!--  end content -->
    <div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->

<div class="clear">&nbsp;</div>
