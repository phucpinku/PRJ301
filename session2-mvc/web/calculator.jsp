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
            <button type="summit" name="op" value="add">Add</button>
            <button type="summit" name="op" value="sub">Sub</button>
            <button type="summit" name="op" value="mul">Mul</button>
            <button type="summit" name="op" value="div">Div</button>
        </form>
        Result: ${model.result}
        <%--
                    ${model.result}: ben duoi se thuc hien model.getResult()
        --%>
        
    </body>
</html>
