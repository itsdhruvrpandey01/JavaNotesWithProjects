<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="productcrudapp.model.*" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<body>
<div class="container">
<h2>Welcome</h2>
<table class="table">
  <thead class="table-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <% List<Product> products= (List<Product>) request.getAttribute("products");%>
  <% for(Product p:products){ %>
  <tr>
      <th scope="row">TECHONLY<%= p.getId() %></th>
      <td><%= p.getName() %></td>
      <td><%= p.getDescription() %></td>
      <td class="font-weight-bold">&#x20B9; <%= p.getPrice() %></td>
      <td><a href="delete/<%=p.getId()%>"><i class="fa-solid fa-trash text-danger"></i></a>
      <a href="update/<%=p.getId()%>"><i class="fa-solid fa-pen-nib text-primary"></i></a>
      </td>
    </tr>
  <%} %>
  <%-- <c:forEach items="${products}" var="p">
  <tr>
    <th scope="row">Technology ${p.id }</th>
    <td>${p.name }</td>
    <td>${p.description }</td>
    <td>${p.price }</td>
  </tr>
</c:forEach> --%>
  <tbody>
</table>
<div class="container text-center">
<a href="add-product" class="btn btn-outline-success">Add Product</a>
</div>
</div>
</body>
</html>
