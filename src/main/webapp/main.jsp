<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="/head.jsp"/>
<body>
<jsp:include page="/header.jsp"/>
<section>
<h3>Ostatnie rozwiązania:</h3>
<table>
    <thead>
    <tr>
        <th>Solution ID:</th>
        <th>Exercise ID:</th>
        <th>User ID:</th>
        <th>Created:</th>
        <th>Updated:</th>
        <th>Description:</th>
    </tr>
    </thead>
    <tbody>
    <p>SOL ID: ${sol.getSolutionId}</p>
    <c:forEach items="${recentList}" var="recent">
        <tr>
            <td><c:out value="${recent.solutionId}"></c:out></td>
            <td>${recent.exerciseId}</td>
            <td>${recent.userId}</td>
            <td>${recent.created}</td>
            <td>${recent.updated}</td>
            <td>${recent.solutionDescription}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</section>
<jsp:include page="/footer.jsp"/>
</body>
</html>