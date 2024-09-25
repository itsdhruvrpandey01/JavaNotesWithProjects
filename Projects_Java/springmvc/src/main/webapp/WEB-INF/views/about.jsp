<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = (String) request.getAttribute("name");
	Integer num = (Integer) request.getAttribute("number");
	List<String> friend= (List<String>) request.getAttribute("friends");
%>
<h2>hello Naam janke kya karoge fir bhi chalo itna puch hi rhe ho to <%= name %> ...!</h2>
<h3>Phone No. de rha hu magar call mat karna <%= num %> </h3>
<h4>TUm nhi jaana chhahte maagr fir mai tumhe bataunga....</h4>
<h3>ye mere dosto ke naaam hai sare acche insaan hai </h3>
<%
for(String fr:friend){
%>

<h4><%= fr%></h4>

<%
}
%>
</body>
</html>