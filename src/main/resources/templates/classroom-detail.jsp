<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classroom Detail</title>
</head>
<body>
    <h1>Classroom Detail</h1>
    <table>
        <tr>
            <td>Classroom ID:</td>
            <td>${classroom.classroomId}</td>
        </tr>
        <tr>
            <td>Classroom Name:</td>
            <td>${classroom.classroomName}</td>
        </tr>
        <tr>
            <td>Location:</td>
            <td>${classroom.location}</td>
        </tr>
        <tr>
            <td>Capacity:</td>
            <td>${classroom.capacity}</td>
        </tr>
        <tr>
            <td>Schedule:</td>
            <td>${classroom.schedule}</td>
        </tr>
        <tr>
            <td>Virtual Platform:</td>
            <td>${classroom.virtualPlatform}</td>
        </tr>
    </table>
</body>
</html>
