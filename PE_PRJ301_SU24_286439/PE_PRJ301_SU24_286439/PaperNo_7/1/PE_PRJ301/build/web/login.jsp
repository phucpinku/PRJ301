<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr/>
        <!--your code here-->
        <form action="MainController">
            account: <br/>
            <input type="text" name="account" value="${param.account}"/> <br/>
            password: <br/>
            <input type="password" name="pass" value="${param.pass}"/> <br/>
            <input type="hidden" name="action" value="login"/>
            <button type="submit" name ="op" value="login">login</button>
        </form>
            <i style="color:red">${message}</i>
    </body>
</html>
