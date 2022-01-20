<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>REGISTER</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="<%=request.getContextPath()%>/register" class="navbar-brand"> Register</a>
                    </div>
                    <div>
                        <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Login</a>
                    </div>

                    <ul class="navbar-nav">
                     
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       
                        <form action="<%= request.getContextPath() %>/register" method="post">
   						
                        <fieldset class="form-group">
                            <label>First Name</label> <input type="text"  class="form-control" name="firstName" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Last Name</label> <input type="text"  class="form-control" name="lastName" required="required">
                        </fieldset>
 						<fieldset class="form-group">
                            <label>UserName</label> <input type="text"  class="form-control" name="username" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Password</label> <input type="text"  class="form-control" name="password" required="required">
                        </fieldset>

                     <fieldset class="form-group">
                            <label>Address</label> <input type="text"  class="form-control" name="address" required="required">
                        </fieldset>
 						<fieldset class="form-group">
                            <label>Contact no</label> <input type="text"  class="form-control" name="contact" required="required">
                        </fieldset>

                       <button type="submit" class="btn btn-success">Save</button>
                        </form>
                       
                    </div>
                    
                </div>
          
            </div>
        </body>

        </html>