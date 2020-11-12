<%@ page import="ru.com.nameofsite.db.DatabaseFacade" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.11.2020
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>вкладка</title>
</head>
<body>
<h1>сейчас чо-то буит</h1>
<br/>

<%
    if (request.getParameter("input") != null) {
        DatabaseFacade.insert(request.getParameter("input"));
    }
    for (String name : DatabaseFacade.getBooks()) {
        out.println(name + "<br/>");
    }

%>
<form>
    <div>
        <input name="input" type="text">

    </div>
    <div>
        <input type="submit">

    </div>
</form>

<h2>или нет</h2>
</body>
</html>
