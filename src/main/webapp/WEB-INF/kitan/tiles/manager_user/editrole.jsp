<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Редактирование привелегий роли - <span>${role.name}</span></h2>
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

                        <form:form method="POST" commandName="role">
                        <div>
                        <table  class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th></th>
                                <th><small>Привилегии</small></th>
                                <%--<th width="1000"><small>Описание</small></th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${privileges}" var="elements" varStatus="loop">
                                <%--<c:if test="${not (elements.name == 'ADMIN_PRIVILEGE')}">--%>
                                <tr>
                                    <td ><form:checkbox path="privileges" class="person_data" value="${elements}"/></td>
                                    <td><small><c:out value='${elements.name}' /></small></td>
                                        <%--<td><small><c:out value='${elements.information}' /></small></td>--%>
                                </tr>
                                <%--</c:if>--%>
                            </c:forEach>
                            </tbody>
                        </table>
                        <br>
                            <input type="submit" value="Обновить" class="btn btn-success custom-width"/>
                            <input type="button" value="Отменить" class="btn" onclick="history.back()">

                            <div class="isa_success">
                                    ${success}
                            </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>