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
                       
                       <div>
                        <h1>You are  successfully registered!</h1>
                    </div>
                    <div>
                       <h1>LOGIN !</h1>
				         <a href="<%=request.getContextPath()%>/" class="nav-link">
								 	<button class="btn btn-secondary">
				    			<span class="button--inner">LOGIN</span>
				    			 </button>
						 </a>
                    </div>
                       
                    </div>
                    
                </div>
          
            </div>
        </body>

        </html>