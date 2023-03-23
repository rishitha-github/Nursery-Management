 <%@page import="java.util.ArrayList" %>
 <%@page import="com.nmod.Nmod" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell Stock</title>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body style = "background-color:lightblue">

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a  class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <li class="nav-item">
        <i class='fas fa-seedling' style='font-size:24px;color:green'></i>
        </li>
        <li class="nav-item">
          <h2 style ="color:green">Plant</h2>
 
        </li>
        <li>
        <h2 style ="color:orange">Care</h2></li>
        </ul>
        </div>
        </div>
        </nav>
 
        <br><br><br>
<div style= "float:left; margin-left: 150px;">
<h1 style="color:blue">PLANT STOCK </h1><br><br>
<table class ="table table-striped w-auto" >
<tr>
<th>Stock Id</th>
<th>Number of Plants</th>
</tr>
<%ArrayList<Nmod> al=(ArrayList<Nmod>)request.getAttribute("dis");
for(Nmod a:al)
{
	%>
	<tr>
	<td  style="align:center"><%=a.getStockid() %></td>
	<td style="align:center"><%=a.getNumber() %></td>
	</tr>
<% 
}
%>
</table><br><br>
<center>
<form action="back1" method="post">
<input type ="submit" value ="Back">
</form>
</center>
</div>
<div style="float :right; width:500px">
<form action="sell" method="post">
<h1 style="color:blue">CUSTOMER DETAILS</h1><br><br>
<b><label>StockNumber:</label></b><br>
<input type="number" name="snumber"><br><br>
<b><label>Name:</label><br></b>
<input type="text" name="cname" placeholder="enter customer name" required="required"><br><br>
<b><label>Phone Number:</label></b><br>
<input type="number" name="cnum" placeholder="enter customer number" required="required"><br><br>
<b><label>Amount Paid:</label></b><br>
<input type="number" name="anum" placeholder="enter amount"required="required" ><br><br>
<input type="submit"  value="Sell">


</form>
</div>
</body>
</html>