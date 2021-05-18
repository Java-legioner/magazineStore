
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        <%@include file="WEB-INF/css/bucket.css"%>
    </style>
    <title>Bucket</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container cont">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-6" style="margin-left: 25px">
                        <div class="search-box">
                                <i class="material-icons">&#xE8B6;</i>
                                <input type="text" id="search" class="form-control shadow" placeholder="Search by Name">
                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped">


            </table>
        </div>
    </div>
</div>



<jsp:include page="footer.jsp"></jsp:include>
    <script>
        <%@include file="WEB-INF/js/bucket.js"%>
    </script>
</body>
</html>
