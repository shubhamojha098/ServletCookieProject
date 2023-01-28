<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" 
crossorigin="anonymous">
</head>
<body>
 <h2 align="center">LoginPortal</h2>
    <hr color="red" size="5"/>
    <form action="lauth" method="post">
        <table width="60%" align="center">
            <tr>
                <td>
                    <fieldset>
                        <legend>
                            <b>Login</b>
                        </legend>
                           <table border="1" cellspacing="0" width="100%" cellpadding="3px">
                            <tr>
                                <td>UserName:</td>
                                <td><input type="text" name="username"/></td>
                            </tr>
                             <tr>
                                <td>Password</td>
                                <td><input type="text" name="password"/></td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="terms"/>
                                I accept <a href="#">Term and Condition</a>
                             </td>                         
                                <td>
                                   		<input type="submit" value="Login">
                                </td>
                            </tr>                     
                           </table>
                    </fieldset>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>