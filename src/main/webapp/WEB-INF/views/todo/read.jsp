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
    <h1 class="mt-4">Todo READ</h1>
    <ol class="breadcrumb mb-4">
      <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
      <li class="breadcrumb-item active">TODO READ</li>
    </ol>
    <div class="card mb-4">
      <div class="card-body">
        ${reqDTO}
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
            <label>TNO</label>

            <input type="checkbox" name="complete" checked="${dto.complete?"checked":""}">

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
          <button type="button" class="btn btn-warning modBtn">MOD/DEL</button>
          <button type="button" class="btn btn-primary listBtn">LIST</button>
        </form>

        <script>
          document.querySelector(".listBtn").addEventListener("click",(e) => {

            const page = ${reqDTO.page}
                    self.location =`/todo/list?page=\${page}`

          }, false)

          document.querySelector(".modBtn").addEventListener("click",(e) => {

            const tno = ${dto.tno}
            const page = ${reqDTO.page}
                    self.location =`/todo/modify?page=\${page}&tno=\${tno}`

          }, false)

        </script>


      </div>
    </div>
  </div>
</main>
<%@include file="../includes/footer.jsp"%>