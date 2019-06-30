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
            <h3>Zadania:</h3>
            <table class="steelBlueCols">
                <thead>
                <tr>
                    <th>Exercise ID:</th>
                    <th>Exercise Title:</th>
                    <th>Exercise Description:</th>
                    <th>Details:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${exerciseList}" var="exercise">
                    <tr>
                        <td>${exercise.id}</td>
                        <td>${exercise.title}</td>
                        <td>${exercise.description}</td>
                        <td><a href="/exerciseDetails?id=${exercise.id}">Szczegóły</a></td>
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