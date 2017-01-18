<%@page import="java.util.List"%>
<%@page import="bitcamp.java89.ems2.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>매니저 등록폼</h1>
<form action='add.do' method="POST" enctype="multipart/form-data">
<table border='1'>
<tr><th>이메일</th><td><input name='email' type='text' placeholder='예)hong@test.com'></td></tr>
<tr><th>암호</th><td><input name='password' type='password'></td></tr>
<tr><th>이름</th><td><input name='name' type='text' placeholder='예)홍길동'></td></tr>
<tr><th>전화</th><td><input name='tel' type='text' placeholder='예)111-1111'></td></tr>
<tr><th>직급</th><td>
  <select name='position'>
    <option value='사원'>사원</option>
    <option value='주임'>주임</option>
    <option value='대리'>대리</option>
    <option value='과장'>과장</option>
    <option value='차장'>차장</option>
    <option value='부장'>부장</option>
  </select>
</td></tr>
<tr><th>팩스</th><td><input name='faxNum' type='text' placeholder='예)111-1111'></td></tr>
<tr><th>사진</th><td><input name='photo' type='file'></td></tr>
</table>
<button type='submit'>등록</button>
<a href='list.do'>목록</a>
</form>