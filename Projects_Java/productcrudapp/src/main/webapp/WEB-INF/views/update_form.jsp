<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="productcrudapp.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
   <div class="container">
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center mb-3">Update the details</h1>
                <form action="${pageContext.request.contextPath}/handle-product" method="post">
                <input type="text" value="${product.id}" name="id">
                <div class="form-group">
                    <label for="name">Product name</label>
                    <input type="text" class="form-control"id="name" name="name" placeholder="Enter the product name here" value="${product.name}">
                </div>
                <div class="form-group">
                    <label for="description">Product Description</label>
                    <textarea name="description" id="description" class="form-control" rows="5" placeholder="Enter the product description">${product.description}</textarea>
                </div>
                <div class="form-group">
                    <label for="price">Product Price</label>
                    <input type="text" class="form-control"id="price" name="price" placeholder="Enter the product price here" value="${product.price}">
                </div>
                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
                </form>
           </div>
     </div>
</body>
</html>