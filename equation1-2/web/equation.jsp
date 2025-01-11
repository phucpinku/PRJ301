<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Equation solver</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <h1>Equation: ax+b = 0</h1>
        <hr/>
        <form action="equation"> 
            Factor a:<br/>
            <input type="text" name="a" value="${param.a}"/><br/>
            Factor b:<br/>
            <input type="text" name="b" value="${param.b}"/><br/>
            <input type="submit" value="solve"/>
        </form>
        Result: ${model.result}
        <!--${result}: lay attribute result tu doi tuong request-->
        
    </body>
</html>
