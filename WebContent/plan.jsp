<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<body>
<div align="center">
    <h2><c:out value="${book.comment}" /></h2>
    <h3><c:out value="${book.valide}" /></h3>
    <img src="data:image/jpg;base64,${book.photo}" width="240" height="300"/>
</div>
</body>
</html>