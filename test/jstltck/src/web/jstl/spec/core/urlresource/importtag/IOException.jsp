<%@page contentType="text/html"%>
<html>
<head><title>JSP Page</title></head>
<body>

<%! 
    public void throwIt() throws java.io.IOException {
        throw new java.io.IOException("IOException Thrown from included resource");
    }
%>
<% throwIt(); %>
</body>
</html>
