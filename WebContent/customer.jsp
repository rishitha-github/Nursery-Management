<%@page import="java.util.ArrayList" %>
<%@page import="com.nmod.Cmod" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer details</title>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body style="background-color:#C2E5D3">
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
        <br><br>
<centre>
<center><h3 style="color:#1B8A6B"><u>CUSTOMER DETAILS</u> </h3></center><br>
<table class ="table table-striped ">
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile Number</th>
<th>Amount Paid</th>
</tr>


<%ArrayList<Cmod> all=(ArrayList<Cmod>)request.getAttribute("cdis");
for(Cmod e:all)
{
%>
<tr>
<td><%=e.getId() %></td>
<td><%=e.getCname() %></td>
<td><%=e.getCnumber() %></td>
<td><%=e.getAmt() %></td>
</tr>
<%} %>
</table>
<form action="back1" method="post">
<center><input type ="submit" value ="Back"></center>
</form>
</centre>
</body>
</html>