<%-- 
    Document   : index
    Created on : May 24, 2017, 3:25:47 PM
    Author     : Hallur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <style>
            body{
                background-color: khaki;
            }
            textarea{
                height: 300px;
                width: 400px;
                background-color: white;
            }
            #autoSend{
                display: none;
            }
            #madeBy{
                position: absolute;
                margin: 0 auto;
                top : 0;
                left: 0;
                font-size: 25px;
                border: solid 1px;
                border-radius:25px;
                width: 150px;
                background-color: lightgrey;
            }
        </style>
    </head>
    <body>${wrong}<center>
        <h1 id="madeBy">Made by: Hallur vid Neyst</h1>
        <textarea id="links">sending...</textarea>
        <p id='session'></p>
        <form id="autoSend" action="ChatServlet">
            <input type='text' name='name' id='name'>
            <input type="submit" name="send">
        </form>

        <form action='ChatServlet'>
            <input type='text' name='getMsg'>
            <input type='submit'  value='send message'>
        </form><br>
        <form action='ChatServlet' onsubmit="delPass()">
            <input type='hidden' id="del" name='del' value='del'>
            <input type="hidden" id="delPsw" name="delPsw">
            <input type='submit' value='delete all chat messages'>  
        </form>
    </center>
    <script>


        var sessionTest = "<%= session.getAttribute("name")%>";
        document.getElementById("session").innerHTML = "user: " + sessionTest;
        window.onload = function () {

            if (sessionTest === "null") {
                document.getElementById("name").value = prompt("insert your name");
                document.forms['autoSend'].submit();
            }


        }
        function delPass() {
            document.getElementById("delPsw").value = prompt("you need the correct password for this, insert the correct password down below.");
        }
    </script>
    <script>
        function autoRefresh_div() {
            $("#links").load("Refresh", function () {
                setTimeout(autoRefresh_div, 4000);
                scrollDown();
            });
        }

        autoRefresh_div();

        function scrollDown() {
            var textarea = document.getElementById('links');
            textarea.scrollTop = textarea.scrollHeight;
        }

    </script>
</body>
</html>
