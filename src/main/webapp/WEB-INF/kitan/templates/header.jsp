<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authentication var="userId" property="principal.user.id"/>

<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${ctx}/index.jsp" class="site_title">
                <span><spring:message code="info.project.name"/></span>
            </a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile">
            <div class="profile_pic">
                <img src="${ctx}/resources/img/logo.png" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
                <span><spring:message code="info.word.user.hello"/></span>
                <h2><sec:authentication property="principal.user.firstName"/></h2>
                <br/><br/>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br/><br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3><spring:message code="info.word.controlpanel"/></h3>
                <ul class="nav side-menu">

                    <li><a><i class="fa fa-home"></i> <spring:message code="info.word.home"/> <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <%--<li><a href="${ctx}/client/list"><spring:message code="info.word.createorder"/></a></li>--%>
                            <li><a href="${ctx}/client/list">Клиенты</a></li>
                            <li><a href="${ctx}/product/list">Товар</a></li>
                            <li><a href="${ctx}/cart/list">Заказы</a></li>
                        </ul>
                    </li>

                    <li><a><i class="fa fa-edit"></i> <spring:message code="info.word.add"/> <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/client/add-page"><spring:message code="info.word.buyer"/></a></li>
                            <li><a href="">Заказ</a></li>
                            <%--for admin--%>
                            <sec:authorize var="loggedIn" access="hasAuthority('ADMIN_PRIVILEGE')"/>
                            <c:choose>
                                <c:when test="${loggedIn}">
                                    <li><a href="${ctx}/product/add-page"><spring:message code="info.word.product"/></a></li>
                                    <li><a href="${ctx}/configuration/product-category/list">Категорию</a></li>
                                    <li><a href="${ctx}/configuration/product-color/list">Цвет</a></li>
                                    <li><a href="${ctx}/configuration/price/list">Управление курсом</a></li>
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </li>

                    <%--for admin--%>
                    <sec:authorize var="loggedIn" access="hasAuthority('ADMIN_PRIVILEGE')"/>
                    <c:choose>
                        <c:when test="${loggedIn}">
                        <li><a><i class="fa fa-desktop"></i><spring:message code="info.word.users"/><span class="fa fa-chevron-down"></span></a>
                            <ul class="nav child_menu">
                                <li><a href="${ctx}/user/admin/list">Список пользователе</a></li>
                                <li><a href="${ctx}/role/list">Список ролей</a></li>
                                <li><a href="${ctx}/users/add-page">Добавить пользователя</a></li>
                            </ul>
                        </li>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>

                    <li><a><i class="fa fa-table"></i> Остатки <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="">Показать остатки</a></li>
                            <li><a href="">Вывести остатки</a></li>
                            <li><a href="">Архив фото</a></li>
                        </ul>
                    </li>

                    <li><a><i class="fa fa-info"></i>Info <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/about">О программе</a></li>
                            <li><a href="${ctx}/contacts"><spring:message code="info.word.contacts"/></a></li>
                            <li><a href="${ctx}/help">Помощь</a></li>
                            <li><a href="${ctx}/ref">Ссылки</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Выйти" href="${ctx}/logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="${ctx}/user/image/${userId}" alt=""><sec:authentication property="principal.user.firstName"/>
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="${ctx}/user/edit"> Личный кабинет</a></li>
                        <li>
                            <a href="javascript:;">
                                <%--<span class="badge bg-red pull-right">50%</span>--%>
                                <span>Настройки</span>
                            </a>
                        </li>
                        <li><a href="${ctx}/help">Помощь</a></li>
                        <li><a href="${ctx}/logout"><i class="fa fa-sign-out pull-right"></i> Выход</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>