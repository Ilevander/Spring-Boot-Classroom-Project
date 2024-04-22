<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Classrooms</title>
</head>
<body>
    <h1>List of Classrooms</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Classroom ID</th>
                <th>Classroom Name</th>
                <th>Location</th>
                <th>Capacity</th>
                <th>Schedule</th>
                <th>Virtual Platform</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="classroom" items="${classrooms}">
                <tr>
                    <td>${classroom.classroomId}</td>
                    <td>${classroom.classroomName}</td>
                    <td>${classroom.location}</td>
                    <td>${classroom.capacity}</td>
                    <td>${classroom.schedule}</td>
                    <td>${classroom.virtualPlatform}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
