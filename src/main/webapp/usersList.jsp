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
            <h3>Ostatnie rozwiązania:</h3>
            <table class="steelBlueCols">
                <thead>
                <tr>
                    <th>User ID:</th>
                    <th>UserGroup ID:</th>
                    <th>User Name:</th>
                    <th>User E-mail</th>
                    <th>Details:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${usersList}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userGroupId}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td><a href="/solutionDetails?id=${user.id}">Szczegóły</a></td>
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