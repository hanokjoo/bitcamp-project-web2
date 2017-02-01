<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id='header' style='background-color: gray; height: 60px; position:relative;'>
	<div style='width:300px; height:58px;  position:absolute; left:0px; top:0px;'>
		<img src='../image/go.jpg' height='50' style='float: left; margin-top: 5px; margin-left: 5px;'>
		<div style='color: white; font-weight: bold; margin-left: 80px; padding-top: 15px; font-family: D2Coding, sans-serif; font-size: x-large;'>교육센터관리시스템</div>
  </div>
	<div style='height:50px; margin-top: 5px; float:right;'>
<c:choose>
<c:when test="${not empty member}">
  <img src='../upload/${photoPath}' height='50' style='vertical-align:middle;'>
  <span>${member.name}</span>
  <a href='../auth/logout.do'>로그아웃</a>
</c:when>
<c:otherwise>
  <a href='../auth/loginform.do' style='position:absolute; right:0px; top:15px;'>로그인</a>
</c:otherwise>
</c:choose>
  </div>
</div>