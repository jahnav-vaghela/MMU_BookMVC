<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title> ${param.title} ></title>
    <base href="${pageContext.request.contextPath}">
    <base href=" <%=request.getContextPath()%> ">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/fomantic-ui@2.9.3/dist/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">

</head>
<body>

<div class="ui text container">
    <h1 class="ui center aligned header">Books MVC</h1>
</div> <!-- container -->

<div class="ui stackable container menu pading-10">
    <a class="item header" href="${pageContext.request.contextPath}/"> HOME </a>
    <a class="item" href="${pageContext.request.contextPath}/add-book">ADD BOOK </a>

    <div class="right menu">
        <div class="item">
            <form action="" method="get">
            <div class="ui action left icon input">
                <i class="search icon"></i>
                <input type="text"  name="search" placeholder="Search"/>
                <button type="submit"  class="ui button blue padding-10">Search</button>
            </div>
            </form>
        </div>
        <div class="item">
            <a class="ui button green padding-10" href="${pageContext.request.contextPath}/">Clear</a>
        </div>
    </div>
</div>
