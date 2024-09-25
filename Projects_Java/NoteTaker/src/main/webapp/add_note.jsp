<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Notetake Add page</title>
      <%@include file="all_css_js.jsp" %>
   </head>
  <body>
    <div class="container-fluid">
    <%@include file="navbar.jsp" %>
    <h3>Inside the Add Note</h3>
    <form action="SaveNoteServlet" method="post">
  <div class="form-group">
    <label for="note_title">Note Title:</label>
    <input type="text" class="form-control" id="note_title" placeholder="Enter Title" name="title">
  </div>
  <div class="form-group">
    <label for="content">content</label>
    <textarea rows="15"cols="15" id="content" placeholder="Enter your Content here"class="form-control" name="content"></textarea>
  </div>
  <div class="container text-center pt-3">
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>
    </div>
  </body>
</html>