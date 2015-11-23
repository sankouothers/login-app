<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
{
  "users": [
    <c:forEach var="user" items="${users}" varStatus="s">
        {
        "id": "${user.id}",
        "username": "${user.username}",
        "age": "${user.age}",
        "email": "${user.email}",
        "birthDate": "${user.birthDate}",
        "phoneNumber": "${user.phoneNumber}",
        "gender": "${user.gender}"
        }
        <c:if test="${s.last!=true}">,</c:if>
    </c:forEach>
  ],
  "total": ${fn:length(users)},
  "success": true
}