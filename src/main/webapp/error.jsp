<%@page import="java.io.PrintWriter"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>

<jsp:include page="/header.jsp"/>
<h1>오류 내용</h1>
<pre>
<jsp:useBean id="error" class="java.lang.Throwable" scope="request"/>
<%
error.printStackTrace(new PrintWriter(out));
%>
</pre>
      
<jsp:include page="/footer.jsp"/>

</body>
</html>