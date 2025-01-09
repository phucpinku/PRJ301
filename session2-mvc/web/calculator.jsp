<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Calculator</h1>
        <hr/>
        <form action="calculator"> 
            <!--calculator1: is URL pattern of servlet will process form -->
            Number 1:<br/>
            <input type="text" name="num1" value="${param.num1}"/><br/>
            Number 2:<br/>
            <input type="text" name="num2" value="${param.num2}"/><br/>
            <input type="submit" name="op" value="Add"/>
            <input type="submit" name="op" value="Sub"/>
            <input type="submit" name="op" value="Mul"/>
            <input type="submit" name="op" value="Div"/>
            <input type="reset" value="Reset"/>
        </form>
        Result: ${result}
        <!--${result}: lay attribute result tu doi tuong request-->
        
    </body>
</html>
