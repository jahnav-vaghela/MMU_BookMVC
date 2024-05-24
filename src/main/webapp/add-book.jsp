<%--
  Created by IntelliJ IDEA.
  User: jahnav
  Date: 3/10/2024
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%-- head html --%>
<jsp:include page="templates/head.jsp">
    <jsp:param name="title" value="Add New Book" />
</jsp:include>

<%-- in body start --%>

<div class="ui text container">

    <h1 class="ui dividing header">Add New Book</h1>

    <c:if test="${success > 0}">
        <h2 class="ignored ui warning message"> Book added Successfully.</h2>
    </c:if>

    <c:if test="${success == 0}">
        <h2 class="ignored ui error message"> Error: Book can not added in database.</h2>
    </c:if>

    <form action="" method="POST" class="ui form">
    <div class="field">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
    </div>
    <div class="field">
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required>
    </div>
    <div class="field">
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required>
    </div>
    <div class="field">
        <label for="genres">Genres:</label>
        <input type="text" id="genres" name="genres">
    </div>
    <div class="field">
        <label for="characters">Characters:</label>
        <input type="text" id="characters" name="characters">
    </div>
    <div class="field">
        <label for="synopsis">Synopsis:</label>
        <textarea id="synopsis" name="synopsis" rows="5" required></textarea>
    </div>
    <div class="field">
        <button class="ui button" type="submit">Submit</button>
    </div>
</form>

</div> <!-- container -->

<%-- in body end --%>

<%-- foot html --%>
<jsp:include page="templates/foot.jsp" />
