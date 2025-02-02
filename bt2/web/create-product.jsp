<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product</title>
    </head>
    <body>
        <h1>Create Product</h1>
        <hr/>
        <form action="product">
            Id: <br/>
            <input type="text" name="id" value="${param.id}" disabled=""/> <br/>
            Name: <br/>
            <input type="text" name="name" value="${param.name}"/> <br/>
            Price: <br/>
            <input type="text" name="price" value="${param.price}"/> <br/>
            Expired Date: <br/>
            <input type="date" name="expDate" value="${param.expDate}"/> <br/>
            <input type="hidden" name="action" value="create_handler" />
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
</html>