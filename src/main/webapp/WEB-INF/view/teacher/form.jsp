<%@page import="java.util.List"%>
<%@page import="bitcamp.java89.ems2.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>강사 등록폼</h1>
<form action='add.do' method="POST" enctype="multipart/form-data">
<table border='1'>
<tr><th>이메일</th><td><input name='email' type='text' placeholder='예)hong@test.com'></td></tr>
<tr><th>암호</th><td><input name='password' type='password'></td></tr>
<tr><th>이름</th><td><input name='name' type='text' placeholder='예)홍길동'></td></tr>
<tr><th>전화</th><td><input name='tel' type='text' placeholder='예)111-1111'></td></tr>
<tr><th>홈페이지</th><td><input name='homePage' type='text' placeholder='예)www.user.com'></td></tr>
<tr><th>페이스북</th><td><input name='faceBook' type='text' placeholder='예)www.facebook.com/user'></td></tr>
<tr><th>트위터</th><td><input name='twitter' type='text' placeholder='예)www.twitter.com/user'></td></tr>
<tr><th>사진</th><td><input name='photo1' type='file'></td></tr>
<tr><th>사진</th><td><input name='photo2' type='file'></td></tr>
<tr><th>사진</th><td><input name='photo3' type='file'></td></tr>
</table>
<button type='submit'>등록</button>
<a href='list.do'>목록</a>
</form>