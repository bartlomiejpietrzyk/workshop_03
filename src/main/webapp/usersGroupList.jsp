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
            <h3>Grupy użytkowników:</h3>
            <table class="steelBlueCols">
                <thead>
                <tr>
                    <th>UserGroup ID:</th>
                    <th>UserGroup Name:</th>
                    <th>UserGroup Details:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userGroup}" var="userGroup">
                    <tr>
                        <td>${userGroup.id}</td>
                        <td>${userGroup.name}</td>
                        <td><a href="/solutionDetails?id=${userGroup.id}">Szczegóły</a></td>
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