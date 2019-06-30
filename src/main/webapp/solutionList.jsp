<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="/head.jsp"/>
<body>
<div class="mainContainer">
    <div class="topUp">
        <jsp:include page="/header.jsp"/>
    </div>
    <jsp:include page="/menu.jsp"/>
    <div class="dataContainer">
        <section>
            <h3>Rozwiązania zadań:</h3>
            <table class="steelBlueCols">
                <thead>
                <tr>
                    <th>Solution ID:</th>
                    <th>Exercise ID:</th>
                    <th>User ID:</th>
                    <th>Created:</th>
                    <th>Updated:</th>
                    <th>Description:</th>
                    <th>Details:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${solutionList}" var="solution">
                    <tr>
                        <td>${solution.solutionId}</td>
                        <td>${solution.exerciseId}</td>
                        <td>${solution.userId}</td>
                        <td>${solution.created}</td>
                        <td>${solution.updated}</td>
                        <td>${solution.solutionDescription}</td>
                        <td><a href="/solutionDetails?id=${solution.id}">Szczegóły</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </section>
    </div>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>