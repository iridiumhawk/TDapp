<%--
  Created by IntelliJ IDEA.
  User: hawk
  Date: 10.05.2016
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<jsp:include page="headTag.jsp"/>


<body>
<div align="center">
<h2>Создать новое дело</h2>
<p>


<c:choose>
    <c:when test="${error}">
      <b> ОШИБКА!!! </b>
    </c:when>
   </c:choose>

    </p>

<form:form method="POST" modelAttribute="createnote" accept-charset="UTF-8">
    <form:input type="hidden" path="id" id="id"/>

    <table>
        <tr>
            <td><label for="title">Категория: (текст до 100 сим.)</label> </td>
            <td ><form:input path="title" id="title"/></td>
            <td><form:errors path="title" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label for="note">Что сделать: (текст  до 1000 сим.)</label> </td>
            <td ><form:input path="note" id="note" /></td>
            <td><form:errors path="note" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="beginDate">Когда начинается: (дд/мм/гггг)</label> </td>
            <td ><form:input path="beginDate" id="beginDate" /></td>
            <td><form:errors path="beginDate" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="endDate">Когда заканчивается: (дд/мм/гггг)</label> </td>
            <td ><form:input path="endDate" id="endDate" /></td>
            <td><form:errors path="endDate" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="done">Выполнено: (true/false)</label> </td>
            <td width="300"><form:input path="done" id="done"/></td>
            <td><form:errors path="done" cssClass="error"/></td>
        </tr>


        <tr>
            <td colspan="3" align="center">
                <br/>
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Обновить"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Создать"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</form:form>
<br/>
<br/>
    Вернуться обратно к  <a href="<c:url value='/list' />">списку дел</a>

    </div>
</body>
</html>
