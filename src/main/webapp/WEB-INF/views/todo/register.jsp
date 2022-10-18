<%--
  Created by IntelliJ IDEA.
  User: zerock
  Date: 2022-10-11
  Time: 오후 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp"%>
<main>
  <div class="container-fluid px-4">
    <h1 class="mt-4">Tables</h1>
    <ol class="breadcrumb mb-4">
      <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
      <li class="breadcrumb-item active">Tables</li>
    </ol>
    <div class="card mb-4">
      <div class="card-body">
        DataTables is a third party plugin that is used to generate the demo table below.
      </div>
    </div>
    <div class="card mb-4">
      <div class="card-header">
        <i class="fas fa-table me-1"></i>
        Table Example
      </div>
      <div class="card-body">
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

        <form action="/todo2/register" method="post">
          <input type="text" name="title">
          <input type="text" name="memo" >
          <input type="text" name="writer">
          <input type="date" name="dueDate" >
        <input type="checkbox" name="complete" >
        <button>submit</button>
        </form>

        <hr>
        <c:forEach items="${errors}" var="eachError">
          <h1>${eachError.getField()} -- ${eachError.defaultMessage}</h1>
        </c:forEach>
        <hr>

        <script>

          const errorObj = {};
          let message = '';
          <c:forEach items="${errors}" var="eachError">
            errorObj['${eachError.getField()}'] = '${eachError.defaultMessage}'
          message += '${eachError.getField()} ::  ${eachError.defaultMessage}\n'
          </c:forEach>

          console.log(errorObj)

          alert(message)

        </script>

      </div>
    </div>
  </div>
</main>
<%@include file="../includes/footer.jsp"%>