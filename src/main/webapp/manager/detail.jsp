<%@page import="java.util.List"%>
<%@page import="bitcamp.java89.ems2.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>매니저 정보</h1>
<form action='update.do' method='POST' enctype='multipart/form-data'>
<table border='1'>
<tr><th>이메일</th><td><input name='email' type='text' value='${manager.email}'></td></tr>
<tr><th>암호</th><td><input name='password' type='password'></td></tr>
<tr><th>이름</th><td><input name='name' type='text' value='${manager.name}'></td></tr>
<tr><th>전화</th><td><input name='tel' type='text' value='${manager.tel}'></td></tr>
<tr><th>직급</th><td>
<select name='position'>
  <option value='사원' <c:if test='${manager.position=="사원"}'>selected</c:if> >사원</option>
  <option value='주임' <c:if test='${manager.position=="주임"}'>selected</c:if> >주임</option>
  <option value='대리' <c:if test='${manager.position=="대리"}'>selected</c:if> >대리</option>
  <option value='과장' <c:if test='${manager.position=="과장"}'>selected</c:if> >과장</option>
  <option value='차장' <c:if test='${manager.position=="차장"}'>selected</c:if> >차장</option>
  <option value='부장' <c:if test='${manager.position=="부장"}'>selected</c:if> >부장</option>
</select>
</td></tr>
<tr><th>팩스</th><td><input name='faxNum' type='text' value='${manager.faxNum}'></td></tr>
<tr><th>사진</th><td><img src='../upload/${manager.photoPath}' height='80'><input name='photoPath' type='file'></td></tr>
</table>
<button type='submit'>변경</button>
<a href='delete.do?memberNo=${manager.memberNo}'>삭제</a>
<input type='hidden' name='memberNo' value='${manager.memberNo}'>
<a href='list.do'>목록</a>
</form>