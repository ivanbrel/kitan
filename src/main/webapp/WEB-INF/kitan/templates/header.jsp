<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${ctx}/index.jsp" class="site_title"><span>KITAN project</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile">
            <div class="profile_pic">
                <img src="${ctx}/resources/img/logo.png" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
                <span>Добро пожаловать,</span>
                <h2><sec:authentication property="principal.username"/></h2>
                <br/><br/>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br/><br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>Панель управления</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Главная <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/client/list">Оформить заказ</a></li>
                            <li><a href="index2.html">Показать остатки</a></li>
                            <li><a href="index3.html">Вывести остатки</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> Формы <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/client/add-page">Добавить нового клиента</a></li>
                            <li><a href="${ctx}/product/add-page">Добавить новый продукт</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> Исходные данные <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/price/list">Управление курсом</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-table"></i> Таблицы <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/client/list">Все клиенты</a></li>
                            <li><a href="${ctx}/product/list">Весь товар</a></li>
                            <li><a href="${ctx}/purchase/list">Все заказы</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-bar-chart-o"></i>Информация <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/about">О программе</a></li>
                            <li><a href="${ctx}/contacts">Контакты</a></li>
                            <li><a href="${ctx}/help">Помощь</a></li>
                            <li><a href="${ctx}/ref">Ссылки</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-clone"></i>Админ панель <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${ctx}/users/list">Список пользователе</a></li>
                            <li><a href="${ctx}/role/list">Список ролей</a></li>
                            <li><a href="${ctx}/users/add-page">Добавить пользователя</a></li>
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
                        <img src="${ctx}/resources/img/logo.png" alt=""><sec:authentication property="principal.username"/>
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
