<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                                    <form:form id="main" method="POST" modelAttribute="client">
                                        <div class="form-group">

                                        <p><label for="firstName"><span>Фамилия <span>*</span></span>
                                            <form:input type="text" path="firstName" id="firstName" class="form-control" required="required"/></label></p>

                                        <p><label for="lastName"><span>Имя <span class="required">*</span></span>
                                            <form:input type="text" path="lastName" id="lastName" class="form-control" required="required"/></label></p>

                                        <p><label for="email"><span>E-mail </span>
                                            <form:input type="email" path="email" id="email" class="form-control"/></label></p>

                                        <p><label for="phone"><span>Телефон </span>
                                            <form:input type="text" path="phone" id="phone" class="form-control"/></label></p>

                                        <p><label for="account"><span>account </span>
                                            <form:input type="text" path="account" id="account" class="form-control"/></label></p>

                                        <div class="isa_success">
                                                ${success}
                                        </div>

                                        <input type="submit" value="Обновить" class="btn btn-primary"/>
                                        <input type="button" value="Отменить" class="btn btn-default" onclick="history.back()">
                                        </div>
                                    </form:form>
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
