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
<title>강사 관리-상세정보</title>
</head>
<body>

<jsp:include page="../header.jsp"/>

<h1>강사 정보</h1>
<form action='update' method='POST' enctype='multipart/form-data'>
<table border='1'>
<tr><th>이메일</th><td><input name='email' type='text' value='${teacher.email}'></td></tr>
<tr><th>암호</th><td><input name='password' type='password'></td></tr>
<tr><th>이름</th><td><input name='name' type='text' value='${teacher.name}'></td></tr>
<tr><th>전화</th><td><input name='tel' type='text' value='${teacher.tel}'></td></tr>
<tr><th>홈페이지</th><td><input name='homePage' type='text' value='${teacher.homePage}'></td></tr>
<tr><th>페이스북</th><td><input name='faceBook' type='text' value='${teacher.faceBook}'></td></tr>
<tr><th>트위터</th><td><input name='twitter' type='text' value='${teacher.twitter}'></td></tr>
<tr><th>사진</th><td><img src='../upload/${photoList[0].filePath}' height='80'><input name='photoPath1' type='file'></td></tr>
<tr><th>사진</th><td><img src='../upload/${photoList[1].filePath}' height='80'><input name='photoPath2' type='file'></td></tr>
<tr><th>사진</th><td><img src='../upload/${photoList[2].filePath}' height='80'><input name='photoPath3' type='file'></td></tr>
</table>
<button type='submit'>변경</button>
<a href='delete?memberNo=21'>삭제</a>
<input type='hidden' name='memberNo' value='21'>
<a href='list'>목록</a>
</form>

<jsp:include page="../footer.jsp"/>

</body>
</html>
