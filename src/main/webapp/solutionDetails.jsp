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
            <h3>Szczegóły rozwiązania:</h3>
            <table class="steelBlueCols">
                <thead>
                <tr>
                    <th>Solution ID:</th>
                    <td>
                        <p></p>
                    </td>
                </tr>
                <tr>
                    <th>Exercise ID:</th>
                    <td>EX ID ${solution.exerciseId}</td>
                </tr>
                <th>User ID:</th>
                <td>USERID ${solution.userId}</td>
                </tr>
                <tr>
                    <th>Created:</th>
                    <td>CREATED ${solution.created}</td>
                </tr>
                <tr>
                    <th>Updated:</th>
                    <td>UPDATED ${solution.updated}</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th>
                        asd
                    </th>
                </tr>
                </thead>
            </table>

        </section>
    </div>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>