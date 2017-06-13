<%--
  Created by IntelliJ IDEA.
  User: hawk
  Date: 10.05.2016
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="headTag.jsp"/>
<body>
<div align="center"><h2>Результат выполнения действия</h2> </div>
<div align="center">
Сообщение: ${success}
<br/>
<br/>
Вернуться обратно к  <a href="<c:url value='/list' />">списку дел</a>
</div>

</body>

</html>