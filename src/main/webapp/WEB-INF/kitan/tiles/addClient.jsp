<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="clear"></div>

<!-- start content-outer -->
<div id="content-outer">
    <!-- start content -->
    <div id="content">


        <div id="page-heading"><h1>Добавить клиента</h1></div>


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
                                    <form action="${ctx}/client/add" method="POST">
                                        <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                            <tr>
                                                <th valign="top">Фамилия:</th>
                                                <td><input type="text" class="inp-form" name="lastName"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Имя:</th>
                                                <td><input type="text" class="inp-form" name="firstName"/></td>
                                                <%--<td>--%>
                                                    <%--<div class="error-left" hidden></div>--%>
                                                    <%--<div class="error-inner" hidden>This field is required.</div>--%>
                                                <%--</td>--%>
                                            </tr>
                                            <tr>
                                                <th valign="top">Email:</th>
                                                <td><input type="text" class="inp-form" name="email"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Телефон:</th>
                                                <td><input type="text" class="inp-form" name="phone"/></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <th valign="top">Счёт:</th>
                                                <td><input type="text" class="inp-form" name="account"/></td>
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
