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
                <form id="actionForm">
                    <div class="form-group">
                        <label>TNO</label>
                        <input type="text" class="form-control" name="tno" value="${dto.tno}" readonly>
                    </div>

                    <button type="button" class="btn btn-danger delBtn">DEL</button>
                    <button type="button" class="btn btn-warning modBtn">MOD</button>
                    <button type="button" class="btn btn-primary listBtn">LIST</button>
                </form>

                <script>

                    const actionForm = document.querySelector("#actionForm")

                    document.querySelector(".listBtn").addEventListener("click",(e) => {

                        const page = ${reqDTO.page}
                            self.location =`/todo/list?page=\${page}`

                    }, false)

                    document.querySelector(".delBtn").addEventListener("click",(e) => {

                        e.preventDefault()
                        e.stopPropagation()

                        actionForm.action="/todo/remove"
                        actionForm.method ="post"
                        actionForm.submit()


                    }, false)

                </script>


            </div>
        </div>
    </div>
</main>
<%@include file="../includes/footer.jsp"%>