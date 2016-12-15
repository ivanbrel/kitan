<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!-- page content -->
<div class="col-md-12">
    <div class="col-middle">
        <div class="text-center text-center">
            <h1 class="error-number">404</h1>
            <button class="btn btn-default" onclick="history.back()">Вернуться на предыдущую страницу</button><br/>
            <p >Страница не найдена</p>
            <p >Если у Вас возникли вопросы, пожалуйста, обратитесь к техническому персоналу, контакты внизу страницы.</p>
            <div class="mid_center">
                <h3>Описание</h3>
                <form>
                    <div class="col-xs-12 form-group pull-right top_search">
                        <p><b>Код:</b> ${pageContext.errorData.statusCode}</p>
                        <p><b>Запрашиваемый URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->