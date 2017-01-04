<%@page import="java.util.List"%>
<%@page import="bitcamp.java89.ems2.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강사 관리-목록</title>
</head>
<body>

<jsp:include page="../header"/>

<h1>강사 정보</h1>
<a href='form.html'>추가</a><br>
<table border='1'>
<tr>
  <th>강사번호</th>
  <th>이름</th>
  <th>전화</th>
  <th>이메일</th>
  <th>홈페이지</th>
</tr>
<c:forEach var="teacher" items="${requestScope.teachers}">
<tr>
  <td>${teacher.memberNo}</td>
  <td><a href='detail?memberNo=${teacher.memberNo}'>${teacher.name}</a></td>
  <td>${teacher.tel}</td>
  <td>${teacher.email}</td>
  <td>${teacher.homePage}</td>
</tr>
</c:forEach>
</table>

<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>
