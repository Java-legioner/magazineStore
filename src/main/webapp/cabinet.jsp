<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        <%@include file="WEB-INF/css/cabinet.css"%>
    </style>
    <title>Cabinet</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="container cont">
    <div class="row productsCards">

    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<script>
    <%@include file="WEB-INF/js/cabinet.js"%>
</script>
</body>
</html>
