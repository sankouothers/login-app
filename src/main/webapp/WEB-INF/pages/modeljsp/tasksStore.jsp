<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
{
  "tasks": [
    <c:forEach var="task" items="${tasks}" varStatus="s">
        {
        "id": "${task.id}",
        "name": "${task.taskName}",
        }
        <c:if test="${s.last!=true}">,</c:if>
    </c:forEach>
  ],
  "total": ${fn:length(tasks)},
  "success": true
}