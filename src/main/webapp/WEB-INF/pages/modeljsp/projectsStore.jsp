<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
{
  "projects": [
    <c:forEach var="project" items="${projects}" varStatus="s">
        {
        "id": "${project.id}",
        "name": "${project.projectName}",
        }
        <c:if test="${s.last!=true}">,</c:if>
    </c:forEach>
  ],
  "total": ${fn:length(projects)},
  "success": true
}