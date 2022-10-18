<%--
  Created by IntelliJ IDEA.
  User: zerock
  Date: 2022-10-11
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

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

                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">TNO</th>
                                <th scope="col" >TITLE</th>
                                <th scope="col">DUEDATE</th>
                                <th scope="col">WRITER</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${result.dtoList}" var="todo">
                            <tr>
                                <th scope="row"><c:out value="${todo.tno}"/></th>
                                <td class="read" data-tno =${todo.tno} ><c:out value="${todo.title}"/></td>
                                <td><c:out value="${todo.dueDate}"/></td>
                                <td><c:out value="${todo.writer}"/></td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <ul class="pagination">
                            <c:if test="${result.prev}">
                            <li class="page-item">
                                <a class="page-link" href="${result.start -1}" tabindex="-1">Previous</a>
                            </li>
                            </c:if>
                            <c:forEach begin="${result.start}" end="${result.end}" var="num">
                            <li class="page-item ${num == pageRequestDTO.page?"active":""}">
                                <a class="page-link" href="${num}">
                                    <c:out value="${num}"/>
                                </a>
                            </li>
                            </c:forEach>
                            <c:if test="${result.next}">
                            <li class="page-item">
                                <a class="page-link" href="${result.end+1}">Next</a>
                            </li>
                            </c:if>
                        </ul>

                    </div>
                </div>
            </div>
        </main>

<div class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<form id="actionForm" action="/todo/list" method="get">
    <input type="hidden" name="page" value="${pageRequestDTO.page}">
</form>
<script>
    const actionForm = document.querySelector('#actionForm')

    const result = '${oper}'

    const modal = new bootstrap.Modal(document.querySelector('.modal'))

    if(result === 'true'){
        modal.show()
    }


    document.querySelector(".pagination").addEventListener("click",(e)=> {
        e.preventDefault()
        e.stopPropagation()
        const target = e.target
        if(target.tagName !== 'A'){
            return
        }

        const pageNum = target.getAttribute("href")

        actionForm.action="/todo/list"
        actionForm.method ="get"
        actionForm.querySelector("input[name='page']").value = pageNum

        actionForm.submit()

    }, false)

    document.querySelector(".table").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()
        const target = e.target
        const tno = target.getAttribute("data-tno")

        console.log("-----------1")
        if(!tno){
            return
        }
        console.log("-----------2")


        actionForm.action="/todo/read"
        actionForm.method ="get"
        let str =""
        str += `<input type='hidden' name='tno' value='\${tno}'>`
        str += `<input type='hidden' name='page' value='${pageRequestDTO.page}'>`

        actionForm.innerHTML = str
        actionForm.submit()


    },false)


</script>
<%@include file="../includes/footer.jsp"%>