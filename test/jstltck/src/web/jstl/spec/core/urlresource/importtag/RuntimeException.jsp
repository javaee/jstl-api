<%@page contentType="text/html"%>
<html>
<head><title>JSP Page</title></head>
<body>

<%! 
    public void throwIt()  {
        throw new RuntimeException("RuntimeException Thrown from included resource");
    }
%>
<% throwIt(); %>
</body>
</html>
