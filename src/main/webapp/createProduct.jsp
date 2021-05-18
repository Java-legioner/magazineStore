<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="WEB-INF/css/createProduct.css"%>
    </style>
    <title>Create product</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container cont">
    <div class="row center">
        <form class="createProduct">
            <div class="form-group">
                <input type="text" class="form-control productName"
                       placeholder="enter product name">
            </div>
            <div class="form-group">
                <textarea type="text" class="form-control productDescription"
                          placeholder="enter product description"></textarea>
            </div>
            <div class="form-group">
                <input type="number" class="form-control productPrice"
                       placeholder="enter product price">
            </div>

            <button class="btn btn-primary create">Create</button>
        </form>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<script>
    <%@include file="WEB-INF/js/serverCalls.js"%>
</script>
</body>
</html>
