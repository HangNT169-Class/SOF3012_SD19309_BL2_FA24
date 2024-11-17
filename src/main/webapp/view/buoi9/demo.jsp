<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 17/11/24
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Request: ${message1}</p>
<%--Code Java: <%code o giua%>--%>
<%--KHI MUON DUNG PAGE => BAT BUOC PHAI SU DUNG O JSP --%>
<%--KHI DUNG PAGE DU CHAY JSP/SERVLET => DEU MANG GIA TRI
    REQUEST: CHAY SERVLET THI MOI CO GIA TRI
--%>
<%
    // Thiet lap gia tri cho pageContext => setAttribute
    pageContext.setAttribute("message2", "Scope - JSP & Servlet - Page");
    // Lay gia tri ra => getAttribute
    String message2 = (String) pageContext.getAttribute("message2");
%>
<p>Page: ${message2}</p>
<%--C1: Goi truc tiep servlet ->jsp--%>
<p>Application: ${message3}</p>
<p>Session: ${message4}</p>
</body>
</html>
