<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
{
  "roles": [
    <c:forEach var="role" items="${roles}" varStatus="s">
        {
        "id": "${role.id}",
        "rolename": "${role.name}",

        }
        <c:if test="${s.last!=true}">,</c:if>
    </c:forEach>
  ],
  "total": ${fn:length(roles)},
  "success": true
}