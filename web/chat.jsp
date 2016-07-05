<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 04.07.2016
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Chat Room</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        function update() {
            $.get("chat", { from : document.getElementById('userId').getAttribute('datafld') }, function(responseText) {
                $("#messageDiv").append(responseText);
            });
        }
        setInterval(update, 1000);
        $(document).on("click", "#sendButton", function() {
            $.post("chat", { from : document.getElementById('userId').getAttribute('datafld'), message : document.getElementById('message').value });
        });
    </script>
</head>
<body>
<div id="userId" datafld="${sessionScope.userId}"></div>
<div>Hello, ${sessionScope.userId}. Type your message below and press "Send" to broadcast it.</div>
<input id="message" type="text" value="message">
<input id="sendButton" type="button" value="Send">
<div id="messageDiv"></div>
</body>
</html>
