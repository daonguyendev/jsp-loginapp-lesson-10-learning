<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='<%= request.getContextPath() %>/login' method='POST'>
        <label>Email Address:</label></br>
        <input type='email' placeholder='Please enter your email' name='email'></input></br></br>

        <label>Password:</label></br>
        <input type='password' placeholder='Please enter your password' name='password'></input></br></br>

        <button>Submit</button>
    </form>
</body>
</html>