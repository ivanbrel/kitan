<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Start: page-top-outer -->
<div id="page-top-outer">

    <!-- Start: page-top -->
    <div id="page-top">

        <!-- start logo -->
        <div id="logo">

        </div>
        <!-- end logo -->

        <!--  start top-search -->
        <div id="top-search">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td><input type="text" value="Поиск" onblur="if (this.value=='') { this.value='Search'; }" onfocus="if (this.value=='Search') { this.value=''; }" class="top-search-inp" /></td>
                    <td>
                        <select  class="styledselect">
                            <option value=""> All</option>
                            <option value=""> Products</option>
                            <option value=""> Categories</option>
                            <option value="">Clients</option>
                            <option value="">News</option>
                        </select>
                    </td>
                    <td>
                        <input type="image" src="${ctx}/resources/img/shared/top_search_btn.gif"  />
                    </td>
                </tr>
            </table>
        </div>
        <!--  end top-search -->
        <div class="clear"></div>

    </div>
    <!-- End: page-top -->

</div>
<!-- End: page-top-outer -->

<div class="clear">&nbsp;</div>

<!--  start nav-outer-repeat................................................................................................. START -->
<div class="nav-outer-repeat">
    <!--  start nav-outer -->
    <div class="nav-outer">

        <!-- start nav-right -->
        <div id="nav-right">

            <div class="nav-divider">&nbsp;</div>
            <div class="showhide-account"><img src="${ctx}/resources/img/shared/nav/nav_myaccount.gif" width="93" height="14" alt="" /></div>
            <div class="nav-divider">&nbsp;</div>
            <a href="${ctx}/logout" id="logout"><img src="${ctx}/resources/img/shared/nav/nav_logout.gif" width="64" height="14" alt="" /></a>
            <div class="clear">&nbsp;</div>

            <!--  start account-content -->
            <div class="account-content">
                <div class="account-drop-inner">
                    <a href="${ctx}/edit/user" id="acc-settings">Настройки</a>
                    <div class="clear">&nbsp;</div>
                    <div class="acc-line">&nbsp;</div>
                    <a href="" id="acc-details">Личная информация</a>
                    <div class="clear">&nbsp;</div>
                    <div class="acc-line">&nbsp;</div>
                    <a href="" id="acc-inbox">Почта</a>
                    <div class="clear">&nbsp;</div>
                    <div class="acc-line">&nbsp;</div>
                    <a href="" id="acc-stats">Статистика</a>
                    <sec:authorize var="loggedIn" access="hasAuthority('ADMIN_PRIVILEGE')" />
                    <c:choose>
                        <c:when test="${loggedIn}">
                            <div class="clear">&nbsp;</div>
                            <div class="acc-line">&nbsp;</div>
                            <a href="" id="acc-settings">Управление пользователями</a>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <!--  end account-content -->

        </div>
        <!-- end nav-right -->


        <!--  start nav -->
        <div class="nav">
            <div class="table">

                <ul class="select">
                    <li><a href="${ctx}/home"><b>Заказы</b></a>
                    <div class="select_sub">
                    <ul class="sub">
                        <li><a href="${ctx}/purchase/list">Все заказы</a></li>
                        <li><a href="${ctx}/home">Оформить заказ</a></li>
                    </ul>
                    </div>
                    </li>
                </ul>

                <div class="nav-divider">&nbsp;</div>

                <ul class="select"><li><a href="${ctx}/product/list"><b>Продукция</b></a>
                    <div class="select_sub">
                        <ul class="sub">
                            <li class="sub_show"><a href="${ctx}/product/list">Вся продукция</a></li>
                            <li><a href="${ctx}/product/add-page">Добавить товар</a></li>
                        </ul>
                    </div>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
                </ul>
                <div class="nav-divider">&nbsp;</div>

                <ul class="select">
                    <li><a href="${ctx}/client/list"><b>Клиенты</b></a>

                    <div class="select_sub">
                        <ul class="sub">
                            <li><a href="${ctx}/client/list">Все клиенты</a></li>
                            <li><a href="${ctx}/client/add-page">Добавить клиента</a></li>
                        </ul>
                    </div>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
                </ul>

                <div class="nav-divider">&nbsp;</div>

                <ul class="select"><li><a href="#nogo"><b>Инфо</b><!--[if IE 7]><!--></a><!--<![endif]-->
                    <!--[if lte IE 6]><table><tr><td><![endif]-->
                    <div class="select_sub">
                        <ul class="sub">
                            <li><a href="${ctx}/about">О программе</a></li>
                            <li><a href="${ctx}/contacts">Контакты</a></li>
                            <li><a href="${ctx}/ref">Ссылки</a></li>
                            <li><a href="${ctx}/test">TEST</a></li>
                        </ul>
                    </div>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
                </ul>

                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
        <!--  start nav -->

    </div>
    <div class="clear"></div>
    <!--  start nav-outer -->
</div>
<!--  start nav-outer-repeat................................................... END -->
