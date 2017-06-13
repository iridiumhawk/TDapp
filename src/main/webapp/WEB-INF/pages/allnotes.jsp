<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="headTag.jsp"/>

<body>
<div align="center"><h2><fmt:message key="app.pagetitle"/></h2> </div>
<div align="center">

<table cellpadding="5" cellspacing="1">
    <tr>
        <td><a href="<c:url value='/sortbyid' />">ID</a></td>
        <td><a href="<c:url value='/sortbycategory' />"><fmt:message key="app.category"/></a></td>
        <td><a href="<c:url value='/sortbynote' />"><fmt:message key="app.note"/></a></td>
        <td><fmt:message key="app.timefrom"/></td>
        <td><fmt:message key="app.timeto"/></td>
        <td><fmt:message key="app.done"/></td>
        <td><fmt:message key="app.edit"/></td><td><fmt:message key="app.delete"/></td>
    </tr>
    <c:forEach items="${notes}" var="note">
        <tr>
            <td>${note.id}</td>
            <td>${note.title}</td>
            <td>${note.note}</td>
            <td>${note.beginDate}</td>
            <td>${note.endDate}</td>
            <td>${note.done}</td>

            <td><a href="<c:url value='/edit-${note.id}-note' />"><fmt:message key="app.edit"/></a></td>
            <td><a href="<c:url value='/delete-${note.id}-note' />"><fmt:message key="app.delete"/></a></td>
        </tr>
    </c:forEach>
</table>
    <br/>

    <c:forEach items="${pages}" var="page">

            <a href="<c:url value='/page-${page}' />">${page}</a>&nbsp;

    </c:forEach>
<br/>
<p>
<a href="<c:url value='/new' />"><fmt:message key="app.newnote"/></a>
</p>
<%--<p>
<a href="<c:url value='/gen' />">Генерировать новое дело</a>

</p>--%>

    <p>
        <b><fmt:message key="app.search"/></b>
    </p>
    <form action="${pageContext.request.contextPath}/find"
          method="post">
        <label for="input"><fmt:message key="app.labelsearch"/></label> <br/>
        <input type="text" name="input">

        <input type="submit" value="<fmt:message key="app.buttonsearch"/>">
    </form>

    <p>
        <a href="<c:url value='/' />"><fmt:message key="app.returntomain"/></a>

    </p>
</div>
</body>
</html>