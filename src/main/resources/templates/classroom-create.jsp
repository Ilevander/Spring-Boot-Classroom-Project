<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Create Classroom</title>
</head>
<body>
    <h1>Create Classroom</h1>
    <form:form modelAttribute="classroom" method="POST" action="/classrooms/new">
        <table>
            <tr>
                <td>Classroom Name:</td>
                <td><form:input path="classroomName"/></td>
            </tr>
            <tr>
                <td>Location:</td>
                <td><form:input path="location"/></td>
            </tr>
            <tr>
                <td>Capacity:</td>
                <td><form:input path="capacity"/></td>
            </tr>
            <tr>
                <td>Schedule:</td>
                <td><form:input path="schedule"/></td>
            </tr>
            <tr>
                <td>Virtual Platform:</td>
                <td><form:input path="virtualPlatform"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Create"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
