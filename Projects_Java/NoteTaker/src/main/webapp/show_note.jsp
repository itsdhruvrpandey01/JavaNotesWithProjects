<%@page import="com.helper.FactoryProvider" %>
<%@page import="org.hibernate.Session" %>
<%@page import="com.entities.*" %>
<%@page import="java.util.*" %>
<%@page import="org.hibernate.Query" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Note taker Show page</title>
      <%@include file="all_css_js.jsp" %>
   </head>
  <body>
    <div class="container-fluid">
    <%@include file="navbar.jsp" %>
    <h3 class="text-uppercase">All notes:</h3>
    <div class="row">
    <div class="col-12">
    <%
    Session s = FactoryProvider.getFactory().openSession();
    Query  q = s.createQuery("from Note");
    List<Note> list = q.list();
    for(Note note:list){
    %>
    
    <div class="card mt-3" style="width: 18rem;">
  <img src="img/notes.png" style="max-width: 100px;" class="card-img-top m-3" alt="...">
  <div class="card-body">
    <h5 class="card-title"><%= note.getTitle() %></h5>
    <p class="card-text"><%= note.getContent() %></p>
    <p clas="card-text"><%= note.getAddedDate() %></p>
    <a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
    <a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">Upadate</a>
  </div>
</div>

    <%
    	// out.println(note.getId()+" : "+note.getTitle()+"<br>");
    }
    %>
    </div>
    </div>
    </div>
  </body>
</html>