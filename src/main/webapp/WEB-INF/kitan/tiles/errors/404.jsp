<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>404 - страница не найдена</h2>
<br/>
<p><b>Код:</b> ${pageContext.errorData.statusCode}</p>
<p><b>Запрашиваемый URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>


