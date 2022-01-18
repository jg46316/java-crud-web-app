<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Student Management Application</title>
</head>
<body>
    <div style="text-align: center">
        <h1>User Login</h1>
        <form action="login" method="post">
            <label for="username">Email:</label>
            <input name="username" size="30" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br>           
            <button type="submit">Login</button>
        </form>
        </br>
         <label >You still does not have an account?:</label>
         <a href="<%=request.getContextPath()%>/register" class="nav-link">
  <button class="button button-blue button-bordered">
    <span class="button--inner">Register</span>
  </button>
</a>
      
    </div>
</body>
</html>