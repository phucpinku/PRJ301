<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating an appointment </title>
    </head>
    <body>
        <h1>Creating appointment</h1>
        <hr/>
        <!--your code here-->
        <form action="MainController">
            Id: <br/>
            <input type="text" disabled=""> <br/>
            Account: <br/>
            <input type="text" name="account" value="${param.account}"> <br/>
            PartnerPhone: <br/>
            <input type="text" name="partnerPhone" value="${param.partnerPhone}" > <br/>
            PartnerName: <br/>
            <input type="text" name="partnerName" value="${param.partnerName}" > <br/>
            Time to Meet: <br/>
            <input type="date" name="timeToMeet" value="${param.timeToMeet}"> <br/>
            Place: <br/>
            <input  type="text" name="place" value="${param.place}" > <br/>
            Expense: <br/>
            <input type="text" name="expense" value="${param.expense}"> <br/>
            Note: <br/>
            <input type="text" name ="note" value="${param.note}" > <br/>
            <input type="hidden" name="action" value="create_handler" />
            <button type="submit" name="op" value="create">Create</button>
            <button type="submit" name="op" value="cancel">Cancel</button>
        </form>
    </body>
</html>
