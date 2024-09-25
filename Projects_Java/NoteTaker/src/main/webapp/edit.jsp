<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.helper.*,org.hibernate.*,com.entities.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
      <%@include file="all_css_js.jsp" %>
</head>
<body>
<div class="container">
<%@include file="navbar.jsp" %>
<h1>Inside the edit page</h1>
<% 
int noteId=Integer.parseInt(request.getParameter("note_id").trim());
Session s = FactoryProvider.getFactory().openSession();
Note note = (Note)s.get(Note.class, noteId);
%>
<form action="UpdateServlet" method="post">
  <div class="form-group">
  <input type="hidden" id="id" name="id" value="<%= note.getId()%>">
    <label for="note_title">Note Title:</label>
    <input type="text" class="form-control" id="note_title" placeholder="Enter Title" name="title" value="<%= note.getTitle()%>">
  </div>
  <div class="form-group">
    <label for="content">content</label>
    <textarea rows="15"cols="15" id="content" placeholder="Enter your Content here"class="form-control" name="content" ><%=note.getContent()%></textarea>
  </div>
  <div class="container text-center pt-3">
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>
</div>
</body>
</html>