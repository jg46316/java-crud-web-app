<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>student Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Login </a>
                    </div>

                    <ul class="navbar-nav">
                     
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       
                        <form action="login" method="post">
   						
                        <fieldset class="form-group">
                            <label for="username">Username</label> <input type="text"  class="form-control" name="username" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label for="password" >Password</label> <input type="password"  class="form-control" name="password" required="required">
                        </fieldset>
						<br>${message}
                    
                        <button type="submit" class="btn btn-success">Login</button>
                        </form>
                       
                    </div>
                    
                </div>
                 <label >You still don't have an account?</label>
         <a href="<%=request.getContextPath()%>/register" class="nav-link">
				 	<button class="btn btn-secondary">
    			<span class="button--inner">Register</span>
    			 </button>
		</a>
            </div>
        </body>

        </html>