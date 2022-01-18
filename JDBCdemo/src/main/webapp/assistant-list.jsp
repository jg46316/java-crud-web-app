<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>assistant Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="/JDBCdemo/list" class="navbar-brand"> Student
     Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Student</a></li>
                        <li><a href="<%=request.getContextPath()%>/assistants" class="nav-link">Assistants</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Assistants</h3>
                    <hr>
                   
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Courses</th>
                                <th>Email</th>
                                <th>Students</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="assistant" items="${listAssistant}">

                                <tr>
                                    <td>
                                        <c:out value="${assistant.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${assistant.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${assistant.courses}" />
                                    </td>
                                    <td>
                                        <c:out value="${assistant.email}" />
                                    </td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;&nbsp; <a href="show?id=<c:out value='${assistant.id}' />">Show All his students</a>
                                    </td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>